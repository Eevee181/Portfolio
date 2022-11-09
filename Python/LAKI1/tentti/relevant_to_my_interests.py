# TIEP1.1 Lausekielinen ohjelmointi I
# Tentti, tehtävä 2
# Eveliina Toivanen (eveliina.toivanen@tuni.fi)

# Ohjelma kysyy käyttäjältä luvut x ja y ja tutkii onko x kiinnostava sen
# perusteella, että jokainen numero luvusta y esiintyy siinä vähintään kerran.

y_lista = []
kuinka_monta = 0

print("Hello! I am interested in numbers.")
print("Please, enter x:")
x = str(input())
print("Please, enter y:")
y = str(input())

for alkio in y:
    if alkio in x:
        kuinka_monta += 1

if len(y) == kuinka_monta:
    print("This is relevant to my interests.")
else:
    print("This is not relevant to my interests.")
