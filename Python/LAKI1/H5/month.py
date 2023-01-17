# TIEP1.1 Lausekielinen ohjelmointi I
# Harjoitus 5, tehtävä 7
# Eveliina Toivanen (toivanen.eveliinarai@gmail.com)

# Ohjelma tulostaa käyttäjän antamaa numeroa vastaavan kuukauden sanakirjasta.


def lausu_kuukauden_nimi(numero):
    """"
    Funktio printtaa parametriarvonaan saadun numeron arvoparin sanakirjasta.
    """
    kuukaudet = {1: "January", 2: "February", 3: "March", 4: "April", 5: "May", 6: "June",
                 7: "July", 8: "August", 9: "September", 10: "October", 11: "November",
                 12: "December"}
    print("It is ", kuukaudet[numero], ".", sep="")


def main():
    """"
    Funktio tervehtii käyttäjää ja pyytää tältä numeroa, jonka funktio lähettää
    lausu_kuukauden_nimi -funktiolle.
    """
    print("Hello! I verbalise your input.")
    print("Please, enter a number:")
    kuukauden_numero = int(input())

    lausu_kuukauden_nimi(kuukauden_numero)


# Kutsutaan pääohjelmaa, jos ohjelmaa ajetaan.
if __name__ == "__main__":
    main()
