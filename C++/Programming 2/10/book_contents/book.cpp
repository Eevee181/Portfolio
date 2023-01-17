/*
#############################################################################
# COMP.CS.110 Programming 2, Autumn 2022                                    #
# Project3: Book contents                                                   #
# File: book.cpp                                                            #
# Description: Interface of book and its content for the program with the   #
#           following operations:                                           #
#           * Prints all books' IDs and their content                       #
#           * Add chapters and subchapters to the book                      #
#           * Add relations between the given chapters                      #
#           * Closes and opens chapters the given chapter.                  #
#             If headchapter get closed then its subchapters with other     #
#             subchapters will be closed too. You can also open all the     #
#             chapters with command.                                        #
#           * Prints the given chapter's total length                       #
#           * Prints longest or shortest chapter in the given chapter's     #
#             hierarchy.                                                    #
#           * Prints the given chapter's siblings and their count           #
#           * Prints the given chapter's parents to the given level.        #
#           * Prints the given chapter's subchapters to the given level.    #
#           * The program also check for errors regarding these             #
#             functionalities and prints error messages when needed.        #
#                                                                           #
# Notes:                                                                    #
# Check the book.hh for more info.                                          #
#############################################################################
*/

#include "book.hh"

Book::Book() :
    chapters_({})
{

}


Book::~Book()
{
    for (auto const& pair : chapters_)
    {
        delete pair.second;
    }
}


void Book::addNewChapter(const std::string &id, const std::string &fullName, int length)
{
    if(chapterExists(id))
    {
        std::cout << "Error: Already exists." << std::endl;
        return;
    }

    Chapter *new_chap = new Chapter{};
    new_chap->id_ = id;
    new_chap->fullName_ = fullName;
    new_chap->length_ = length;
    chapters_.insert({new_chap->id_, new_chap});
}


void Book::addRelation(const std::string &subchapter, const std::string &parentChapter)
{
    if(chapterExists(subchapter) && chapterExists(parentChapter))
    {
        Chapter *parent = chapters_.at(parentChapter),
                *child = chapters_.at(subchapter);

        parent->subchapters_.push_back(child);
        child->parentChapter_ = parent;
    }
}


void Book::printIds(Params) const
{
    std::vector<std::string> chapNames = {};
    for(auto& chap : chapters_)
    {
        chapNames.push_back(chap.second->fullName_);
    }

    std::sort (chapNames.begin(), chapNames.end());

    std::cout << "Book has " << chapNames.size() << " chapters:" << std::endl;
    for(auto& name : chapNames)
    {
        for(auto& chap : chapters_)
        {
            if(name == chap.second->fullName_)
            {
                std::cout << name << " --- " << chap.first << std::endl;
            }
        }

    }
}


void Book::printContents(Params) const
{

    std::vector<Chapter*> headChapters = {};

    bool is_firstChap = true;
    Chapter* firstChapTemporaryContainer;
    for(auto& chap : chapters_)
    {
        if(!is_firstChap && chap.second->parentChapter_ == nullptr)
        {
            headChapters.push_back(chap.second);
        }

        // if the chapter is the first in the loop,
        // it will be saved to a helper and push in the vector as last element.
        if(is_firstChap)
        {
            firstChapTemporaryContainer = chap.second;
            is_firstChap = false;
        }
    }

    headChapters.push_back(firstChapTemporaryContainer);


    int index = 1;
    for(Chapter *ptr : headChapters)
    {
        printChapsRecursive(ptr, index, " ");
        index ++;
    }

}


void Book::close(Params params) const
{
    if(chapterExists(params.at(0)))
    {
        std::string closing_id = params.at(0);

        Chapter *chap = findChapter(closing_id);
        chap->isChapOpen = false;

        std::vector<Chapter*> subVector = returnSubChaptersRecursive(chap);
        for(auto& subChap : subVector)
        {
            if(!subChap->subchapters_.empty())
            {
                subChap->isChapOpen = false;
            }
        }
    }
    else{
        printErrorIDNotFound(params.at(0));
    }

}


void Book::open(Params params) const
{
    if(chapterExists(params.at(0)))
    {
        std::string opening_id = params.at(0);

        Chapter *chap = findChapter(opening_id);
        chap->isChapOpen = true;
    }
    else{
        printErrorIDNotFound(params.at(0));
    }
}


void Book::openAll(Params) const
{
    for(auto& chap : chapters_)
    {
        chap.second->isChapOpen = true;
    }
}


void Book::printParentsN(Params params) const
{
    if(chapterExists(params.at(0)))
    {
        std::string id = params.at(0);
        int n = stoi(params.at(1));

        if(n > 0)
        {
            Chapter *chap = findChapter(id);
            std::vector<Chapter*> parentVector = getChaptersParents(chap, n);

            if(!parentVector.empty())
            {
                // Turn vector to a set for printing.
                IdSet parents = vectorToIdSet(parentVector);
                std::cout << id << " has " << parentVector.size() << " parent chapters:" << std::endl;
                for(auto& parent : parents)
                {
                    std::cout << parent << std::endl;
                }
            }

            else
            {
                printErrorPrintingNotFound(id, "parent chapters");
            }
        }
        else{
            std::cout << "Error. Level can't be less than 1." << std::endl;
        }


    }
    else{
        printErrorIDNotFound(params.at(0));
    }
}


void Book::printSubchaptersN(Params params) const
{
    if(chapterExists(params.at(0)))
    {
        std::string id = params.at(0);
        int n = stoi(params.at(1));
        if(n > 0)
        {
            Chapter *chap = findChapter(id);
            std::vector<Chapter*> subVector = getSubchaptersToGivenLevel(chap, n);

            if(!subVector.empty())
            {
                // Turn vector to a set for printing.
                IdSet subChapters = vectorToIdSet(subVector);
                std::cout << id << " has " << subVector.size() <<" subchapters:" << std::endl;
                for(auto& subChapter : subChapters)
                {
                    std::cout << subChapter << std::endl;
                }
            }
            else
            {
                printErrorPrintingNotFound(id, "subchapters");
            }
        }
        else
        {
            std::cout << "Error. Level can't be less than 1." << std::endl;
        }
    }
    else{
        printErrorIDNotFound(params.at(0));
    }
}


void Book::printSiblingChapters(Params params) const
{ 
    std::string id = params.at(0);

    if(chapterExists(id))
    {

        Chapter *chap = findChapter(id);
        Chapter *parent = chap->parentChapter_;

        // Check if the chapter has a parent.
        if(parent == nullptr)
        {
            printErrorPrintingNotFound(chap->id_, "sibling chapters");
            return;
        }

        std::vector<Chapter*> siblings = parent->subchapters_;
        if(siblings.size()>1)
        {
            int sibling_count = siblings.size() - 1 ;
            std::sort (siblings.begin(), siblings.end());

            std::cout << id << " has " << sibling_count << " sibling chapters:" << std::endl;
            for(auto& sibling_chap : siblings)
            {
                if(sibling_chap->id_ != id)
                {
                    std::cout << sibling_chap->id_ << std::endl;
                }
            }
        }
        else
        {
            printErrorPrintingNotFound(id, "sibling chapters");
        }

    }
    else
    {
        printErrorIDNotFound(id);
    }

}


void Book::printTotalLength(Params params) const
{
    if(chapterExists(params.at(0)))
    {
        Chapter *chap = findChapter(params.at(0));
        int totalLength = chap->length_;

        totalLength += countSubLengthRecursive(chap);

        std::cout << "Total length of " << chap->id_ << " is " <<
                     totalLength << "." << std::endl;
    }
    else{
        printErrorIDNotFound(params.at(0));
    }
}


void Book::printLongestInHierarchy(Params params) const
{
    if(chapterExists(params.at(0)))
    {
        Chapter *chap = findChapter(params.at(0));
        Chapter* longestChap = findLongestChapterinHierarchy(chap);

        if(chap != longestChap)
        {
            std::cout << "With the length of " << longestChap->length_ << ", " <<
                         longestChap->id_ << " is the longest chapter in " <<
                         chap->id_ << "'s hierarchy." << std::endl;
        }
        else
        {
            std::cout << "With the length of " << chap->length_ << ", " <<
                         chap->id_ << " is the longest chapter in their hierarchy." <<
                         std::endl;
        }
    }
    else{
        printErrorIDNotFound(params.at(0));
    }
}


void Book::printShortestInHierarchy(Params params) const
{
    if(chapterExists(params.at(0)))
    {
        Chapter *chap = findChapter(params.at(0));
        Chapter* shortestChap = findShortestChapterinHierarchy(chap);

        if(chap != shortestChap)
        {
            std::cout << "With the length of " << shortestChap->length_ << ", " <<
                         shortestChap->id_ << " is the shortest chapter in " <<
                         chap->id_ << "'s hierarchy." << std::endl;
        }
        else
        {
            std::cout << "With the length of " << chap->length_ << ", " <<
                         chap->id_ << " is the shortest chapter in their hierarchy." <<
                         std::endl;
        }
    }
    else{
        printErrorIDNotFound(params.at(0));
    }
}


Chapter *Book::findChapter(const std::string &id) const
{
    Chapter *ptr = nullptr;
    if(chapterExists(id))
    {
        ptr = chapters_.at(id);


    }
    return ptr;
}


Chapter *Book::findLongestChapterinHierarchy(Chapter *chap) const
{
    int longest = chap->length_;
    Chapter* longestChap = chap;

    // Find all the chapters in the given chapter's hierarchy.
    std::vector<Chapter*> subVector = returnSubChaptersRecursive(chap);

    for(auto& subChapter : subVector)
    {
        if(longest < subChapter->length_)
        {
            longest = subChapter->length_;
            longestChap = subChapter;
        }
    }

    return longestChap;
}


Chapter *Book::findShortestChapterinHierarchy(Chapter *chap) const
{
    int shortest = chap->length_;
    Chapter* shortestChap = chap;

    // Find all the chapters in the given chapter's hierarchy.
    std::vector<Chapter*> subVector = returnSubChaptersRecursive(chap);

    for(auto& subChapter : subVector)
    {
        if(shortest > subChapter->length_)
        {
            shortest = subChapter->length_;
            shortestChap = subChapter;
        }
    }

    return shortestChap;
}


bool Book::chapterExists(const std::string &id) const
{
    return chapters_.find(id) != chapters_.end();
}


IdSet Book::vectorToIdSet(const std::vector<Chapter *> &container) const
{
    IdSet allIDs = {};
    for(Chapter *ptr : container)
    {
        allIDs.insert(ptr->id_);
    }

    return allIDs;
}


void Book::printChapsRecursive(Chapter *chap,
                               int index,
                               const std::string &identation) const
{
    char sign = chap->isChapOpen ? '-' : '+';

    std::cout << sign << identation << index << ". " <<
                 chap->fullName_ << " ( " <<
                 chap->length_ << " )" << std::endl;


    //Trivial case: no subchapters
    if(!chap->isChapOpen || chap->subchapters_.empty()){return;}

    index = 1;
    for(Chapter *subchap : chap->subchapters_)
    {
        printChapsRecursive(subchap, index, identation + "  ");
        index ++;
    }

}


int Book::countSubLengthRecursive(Chapter *chap) const
{
    // Trivial case: no subchapters.
    if(chap->subchapters_.empty()){return 0;}

    int totalLength = 0;
    for(Chapter *subchap : chap->subchapters_)
    {
        totalLength += subchap->length_;
        totalLength += countSubLengthRecursive(subchap);
    }

    return totalLength;
}


std::vector<Chapter *> Book::returnSubChaptersRecursive(Chapter *chap) const
{
    // Trivial case: no subchapters.
    if(chap->subchapters_.empty()){return {};}

    std::vector<Chapter*> subChapters;
    for(Chapter *subchap : chap->subchapters_)
    {
        //Finding all the subchapters by using recursion
        std::vector<Chapter*> subVector = returnSubChaptersRecursive(subchap);
        subChapters.push_back(subchap);
        subChapters.insert(subChapters.end(), subVector.begin(), subVector.end());
    }

    return subChapters;
}


std::vector<Chapter *> Book::getChaptersParents(Chapter *chap, int num) const
{
    std::vector<Chapter*> parentVector = {};
    Chapter *currentChap = chap;

    // Stop search to the given level.
    while(num != 0)
    {
        if(currentChap->parentChapter_ != nullptr)
        {
            parentVector.push_back(currentChap->parentChapter_);
            currentChap = currentChap->parentChapter_;
            num--;
        }
        else
        {
            break;
        }
    }

    return parentVector;
}


std::vector<Chapter *> Book::getSubchaptersToGivenLevel(Chapter *chap, int num) const
{
    std::vector<Chapter*> currentSubchaps = chap->subchapters_;
    std::vector<Chapter*> nextSubchaps;
    std::vector<Chapter*> subVector = chap->subchapters_;


    if(!currentSubchaps.empty())
    {
        // Stop search after the given level.
        // Starts from 1 because first subchapters are already in the vector.
        for(int i = 1 ; i < num; i++)
        {
            for(auto& subChap : currentSubchaps)
            {
                subVector.insert(subVector.end(), subChap->subchapters_.begin(), subChap->subchapters_.end());
                nextSubchaps.insert(nextSubchaps.end(), subChap->subchapters_.begin(), subChap->subchapters_.end());
            }

            currentSubchaps = nextSubchaps;
            nextSubchaps.clear();
        }

        return subVector;
    }
    else{return {};}
}


void Book::printErrorIDNotFound(std::string id) const
{
    std::cout << "Error: Not found: " << id << std::endl;
}


void Book::printErrorPrintingNotFound(std::string id, std::string group) const
{
    std::cout << id << " has no " << group << "." << std::endl;
}


