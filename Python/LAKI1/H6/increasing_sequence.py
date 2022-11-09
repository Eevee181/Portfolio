# TIEP1.1 Lausekielinen ohjelmointi I
# Harjoitus 6, tehtävä 5
# Eveliina Toivanen (eveliina.toivanen@tuni.fi)

# Ohjelma tarkistaa, onko käyttäjän syöttämä lukujono kasvava vai ei.


def onko_kasvava(lukulista):
    """
    Funktio tutkii, onko lukujonosta tehty lista kasvavassa järjestyksessä vai
     ei ja palauttaa sen mukaisen totuusarvon takaisin pääfunktiolle.

    :param lukulista: Käyttäjän syöttämästä lukujonosta tehty lista.
    :return: True, jos lukujono on kasvava
             False, jos lukujono ei ole kasvava
    """
    if lukulista != sorted(lukulista):
        return False
    elif lukulista == sorted(lukulista):
        return True


def main():
    """
    Tervehditään käyttäjää ja pyydetään lukujonoa syötteessä. Lukujono paloitellaan
    listaksi, joka lähetetään onko_kasvava -funktiolle. Paluuarvon mukaan tulostetaan
    lopputuloste.

    :return: None
    """
    print("Hello! I determine whether a sequence is increasing.")
    print("Please, enter an integer sequence:")
    merkkijono = str(input())

    lukulista = merkkijono.split()
    kasvutarkastus = onko_kasvava(lukulista)

    if kasvutarkastus is False:
        print("The sequence is not increasing.")
    if kasvutarkastus is True:
        print("The sequence is increasing.")


# Kutsutaan pääohjelmaa, jos ohjelmaa ajetaan.
if __name__ == "__main__":
    main()
