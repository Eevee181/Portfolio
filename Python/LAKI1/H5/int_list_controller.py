# TIEP1.1 Lausekielinen ohjelmointi I
# Harjoitus 5, tehtävä 4
# Eveliina Toivanen (eveliina.toivanen@tuni.fi)

# Komennot vakioina.
LISAA = 'add'
POISTA = 'remove'
TULOSTA = 'print'
SUMMA = 'sum'
LOPPU = 'exit'

kokonaislukulista = []
apulista = []
jatkuu = True

summa = 0

print('Hello! I control a list.')

# Luupissa suoritetaan komennot.
while jatkuu:
    print('Please, enter a command:')
    vastaus = str(input())

    jaottelu = vastaus.split()
    tehtava = jaottelu[0]

    # Loppu-komennolla pysäytetään luuppi ja samalla ohjelma.
    if tehtava == LOPPU:
        jatkuu = False

    # Summa-komento laskee listan alkiot yhteen
    if tehtava == SUMMA:
        if not kokonaislukulista:
            summa = 0
        else:
            summa = 0
            for i in range(len(kokonaislukulista)):
                summa = summa + kokonaislukulista[i]
        print(summa)

    # Tulosta-komento tulostaa listan.
    if tehtava == TULOSTA:
        print(kokonaislukulista)

    # Lisää-komennolle lisätään vakio listaan
    if tehtava == LISAA:
        luku = int(jaottelu[1])
        kokonaislukulista.append(luku)

    # Poista-komennolla poistetaan alkio listasta.
    if tehtava == POISTA:
        luku = int(jaottelu[1])

        while kokonaislukulista.count(luku) > 0:
            indeksi = kokonaislukulista.index(luku)
            del kokonaislukulista[indeksi]
