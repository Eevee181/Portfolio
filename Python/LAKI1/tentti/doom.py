# TIEP1.1 Lausekielinen ohjelmointi I
# Tentti, tehtävä 1
# Eveliina Toivanen (eveliina.toivanen@tuni.fi)

# Ohjelma kysyy käyttäjältä vuosiluvun ja tulostaa, kuinka monta minuuttia
# kyseisenä vuonna on ollut tuomiopäivän ajasta keskiyöhön.

print("Hello! This is a doomsday clock.")
print("Please, enter a year:")
vuosi = int(input())

if vuosi > 2018 or vuosi < 2000:
    print("I do not know.")

else:
    if 2000 <= vuosi <= 2001:
        print("9 minutes to midnight.")
    elif 2002 <= vuosi <= 2006:
        print("7 minutes to midnight.")
    elif 2010 <= vuosi <= 2011:
        print("6 minutes to midnight.")
    elif 2007 <= vuosi <= 2009 or 2012 <= vuosi <= 2014:
        print("5 minutes to midnight.")
    elif 2015 <= vuosi <= 2016:
        print("3 minutes to midnight.")
    elif vuosi == 2017:
        print("2.5 minutes to midnight.")
    elif vuosi == 2018:
        print("2 minutes to midnight.")
