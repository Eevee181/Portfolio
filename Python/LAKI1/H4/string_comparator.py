# TIEP1.1 Lausekielinen ohjelmointi I
# Harjoitus 4, tehtävä 3
# Eveliina Toivanen (eveliina.toivanen@tuni.fi)

# Ohjelma lukee käyttäjältä kaksi merkkijonoa ja tarkistaa, ovatko ne samanlaiset vai
# erilaiset.
# Ohjelma jatkaa merkkijonojen kyselyä niin kauan, että käyttäjä antaa molemmiksi syötteiksi
# "xyz"

LOPETUSJONO = 'xyz'

print('Hello! I compare strings.')
print('Please, enter the first string:')
merkkijono_1 = str(input())
print('Please, enter the second string:')
merkkijono_2 = str(input())

while merkkijono_1 != LOPETUSJONO and merkkijono_2 != LOPETUSJONO:
    if merkkijono_1 == merkkijono_2:
        print('"', merkkijono_1, '" is equal to "', merkkijono_2, '".', sep="")
    elif merkkijono_1 != merkkijono_2:
        print('"', merkkijono_1, '" is different from "', merkkijono_2, '".', sep="")

    print('Please, enter the first string:')
    merkkijono_1 = str(input())
    print('Please, enter the second string:')
    merkkijono_2 = str(input())

