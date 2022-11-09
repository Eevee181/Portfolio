# TIEP1.1 Lausekielinen ohjelmointi I
# Harjoitus 5, tehtävä 5
# Eveliina Toivanen (eveliina.toivanen@tuni.fi)

# Ohjelma kysyy käyttäjältä tämän lempivuodenaikaa vastaavaa numeroa
# ja sen jälkeen tarkistaa, onko annettu numero sallittu.
# Jos on, ohjelma ilmoittaa käyttäjän suosikkivuodenajan.

vuodenajat = {1: "winter", 2: "spring", 3: "summer", 4: "autumn"}

print("Hello! I read and tell.")
print("Which do you like most: 1) winter, 2) spring, 3) summer, 4) autumn?")
vuodenaika_numero = int(input())

# Tarkastetaan onko kokonaisluku oikea vai virheellinen.
# Jos virheellinen, tulostetaan virhelilmoitus.
if vuodenaika_numero < 1 or vuodenaika_numero > 4:
    print("Your favourite season of the year is unknown.")

else:
    print("Your favourite season of the year is ",
          vuodenajat[vuodenaika_numero], ".", sep="")
