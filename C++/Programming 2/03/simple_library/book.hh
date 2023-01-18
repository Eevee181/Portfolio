/*
 * Ohjelman kirjoittaja
 * Nimi: Eveliina Toivanen
 * E-Mail: toivanen.eveliinarai@gmail.com
 *
 */

#ifndef BOOK_HH
#define BOOK_HH

#include <string>
#include "date.hh"

class Book
{
public:
    Book(const std::string& author, const std::string& name);

    ~Book();

    void print() const;

    void loan(Date& date);
    void renew();
    void give_back();

private:
    std::string author_;
    std::string name_;
    bool loaned_ = false;
    Date loaning_day_;
    Date returning_day_;
};

#endif // BOOK_HH
