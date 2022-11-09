# TIEP1.1 Lausekielinen ohjelmointi I
# Harjoitus 4, tehtävä 5
# Eveliina Toivanen (eveliina.toivanen@tuni.fi)

# Ohjelma kysyy käyttäjältä merkkijonoa ja merkkijonon kahta indeksiä, joilta tämä
# haluaa tarkastaa, ovatko ne samanlaisia vai erilaisia.

indeksiarvo = True

print('Hello! I compare two characters of a string.')
print('Please, enter string:')
merkkijono = str(input())

print('Please, enter the first position:')
indeksi_1 = int(input())
print('Please, enter the second position:')
indeksi_2 = int(input())

# Tarkistetaan ovatko annetut indeksit laillisella indeksiarvojen välillä.
if not -len(merkkijono) <= indeksi_1 <= len(merkkijono) - 1:
    indeksiarvo = False
if not -len(merkkijono) <= indeksi_2 <= len(merkkijono) - 1:
    indeksiarvo = False

# Jos indeksit ovat sallittu, tarkistetaan, onko niiden paikalla samat merkit vai ei.
if indeksiarvo is True:
    if merkkijono[indeksi_1] == merkkijono[indeksi_2]:
        print('"', merkkijono[indeksi_1], '" is equal to "', merkkijono[indeksi_2], '".', sep='')
    elif merkkijono[indeksi_1] != merkkijono[indeksi_2]:
        print('"', merkkijono[indeksi_1], '" is different from "', merkkijono[indeksi_2],'".',
              sep='')

else:
    print('Error!')

