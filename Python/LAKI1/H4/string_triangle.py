# TIEP1.1 Lausekielinen ohjelmointi I
# Harjoitus 4, tehtävä 6
# Eveliina Toivanen (toivanen.eveliinarai@gmail.com)

# Ohjelma kysyy käyttäjältä merkkijonon ja tulostaa sen "kolmion" muotoon lisäämällä
# aina yhden kirjaimen merkkijonosta seuraavalle riville.
# Ohjelma tulostaa virhetulosteen, jos syötteessä esiintyy välilyönti.

merkkijono_2 = ""

print("Hello! I print a triangle made of prefixes of a string.")
print("Please, enter a string:")
merkkijono = str(input())

if " " in merkkijono:
    print("Error!")

else:
    for i in range(len(merkkijono)):
        merkkijono_2 += merkkijono[i]
        print(merkkijono_2)

