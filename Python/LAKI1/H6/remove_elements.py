# TIEP1.1 Lausekielinen ohjelmointi I
# Harjoitus 6, tehtävä 7
# Eveliina Toivanen (toivanen.eveliinarai@gmail.com)

# Ohjelma poistaa käyttäjän antamasta listasta tämän haluaman luvut.


def poista_esiintymät(lukulista_1, lukulista_2):
    """
    Funktio tarkastaa löytyykö käyttäjän haluamia poistettavia lukuja ensimmäiseltä
    lukujonosta tehdyltä listalta ja poistaa ne tarpeen tullen.

    :param lukulista_1: Käyttäjän ensimmäisenä antama lukujono.
    :param lukulista_2: Ne luvut, jotka käyttäjä haluaa poistaa alkuperäiseltä.
    :return: None
    """
    for alkio in lukulista_2:
        if alkio in lukulista_1:
            while lukulista_1.count(alkio) > 0:
                indeksi = lukulista_1.index(alkio)
                del lukulista_1[indeksi]


def main():
    """
    Pääohjelma tervehtii käyttäjää ja pyytää tältä syötteenä lukujonon, sekä
    siitä poistettavat luvut, jotka paloitellaan listoiksi. Listat lähetetään
    parametreina poista_esiintymät -funktiolle, jonka jälkeen ensimmäinen lista
    tulostetaan.

    :return: None
    """
    lukulista_1 = []
    lukulista_2 = []

    print("Hello! I remove elements from a list.")
    print("Please, enter the first list:")
    merkkijono_1 = str(input())
    print("Please, enter the second list:")
    merkkijono_2 = str(input())

    lukulista = merkkijono_1.split()
    for luku in lukulista:
        lukulista_1.append(int(luku))
    poistettavat = merkkijono_2.split()
    for luku in poistettavat:
        lukulista_2.append(int(luku))

    poista_esiintymät(lukulista_1, lukulista_2)

    print(lukulista_1)


# Kutsutaan pääfunktiota, jos ohjelmaa ajetaan.
if __name__ == "__main__":
    main()
