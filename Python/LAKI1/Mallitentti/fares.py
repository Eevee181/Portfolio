# TIEP1.1 Lausekielinen ohjelmointi I
# Mallitentti, tehtävä 1
# Eveliina Toivanen (eveliina.toivanen@tuni.fi)

# Ohjelma tarkastaa käyttäjän antamasta syötteestä matkustajan iän ja
# matkustusajan ja tulostaa näiden mukaisen lippuhinnan.

HINTA_PAIVA = 2.7
HINTA_ILTA = 3.5
HINTA_YO = 4.0

print("Hello! I determine fares.")
print("Enter time:")
aika = float(input())
print("Enter age:")
ika = int(input())

if 0 <= ika <= 2:
    print("0.0 euros.")
else:
    if 6.00 <= aika <= 17.59:
        if 16 <= ika <= 65:
            print("{:1.1f} euros.".format(HINTA_PAIVA))
        elif 3 <= ika <= 15 or ika > 65:
            hinta = HINTA_PAIVA - 1
            print("{:1.1f} euros.".format(hinta))
    elif 18.00 <= aika <= 22.59:
        if 16 <= ika <= 65:
            print("{:1.1f} euros.".format(HINTA_ILTA))
        elif 3 <= ika <= 15 or ika > 65:
            hinta = HINTA_ILTA - 1
            print("{:1.1f} euros.".format(hinta))
    elif aika >= 23.00 or aika <= 5.00:
        if 16 <= ika <= 65:
            print("{:1.1f} euros.".format(HINTA_YO))
        elif 3 <= ika <= 15 or ika > 65:
            hinta = HINTA_YO - 1
            print("{:1.1f} euros.".format(hinta))


