# TIEP1.1 Lausekielinen ohjelmointi I
# Mallitentti, tehtävä 3
# Eveliina Toivanen (toivanen.eveliinarai@gmail.com)

# Ohjelma tulostaa kupsahtaneen pyramidin käyttäjän antamien syötteiden mukaan.

merkkijono = ''

print("Hello! I print a figure.")
print("Please, enter a mark:")
merkki = str(input())
print("Please, enter size:")
koko = int(input())

if len(merkki) > 1 or len(merkki) < 1 or koko < 2:
    print("Error!")

else:
    jononpituus = koko + (koko -1)
    valilkm = 0
    merkkijono = merkki*jononpituus
    tulostin = ' '*valilkm + merkkijono
    print(tulostin)

    while koko - 1 > 0:
        koko -= 1
        valilkm += 1
        jononpituus -= 2
        merkkijono = merkki*jononpituus
        tulostin = ' '*valilkm + merkkijono
        print(tulostin)


