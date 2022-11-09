# TIEP1.1 Lausekielinen ohjelmointi I
# Harjoitus 6, tehtävä 5
# Eveliina Toivanen (eveliina.toivanen@tuni.fi)

# Ohjelma laskee käyttäjän antamista luvuista suurimman ja pienimmän, sekä
# niiden yhteisen keskiarvon.


def laske_tunnusluvut(lukulista):
    """
    Funktio laskee lukulistan pienimmän ja suurimman arvon, sekä laskee listan
    lukujen keskiarvon ja palauttaa ne tuplana pääfunktiolle.

    :param lukulista: Käyttäjän syöttämistä luvuista tehty lista.
    :return: Tupla, jossa on lukulistan minimi-, keski- ja maksimiarvot.
    """
    summa = 0

    if not lukulista:
        lukutupla = (None, None, None)

    elif lukulista:
        minimi = min(lukulista)
        maksimi = max(lukulista)

        for luku in lukulista:
            summa += luku

        keskiarvo = summa / len(lukulista)

        lukutupla = (minimi, keskiarvo, maksimi)

    return lukutupla


def main():
    """
    Funktio tervehtii käyttäjältä ja kysyy kuinka monta numeroa tämä haluaa
    syöttää, jonka jälkeen funktio kokoaa ne luupilla listaan. Virheilmoitus
    tulostuu, jos käyttäjä antaa numeroiden lukumääräksi 1 pienemmän lukumäärän.
     Lista lähetetään laske_tunnusluvut -funktiolle, jonka paluuarvona antama
     lista hajotetaan tulosteeseen.

    :return: None
    """
    lukulista = []

    print("Hello! I count some statistics.")
    print("Please, enter the number of integers:")
    maara = int(input())

    if maara < 1:
        print("Could not compute!")

    else:
        while maara > 0:
            print("Please, enter an integer:")
            luku = int(input())
            lukulista.append(luku)
            maara -= 1

        tunnusluvut = laske_tunnusluvut(lukulista)

        print("min = ", tunnusluvut[0], ", avg = ", tunnusluvut[1], ", max = ",
              tunnusluvut[2], sep="")


# Kutsutaan pääohjelmaa, jos ohjelmaa ajetaan.
if __name__ == "__main__":
    main()
