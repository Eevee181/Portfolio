/*
 * Ohjelman kirjoittaja
 * Nimi: Eveliina Toivanen
 * E-Mail: toivanen.eveliinarai@gmail.com
 *
 */

#include <iostream>
#include <string>
#include <cctype>

using namespace std;

bool test_check(string test){
    for (size_t i=0;i < test.length();i++){
        if(isupper(test[i])){
            return false;
        }
    }

    return true;
}

bool allalphabet(string key){
    for(char alpha = 'a'; alpha < 'z'; ++alpha ){
        string::size_type temp = key.find(alpha);
        if (temp == string::npos){
            return false;
        }
    }

    return true;
}

void encryption(string key, string plain){
    string enc_msg;
        for(size_t i = 0; i < plain.length(); i++){
            int plain_ascii = static_cast< int >( plain[i] );
            for(size_t j = 0; j < key.length(); j++){
                int key_ascii = 97 + j;
                if (plain_ascii == key_ascii){
                    enc_msg += key[j];
                }
            }
        }

    cout << "Encrypted text: " << enc_msg;
}

int main()
{
    string enc_key = "";
    string plain_msg = "";
    cout << "Enter the encryption key: ";
    cin >> enc_key ;

    if (enc_key.length() != 26){
        cout << "Error! The encryption key must contain 26 characters.";

        return EXIT_FAILURE;
    }

    else if(not test_check(enc_key)){
        cout << "Error! The encryption key must contain only lower case characters.";

        return EXIT_FAILURE;
    }

    else if (not allalphabet(enc_key)){
        cout << "Error! The encryption key must contain all alphabets a-z.";

        return EXIT_FAILURE;
    }else{
        cout << "Enter the text to be encrypted: ";
        cin >> plain_msg;

        if (test_check(plain_msg)){
            encryption(enc_key, plain_msg);
        }else{
            cout << "Error! The text to be encrypted must contain only lower case characters.";

            return EXIT_FAILURE;
        }
    }

    return 0;
}
