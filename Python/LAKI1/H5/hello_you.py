# TIEP1.1 Lausekielinen ohjelmointi I
# Harjoitus 5, tehtävä 6
# Eveliina Toivanen (eveliina.toivanen@tuni.fi)

# Ohjelma tervehtii käyttäjää tämän antamalla nimellä.


def moikkaa(nimi):
    """Funktion parametrina on käyttäjän antama nimi.
    Funktio tulostaa ohjelman tervehdyksen.
    """
    print("Hello, ", nimi, "!", sep="")


def main():
    """"Pääohjelma tulostaa alutervehdyksen ja sen jälkeen kysyy käyttäjältä tämän
    nimeä, jonka se lähettää moikka-funktiolle parametrina.
    """

    print("Hello! I shall say hello to you.")
    print("Please, enter your name:")
    nimi = str(input())

    moikkaa(nimi)


# Kutsutaan pääohjelmaa, jos ohjelmaa ajetaan.
if __name__ == "__main__":
    main()
