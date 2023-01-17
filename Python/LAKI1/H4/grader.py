# TIEP1.1 Lausekielinen ohjelmointi I
# Harjoitus 4, tehtävä 1
# Eveliina Toivanen (toivanen.eveliinarai@gmail.com)

# Ohjelma lukee käyttäjältä tämän tentti- ja hyvityspisteet ja laskee
# niiden perusteella käyttäjälle tämän arvosanan.

print("Hello! I am a grader.")
print("Please, enter exam points:")
exam_points = int(input())
print("Please, enter bonus points:")
bonus_points = int(input())

# Tarkastetaan, että luvut ovat sallitussa muodossa.
# Jos ei, tulostetaan virheilmoitus.
if exam_points < 12:
    print("I cannot grade you.")
elif not 0 <= bonus_points <= 3:
    print("I cannot grade you.")

# Lasketaan arvosana.
else:
    sum_points = exam_points + bonus_points

    if sum_points >= 12 and sum_points <= 14:
        print("Your grade is 1.")
    elif sum_points >= 15 and sum_points <= 17:
        print("Your grade is 2.")
    elif sum_points >= 18 and sum_points <= 20:
        print("Your grade is 3.")
    elif sum_points == 21 or sum_points == 22:
        print("Your grade is 4.")
    elif sum_points >= 23:
        print("Your grade is 5.")





