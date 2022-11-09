# TIEP1.1 Lausekielinen ohjelmointi I
# Tentti, tehtävä 3
# Eveliina Toivanen (eveliina.toivanen@tuni.fi)

# Ohjelma laskee käyttäjän antamien indeksiarvojen väliin kuuluvien
# kokonaislukujen listan alkioiden summan ja tulostaa sen lopuksi.


def summaa_väli(numerolista, indeksi_a, indeksi_b):
    summa = 0

    if indeksi_a < 0 or indeksi_b >= len(numerolista):
        return None
    elif indeksi_a > indeksi_b or numerolista == []:
        return None
    else:
        summattavien_lista = numerolista[indeksi_a:indeksi_b + 1]
        for alkio in summattavien_lista:
            summa += alkio
        return summa


def main():
    numerolista = []

    print("Hello! I sum elements.")
    print("Please, enter the number of integers:")
    numeroiden_lkm = int(input())

    while numeroiden_lkm > 0:
        print("Please, enter an integer:")
        numero = int(input())
        numerolista.append(numero)
        numeroiden_lkm -= 1

    print("Please, enter a lower bound:")
    indeksi_a = int(input())
    print("Please, enter an upper bound:")
    indeksi_b = int(input())

    numeroiden_summa = summaa_väli(numerolista, indeksi_a, indeksi_b)

    if numeroiden_summa is None:
        print("Could not compute!")
    else:
        print("The sum is {:1d}.".format(numeroiden_summa))


# Kutsutaan pääohjelmaa, jos ohjelmaa ajetaan
if __name__ == "__main__":
    main()
