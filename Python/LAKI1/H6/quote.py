# TIEP1.1 Lausekielinen ohjelmointi I
# Harjoitus 6, tehtävä 2
# Eveliina Toivanen (toivanen.eveliinarai@gmail.com)

# Ohjelmassa lisätään lainausmerkit käyttäjän antamalle syötteelle.


def lainaa(sanoma, totuusarvo=True):
    """
    Funktio tarkastaa totuusarvon ja palauttaa sen mukaisen merkkijonon pääohjelmalle.

    :param sanoma: Merkkijono, jonka käyttäjä haluaa lainata.
    :param totuusarvo: Boolean, jonka mukaan lainaus tehdään joko yksin- tai
           kaksinkertaisilla lainausmerkeillä.
    :return: Sanoma yksinkertaisilla lainausmerkeillä, jos totuusarvo on False.
             Sanoma kaksinkertaisilla lainausmerkeillä, jos totuusarvo on True.
    """
    if totuusarvo is False:
        return "'{}'".format(sanoma)
    else:
        return "\"{}\"".format(sanoma)


def main():
    """
    Pääohjelma tervehtii käyttäjää ja kerää syötteen. Se lähettää merkkijonon lainaa-funktiolle
    tarkastukseen ja tulostaa paluuarvona tulleet merkkijonot, joista ensimmäisellä on
    kaksoislainausmerkit.

    :return: NONE
    """
    print("You say, I quote.")
    print("Please, say something:")
    sanoma = str(input())

    vain_sanoma = lainaa(sanoma)
    epatosi_sanoma = lainaa(sanoma, False)

    print("You said:", vain_sanoma)
    print("You said:", epatosi_sanoma)


# Kutsutaan pääohjelmaa, jos ohjelma ajetaan.
if __name__ == "__main__":
    main()
