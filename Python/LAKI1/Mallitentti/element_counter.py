# TIEP1.1 Lausekielinen ohjelmointi I
# Mallitentti, tehtävä 4
# Eveliina Toivanen (toivanen.eveliinarai@gmail.com)

# Katsotaan löytyykö käyttäjän syöttämästä listasta kuinka monta
# rajalukua pienempää lukua.


def laske_pienemmät(numerolista, vertailu_nro):
    pienempien_lkm = 0

    if not numerolista:
        return None
    else:
        for luku in numerolista:
            if luku < vertailu_nro:
                pienempien_lkm += 1

        return pienempien_lkm


def main():
    numerolista = []
    print("Hello! I count smaller elements.")
    print("Please, enter the number of integers:")
    lkm = int(input())

    while lkm > 0:
        print("Please, enter an integer:")
        luku = int(input())
        numerolista.append(luku)
        lkm -= 1

    print("Please, enter the limit:")
    vertailu_nro = int(input())

    pienempien_lkm = laske_pienemmät(numerolista, vertailu_nro)

    if pienempien_lkm is None:
        print("Could not compute!")
    else:
        print("{:1d} smaller elements.".format(pienempien_lkm))


# Kutsutaan pääohjelmaa, jos ohjelmaa ajetaan.
if __name__ == "__main__":
    main()
