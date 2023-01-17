# TIEP1.1 Lausekielinen ohjelmointi I
# Harjoitus 6, tehtävä 1
# Eveliina Toivanen (toivanen.eveliinarai@gmail.com)

# Ohjelma tarkistaa käyttäjän antamista syötteistä etumerkit ja katsoo onko ne samat.
# Ohjelma kertoo viimeisessä tulosteessa, ovatko merkit samat vai ei.


def samat_etumerkit(luku_1, luku_2):
    """
    Funktio tarkastaa, onko käyttäjän syöttämillä luvuilla sama etumerkki vai ei.

    :param luku_1: Käyttäjän ensimmäiseksi syöttämä luku.
    :param luku_2: Käyttäjän toiseksi syöttämä luku.
    :return: True, jos etumerkit ovat samat.
             False, jos etumerkit eivät täsmää.
    """
    if luku_1 >= 0 and luku_2 >= 0:
        tarkastus = True
    elif luku_1 < 0 and luku_2 < 0:
        tarkastus = True
    else:
        tarkastus = False

    return tarkastus


def main():
    """
    Pääfunktiossa tervehditään käyttäjää ja pyydetään tältä tulosteet. Tulosteet lähetetään
    tarkastuksen tekevälle funktiolle, jonka paluuarvo tarkastetaan ja sen perusteella tehdään
    lopputuloste.
    """
    print("Hello! I compare signs.")
    print("Enter the first integer:")
    luku_1 = int(input())
    print("Enter the second integer:")
    luku_2 = int(input())

    tarkastus = samat_etumerkit(luku_1, luku_2)

    if tarkastus is True:
        print("The signs are the same.")
    else:
        print("The signs are different.")


# Kutsutaan pääohjelmaa, jos ohjelmaa ajetaan.
if __name__ == "__main__":
    main()
