# TIEP1.1 Lausekielinen ohjelmointi I
# Mallitentti, tehtävä 2
# Eveliina Toivanen (eveliina.toivanen@tuni.fi)

# Tehtävä tarkistaa onko käyttäjän syöttämät kurssikoodit oikean muotoisia.

print("Hello! I evaluate course codes.")
print("Please, enter a code:")
kurssikoodi = str(input())

if 'A' in kurssikoodi or 'P' in kurssikoodi or 'S' in kurssikoodi:
    for merkki in kurssikoodi:
        if merkki is 'A' or merkki is 'P' or merkki is 'S':
            merkit = kurssikoodi.split(merkki)

    kirjaimet = merkit[0]
    numerot = merkit[1]

    if len(kirjaimet) >= 3 and len(numerot) >= 1:
        kirjain_tarkistus = kirjaimet.isalpha()
        kirjainkoon_tarkistus = kirjaimet.isupper()
        numero_tarkistus = numerot.isdigit()

        if kirjain_tarkistus and kirjainkoon_tarkistus and numero_tarkistus:
            print("Valid code.")

        else:
            print("Invalid code.")

    else:
        print("Invalid code.")

else:
    print("Invalid code.")