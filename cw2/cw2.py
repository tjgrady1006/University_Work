word = "Apple"

print(("- " * len(word)) + "  ;This is the word you must guess")

guess = []
guess_count = 0
guess_limit = 5

while guess_count < guess_limit:

    guess_letter = input("Please Guess A Letter: ")

    if guess_letter in word:
        guess.append(guess_letter)
        print(guess)

    elif guess_letter is not word:
        guess_count += 1
        print("You lose a life")


