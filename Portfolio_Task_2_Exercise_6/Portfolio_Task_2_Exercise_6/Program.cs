using System;

namespace Portfolio_Task_2_Exercise_6
{
    class Program
    {
        static void Main(string[] args)
        {
            // Welcome message section
            Console.WriteLine("This is a guessing game.");
            Console.WriteLine(" ");
            Console.WriteLine("A random number between 1 and 100 will be generated.");
            Console.WriteLine(" ");
            Console.WriteLine("You will have 5 guesses to get the correct answer.");
            
            // A variable to compare the users guess with the random number
            int user_guess = 0;
            // A boolean variable to make the ability to play the game over
            bool playGame = false;
            // cSet the number of maximum guesses allowed
            int max_number_of_guesses = 5;
            // A string to store the response whether the user wants to play again
            string playAgain;

            try
            {
                // Set the condition so that the while loop will carry out while the playGame variable is false
                while (!playGame)
                {
                    /*
                     *      r.Next(101) is used so that, 100 is included.
                     */
                    Random r = new Random();
                    int random_number = r.Next(1, 101);
                    // initally setting the number of guesses as 0
                    int number_of_guesses = 0;
                    user_guess = 0;
                    playAgain = "";

                    // loop will continue while the user guess is not equal to the random number AND the number of guesses is less than the maximum allowed
                    while (user_guess != random_number && number_of_guesses < max_number_of_guesses)
                    {
                        // Getting input from the user and converting it to a integer. Prints out the users guess also
                        Console.WriteLine(" ");
                        Console.WriteLine("Please Guess a number between 1 - 100: ");
                        user_guess = Convert.ToInt32(Console.ReadLine());
                        Console.WriteLine("Guess: " + user_guess);
                        Console.WriteLine(" ");

                        // Large if statement first checking if the guess is greater or less than the random number
                        if (user_guess < random_number)
                        {
                            // Nested if statement to see how far away the guesses are
                            // Math.Abs used to return the absolute number (positive integer) as the sum may return a negative number if the random number was greater than the user guess.
                            if ((Math.Abs(random_number - user_guess)) <= 9)
                            {
                                Console.WriteLine("Your guess is just a little low");
                                Console.WriteLine("The random number is less than 10 away");
                                Console.WriteLine(" ");
                            }
                            // logic if the guess is less than or equal to 19 AND greater than or equal to 10
                            else if ((Math.Abs(random_number - user_guess)) <= 19 && (Math.Abs(random_number - user_guess) >= 10))
                            {
                                Console.WriteLine("Your guess is moderately low");
                                Console.WriteLine("The random number is more than 10 away but less than 20");
                                Console.WriteLine(" ");
                            }
                            // logic if the guess is less than or equal to 49 AND greater than or equal to 20
                            else if ((Math.Abs(random_number - user_guess)) <= 49 && (Math.Abs(random_number - user_guess) >= 20))
                            {
                                Console.WriteLine("Your guess is very low");
                                Console.WriteLine("The random number is more than 20 away but less than 50");
                                Console.WriteLine(" ");
                            }
                            // If the guess is more than 50 out
                            else if ((Math.Abs(random_number - user_guess)) >= 50)
                            {
                                Console.WriteLine("Your guess is extremely low");
                                Console.WriteLine("More than 50 out");
                                Console.WriteLine(" ");
                            }
                            Console.WriteLine("Guesses remaining: " + ((max_number_of_guesses - 1) - number_of_guesses) + "/5");
                        }

                        // Second part of the inital if statement
                        else if (user_guess > random_number)
                        {
                            // IF the guess is more than 50 away
                            if ((user_guess - random_number) > 50)
                            {
                                Console.WriteLine("Your guess is extremely high");
                                Console.WriteLine("More than 50 out");
                                Console.WriteLine(" ");
                            }
                            // If the guess is less than or equal to 49 AND greater or equal to 20
                            else if ((user_guess - random_number) <= 49 && ((user_guess - random_number) >= 20))
                            {
                                Console.WriteLine("Your guess is very high");
                                Console.WriteLine("The random number is less than 50 away but more than 20");
                                Console.WriteLine(" ");
                            }
                            // If the guess is less than or equal to 19 AND greater or equal to 10
                            else if ((user_guess - random_number) <= 19 && ((user_guess - random_number) >= 10))
                            {
                                Console.WriteLine("Your guess is moderately high");
                                Console.WriteLine("The random number is less than 20 away but more than 10");
                                Console.WriteLine(" ");
                            }
                            // If the guess is less than or equal to 9
                            else if ((user_guess - random_number) <= 9)
                            {
                                Console.WriteLine("Your guess is just a little high");
                                Console.WriteLine("The random number is less than 10 away");
                                Console.WriteLine(" ");
                            }
                            // Prints out the number of guesses left
                            Console.WriteLine("Guesses remaining: " + ((max_number_of_guesses - 1) - number_of_guesses) + "/5");
                        }
                        // increases the number of guesses after each guess
                        number_of_guesses++;
                        Console.WriteLine("------------");
                    }
                    // If the user correctly guesses the random number
                    if (user_guess == random_number)
                    {
                        Console.WriteLine(" ");
                        Console.WriteLine("*************************");
                        Console.WriteLine("******  You Win !  ******");
                        Console.WriteLine("*************************");
                        Console.WriteLine(" ");
                        Console.WriteLine("The Random Number was: " + random_number);
                        Console.WriteLine(" ");
                    }
                    // if the user runs out of guesses and doesnt get the random number
                    else if (user_guess != random_number && number_of_guesses == max_number_of_guesses)
                    {
                        Console.WriteLine("Sorry you lose. You're out of guesses.");
                        Console.WriteLine(" ");
                        Console.WriteLine("The correct number was: " + random_number);
                        Console.WriteLine(" ");
                    }

                    /*
                     *      Converting whatever the input into an uppercase letter
                     */
                    Console.WriteLine("Do you want to play again (Y/N): ");
                    playAgain = Console.ReadLine();
                    playAgain = playAgain.ToUpper();

                    try
                    {
                        // If statement to set the playGame variable to true or false demending if the user wants to play again.
                        if (playAgain == "Y")
                        {
                            playGame = false;
                        }
                        else if (playAgain == "N")
                        {
                            playGame = true;
                        }
                        else
                        {
                            Console.WriteLine(" ");
                            Console.WriteLine("------------------------------------");
                            Console.WriteLine(" ");
                            Console.WriteLine("You did not enter the correct input.");
                            Console.WriteLine("The program will now terminate.");
                            playGame = true;
                        }
                    }
                    catch (Exception e)
                    {
                        Console.WriteLine(e.Message);
                    }
                }
                // Goodbye message
                Console.WriteLine(" ");
                Console.WriteLine("Thank you for playing!!!");
            }
            // Simple error catching will display a message if the user has inputted a wrong data type
            catch(Exception e)
            {
                Console.WriteLine(" ");
                Console.WriteLine(e.Message);
                Console.WriteLine("Program will terminate.... Please restart");
            }
        }
    }
}
