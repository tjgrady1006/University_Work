word = "different".upper()                  #converts word into all uppercase, easier to match guesses

def play(word):
    blanks = "_"
    blanks_list = list(blanks)
    new_blanks_list = list(blanks)
    word_completion = blanks * len(word)
    guessed = False
    guessed_letters = []
    guessed_words = []
    tries = 5


    print("Lets play a guessing game!")
    print(word_completion)
    print("\n")

    while not guessed and tries > 0:
        guess = input("Please guess a letter or word: ").upper()

        if len(guess) == 1 and guess.isalpha():

            if guess in guessed_letters:
                print("You already guessed the letter", guess)

            elif guess not in word:
                print(guess, "is not in the word.")
                tries -= 1
                guessed_letters.append(guess)

            else:
                print("Good job, ", guess, "is in the word!")
                guessed_letters.append(guess)
                word_as_list = list(word_completion)

                indices = [i for i, letter in enumerate(word) if letter == guess]
                for index in indices:
                    word_as_list[index] = guess
                word_completion = "".join(word_as_list)
                blanks_list = new_blanks_list[:]
                print(" ".join(blanks_list))

                if "_" not in word_completion:
                    guessed = True

        elif len(guess) == len(word) and guess.isalpha():

            if guess in guessed_words:
                print("You already guessed the word", guess)

            elif guess != word:
                print(guess, "is not the word.")
                tries -= 1
                guessed_words.append(guess)

            else:
                guessed = True
                word_completion = word

        else:
            print("Not a Vaild guess.")
        print(tries, "remaining")
        print(word_completion)
        print("\n")
    if guessed:
        print("Congrats, you guessed the word!")
    else:
        print("sorry, ran out of tries. The word was " + word + ". Better luck next time")

def main():
    play(word)
    while input("Play again> (Y/N) ").upper() == "Y":
        play(word)

if __name__ == "__main__":
    main()
