#include "book.hh"
#include "date.hh"
#include <iostream>

Book::Book(const std::string& author, const std::string& name):
author_(author), name_(name){
}

Book::~Book()
{
}

void Book :: print() const{
    std::cout<< author_ << " : " << name_ <<std::endl;
    if(loaned_){
        std::cout<< "- loaned: ";
        loaning_day_.print();
        std::cout<< "- to be returned: ";
        returning_day_.print();
    }else{
        std::cout<< "- available" <<std::endl;
    }
}

void Book :: loan(Date& date){
    if(loaned_){
        std::cout<< "Already loaned: cannot be loaned" <<std::endl;
    }else{
        loaning_day_ = date;
        date.advance(28);
        returning_day_ = date;
        loaned_ = true;
    }
}

void Book :: renew(){
    if(loaned_){
        returning_day_.advance(28);
    }else{
        std::cout<< "Not loaned: cannot be renewed" <<std::endl;
    }

}

void Book :: give_back(){
    loaned_ = false;
}
