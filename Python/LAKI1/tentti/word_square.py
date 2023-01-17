# TIEP1.1 Lausekielinen ohjelmointi I
# Tentti, tehtävä 3
# Eveliina Toivanen (toivanen.eveliinarai@gmail.com)

# Ohjelma kysyy käyttäjältä sanan ja tulostaa siitä sananeliön.

indeksi = 0

print("Hello! I shall square a word.")
print("Please, enter a word:")
sana = str(input())
vaarinpain = sana[::-1]
sanan_pituus = len(sana)

print("Squared:")


if 0 < len(sana) < 2:
    print(sana)

else:
    print(sana)
    while sanan_pituus - 2 > 0:
        sanavali = len(sana) - 2
        indeksi += 1
        kirjain_1 = sana[indeksi]
        kirjain_2 = vaarinpain[indeksi]

        print(kirjain_1, " "*sanavali, kirjain_2, sep="")

        sanan_pituus -= 1

    print(vaarinpain)