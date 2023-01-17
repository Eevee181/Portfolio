#include "account.hh"
#include <iostream>

Account::Account(const std::string& owner, bool has_credit):
owner_(owner), has_credit_(has_credit){
    generate_iban();
    saldo_ = 0;
}

// Setting initial value for the static attribute running_number_
int Account::running_number_ = 0;

void Account::generate_iban()
{
    ++running_number_;
    std::string suffix = "";
    if(running_number_ < 10)
    {
        suffix.append("0");
    }
    else if(running_number_ > 99)
    {
        std::cout << "Too many accounts" << std::endl;
    }
    suffix.append(std::to_string(running_number_));

    iban_ = "FI00 1234 ";
    iban_.append(suffix);
}

void Account :: print() const{
    std::cout << owner_ << " : " << iban_ << " : " << saldo_ << " euros" << std::endl;
}

void Account :: set_credit_limit(int limit){
    if(has_credit_){
        credit_limit_ = 0 - limit;
    }else{
        std::cout << "Cannot set credit limit: the account has no credit card" << std::endl;
    }

}

void Account :: save_money(int numb){
    saldo_ += numb;
}

bool Account :: take_money(int money){
    if(not has_credit_ and money <= saldo_){
        saldo_ -= money;
        std::cout << money << " euros taken: new balance of " << iban_ << " is " << saldo_ << " euros" <<std::endl;
        return true;
    }
    else if(has_credit_){
        if(saldo_ - money >= credit_limit_){
            saldo_ -= money;
            std::cout << money << " euros taken: new balance of " << iban_ << " is " << saldo_ << " euros" <<std::endl;
            return true;
        }else{
            std::cout << "Cannot take money: balance underflow" <<std::endl;
            return false;
        }

    }
    else{
        std::cout << "Cannot take money: balance underflow" <<std::endl;
        return false;
    }
}

void Account :: transfer_to(Account& account, int mon){
    if(saldo_ - mon){
        if(take_money(mon)){
            account.save_money(mon);
        }else{
            std::cout << "Transfer from " << iban_ << " failed" <<std::endl;
        }
    }



}
