# TIEP1.1 Lausekielinen ohjelmointi I
# Harjoitus 6, tehtävä 4
# Eveliina Toivanen (toivanen.eveliinarai@gmail.com)

# Ohjelma tutkii löytyykö käyttäjän syöttämästä merkkijonosta uniikkeja merkkejä.


def laske_yksittäiset_merkit(merkkijono):
    """
    Funktio laskee, kuinka monta kertaa jokainen merkkijonon alkio esiintyy
    merkkijonossa. Jos esiintymisiä on vain yksi, se lisää merkin merkkilistalle,
    jonka pituus annetaan paluuarvona pääfunktioon.

    :param merkkijono: Käyttäjän syöttämä merkkijono.
    :return: Uniikkien merkkien listan pituus.
    """
    merkkilista = []
    for alkio in merkkijono:
        montako = merkkijono.count(alkio)

        if montako == 1:
            merkkilista.append(alkio)

    return len(merkkilista)


def main():
    """
    Pääfunktio tervehtii käyttäjää ja ottaa tältä syötteenä merkkijonon, jonka se lähettää
    laske_yksittäiset_merkit -funktiolle ja tulostaa lopulta paluuarvonaan saaman luvun.

    :return: None
    """
    print("Hello! I count unique characters.")
    print("Please, enter a string:")
    merkkijono = str(input())

    uniikit_luvut = laske_yksittäiset_merkit(merkkijono)

    print(uniikit_luvut, "unique characters found.")


# Kutsutaan pääohjelmaa, jos ohjelmaa ajetaan.
if __name__ == "__main__":
    main()
