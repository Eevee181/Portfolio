# TIEP1.1 Lausekielinen ohjelmointi I
# Harjoitus 5, tehtävä 3
# Eveliina Toivanen (toivanen.eveliinarai@gmail.com)

# Ohjelma lisää listalle erisnimiä, jos ne ovat oikein kirjoitettu, eli nimi koostuu
# kirjaimista ja alkaa suurella alkukirjaimella.

# Määritellään komennot vakioina
TULOSTUS = 'print'
LOPETUS = 'stop'

nimilista = []
jatkuu = True

print("Hello! I detect and store names.")

# Tarkistetaan luupissa komento ja tehdään sen mukaiset toiminnot.
while jatkuu:
    print("Please, enter a name or a command:")
    tehtava = str(input())

    # Jos komento vastaa LOPETUS-muuttujaa, lopetetaan luupin toiminta.
    if tehtava == LOPETUS:
        jatkuu = False

    # Tulostetaan listan sisältö jokainen alkio omalle rivilleen.
    elif tehtava == TULOSTUS:
        for i in range(len(nimilista)):
            print(nimilista[i])

    # Muussa tapauksessa katsotaan täyttääkö syöte nimivaatimuksia ja lisätään
    # se siinä tapauksessa nimilistalle.
    else:
        onko_vain_kirjaimia = tehtava.isalpha()
        kirjainkoon_tarkistus = tehtava[0].isupper()

        if onko_vain_kirjaimia is True and kirjainkoon_tarkistus is True:
            nimilista.append(tehtava)
            print("Accepted.")
        elif onko_vain_kirjaimia is False or kirjainkoon_tarkistus is False:
            print("Rejected!")
