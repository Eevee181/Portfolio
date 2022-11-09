# TIEP1.1 Lausekielinen ohjelmointi I
# Harjoitus 5, tehtävä 1
# Eveliina Toivanen (eveliina.toivanen@tuni.fi)

# Ohjelma tarkistaa onko käyttäjän syöttämä rekisteritunnus muodollisesti
# oikea. Jos ei ole, ohjelma syöttää virheilmoituksen.

print("Hello! Just checking registration numbers.")
print("Please, enter a registration number:")
rekisteri = str(input())

if len(rekisteri) < 7 or len(rekisteri) > 7:
    print('"', rekisteri, '" is invalid.', sep="")
elif rekisteri[3] is not "-":
    print('"', rekisteri, '" is invalid.', sep="")

else:
    kirjaimet = rekisteri[0:3]
    numerot = rekisteri[4:]

    kirjaimien_tarkistus = kirjaimet.isalpha()
    kirjainkoon_tarkistus = kirjaimet.isupper()
    numerojen_tarkistus = numerot.isdigit()

    if kirjaimien_tarkistus and kirjainkoon_tarkistus and numerojen_tarkistus:
        print('"', rekisteri, '" is valid.', sep="")
    else:
        print('"', rekisteri, '" is invalid.', sep="")
