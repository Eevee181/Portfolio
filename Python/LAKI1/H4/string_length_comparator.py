# TIEP1.1 Lausekielinen ohjelmointi I
# Harjoitus 4, tehtävä 4
# Eveliina Toivanen (toivanen.eveliinarai@gmail.com)

# Ohjelma kysyy käyttäjältä kaksi merkkijonoa ja tarkastaa, ovatko ne yhtä pitkiä
# vai onko jompi kumpi jonoista pidempi ja kertoo tuloksen tulosteessa.

print('Hello! I compare the lengths of two strings.')
print('Please, enter the first string:')
merkkijono_1 = str(input())
print('Please, enter the second string:')
merkkijono_2 = str(input())

if len(merkkijono_1) < len(merkkijono_2):
    print('"', merkkijono_1, '" is shorter than "', merkkijono_2, '".', sep='')

if len(merkkijono_1) == len(merkkijono_2):
    print('"', merkkijono_1,'" is as long as "', merkkijono_2,'".', sep='')

if len(merkkijono_1) > len(merkkijono_2):
    print('"', merkkijono_1, '" is longer than "', merkkijono_2, '".', sep='')

