# TIEP1.1 Lausekielinen ohjelmointi I
# Harjoitus 6, tehtävä 3
# Eveliina Toivanen (toivanen.eveliinarai@gmail.com)

# Ohjelma laskee kuinka monta kertaa käyttäjän syöttämät merkit esiintyvät hänen
# merkkijonossaan ja kertoo kumpaa merkkiä löytyy enemmän.


def päättele_yleisempi(merkkijono, eka_merkki, toka_merkki):
    """
    Funktio laskee käyttäjän syöttämien merkkien määrän merkkijonossa ja
    palauttaa sen jälkeen sen merkin takaisin pääohjelmalle, joka esiintyy merkkijonossa
    useammin. Ohjelma palauttaa tyhjän, jos merkkejä on saman verran.

    :param merkkijono: Käyttäjän pääohjelmassa syöttämä teksti.
    :param eka_merkki: Käyttäjän ensimmäisenä syöttämä merkki.
    :param toka_merkki: Käyttäjän toisena syöttämä merkki.
    :return: None, jos merkkejä on yhtä paljon
             eka_merkki, jos ensimmäistä merkkiä on toista merkkiä enemmän.
             toka_merkki, jos toista merkkiä on ensimmäistä merkkiä enemmän.
    """
    montako_ekaa = merkkijono.count(eka_merkki)
    montako_tokaa = merkkijono.count(toka_merkki)

    if montako_ekaa == montako_tokaa:
        return None
    elif montako_ekaa < montako_tokaa:
        return toka_merkki
    elif montako_ekaa > montako_tokaa:
        return eka_merkki


def main():
    """
    Pääfunktio tervehtii käyttäjää ja kysyy tältä syötteet, jotka se lähettää
    päättele-yleisempi -funktiolle, ja tulostaa sen jälkeen tuloksen sen mukaan,
    mitä saa paluuarvona päättele_yleisempi -funktiolta.
    """
    print('Hello! I compare frequencies of two characters.')
    print('Please, enter a string:')
    merkkijono = str(input())
    print('Please, enter the first character:')
    eka_merkki = str(input())
    print('Please, enter the second character:')
    toka_merkki = str(input())

    yleisempi_merkki = päättele_yleisempi(merkkijono, eka_merkki, toka_merkki)

    if yleisempi_merkki is None:
        print('The characters are equally frequent in "', merkkijono, '".', sep='')
    elif yleisempi_merkki == eka_merkki:
        print('"', eka_merkki, '" is more frequent in "', merkkijono, '".', sep='')
    elif yleisempi_merkki == toka_merkki:
        print('"', toka_merkki, '" is more frequent in "', merkkijono, '".', sep='')


# Kutsutaan p??ohjelmaa, jos ohjelmaa ajetaan.
if __name__ == '__main__':
    main()
