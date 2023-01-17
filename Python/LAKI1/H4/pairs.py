# TIEP1.1 Lausekielinen ohjelmointi I
# Harjoitus 4, tehtävä 2
# Eveliina Toivanen (toivanen.eveliinarai@gmail.com)

# Ohjelma lukee käyttäjältä kaksi merkki ja tarkastaa ovatko kyseiset merkit pari vai ei.
# Kaari- aalto- haka- ja kulmasulkeet ovat tässä ohjelmassa pareja, jos ensimmäinen
# merkki on avaava ja toinen sulkeva.

print('Hello! I find pairs.')
print('Enter the first character:')
eka_merkki = str(input())
print('Enter the second character:')
toka_merkki = str(input())

if eka_merkki == '(' and toka_merkki == ')':
    print('Characters "', eka_merkki, '" and "', toka_merkki,'" are a pair.', sep="")

elif eka_merkki == '{' and toka_merkki == '}':
    print('Characters "', eka_merkki,'" and "', toka_merkki,'" are a pair.', sep="")

elif eka_merkki == '[' and toka_merkki == ']':
    print('Characters "', eka_merkki,'" and "',toka_merkki,'" are a pair.', sep="")

elif eka_merkki == '<' and toka_merkki == '>':
    print('Characters "', eka_merkki,'" and "', toka_merkki, '" are a pair.', sep="")

else:
    print('Characters "', eka_merkki, '" and "', toka_merkki, '" are not a pair.', sep="")
