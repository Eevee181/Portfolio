# TIEP1.1 Lausekielinen ohjelmointi I
# Harjoitus 4, tehtävä 7
# Eveliina Toivanen (toivanen.eveliinarai@gmail.com)

# Ohjelma kysyy käyttäjältä merkkijonon ja kuinka monen merkin mittaisia merkkijonoja
# käyttäjä haluaa siitä paloiteltavan.
# Ohjelma tulostaa merkkijonon halutuissa paloissa.

print("Hello! I wrap strings into lines.")
print("Please, enter a string:")
merkkijono = str(input())
print("Please, enter line length:")
rivin_pituus = int(input())

if " " in merkkijono:
    print("Error!")
elif rivin_pituus < 1:
    print("Error!")

else:
    for i in range(0, len(merkkijono), rivin_pituus):
        print(merkkijono[i:i+rivin_pituus])


