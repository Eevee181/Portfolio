# TIEP1.1 Lausekielinen ohjelmointi I
# Harjoitus 5, tehtävä 2
# Eveliina Toivanen (toivanen.eveliinarai@gmail.com)

oikeat_merkit = True

print("Hello! I split strings.")

while oikeat_merkit is True:
    print("Please, enter a string:")
    paloiteltava = str(input())
    print("Please, enter a separator:")
    separaattori = str(input())

    if separaattori not in paloiteltava:
        oikeat_merkit = False

    else:
        paloiteltu = paloiteltava.split(separaattori)
        print(paloiteltu)
