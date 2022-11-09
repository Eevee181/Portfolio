# TIEP1.1 Lausekielinen ohjelmointi I
# Harjoitus 5, tehtävä 8
# Eveliina Toivanen (eveliina.toivanen@tuni.fi)

# Ohjelma tutkii, onko käyttäjän antamilla kahdella kokonaisluvulla sama etumerkki vai ei,
# ja tulostaa sen mukaisen tulosteen.


def samat_etumerkit(luku_1, luku_2):
    """
    Funktio tarkistaa onko luvuilla sama etumerkki ja tulostaa sen mukaisen tulosteen.
    Funktiolla on parametrinaan kaksi käyttäjän pääohjelmassa antamaa kokonaislukua.
    """
    if luku_1 >= 0 and luku_2 >= 0:
        print("The signs are the same.")
    elif luku_1 < 0 and luku_2 < 0:
        print("The signs are the same.")
    else:
        print("The signs are different.")


def main():
    """
    Funktio tervehtii käyttäjää ja kysyy tältä kaksi kokonaislukua,
    jotka lähettää samat_etumerkit -funktiolle.
    """
    print("Hello! I compare signs.")
    print("Enter the first integer:")
    luku_1 = int(input())
    print("Enter the second integer:")
    luku_2 = int(input())

    samat_etumerkit(luku_1, luku_2)


# Kutsutaan pääohjelmaa, jos ohjelmaa ajetaan.
if __name__ == "__main__":
    main()