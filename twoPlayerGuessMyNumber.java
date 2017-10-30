import static java.lang.System.out;
import java.util.Scanner;
import java.util.Random;

public class twoPlayerGuessMyNumber
{
    public static int getRandomNumber(long seed, int upper) {
        Random dice = new Random(seed);
        int diceRoll = dice.nextInt(upper);
        return diceRoll;
    }
    public static int getNumberGuess(int min, int max) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Guess: ");
        int guess = keyboard.nextInt();
        keyboard.nextLine();
    
        if (guess < min || guess > max) {
            System.out.println("That number is not in range.");
            getNumberGuess(min, max);
        }
        return guess;
    }
    public static boolean checkNumber(int number, int min, int max, long seed, String name) {
        boolean guessAgain = true;
        boolean keepPlaying = true;
        Scanner keyboard = new Scanner(System.in);
        int randomNumber = getRandomNumber(seed, max);
        String playAgain;
        do {
            if (number == randomNumber) {
                guessAgain = false;
                System.out.print("You got it!");
                System.out.println("The correct number is " + randomNumber);
                System.out.println("Do you want to play again? Enter y for yes and n for no. ");
                playAgain = keyboard.nextLine();
                
                if(playAgain.equals("y")) {
                    keepPlaying = true;
                } else {
                    keepPlaying = false;
                }
            } else {
                if (number < randomNumber) {
                    System.out.println("That number is too low. Guess again. ");
                    number = getNumberGuess(min,max);
                } else {
                    if (number > randomNumber) {
                        System.out.println("That number is too high. Guess again. ");
                        number = getNumberGuess(min,max);
                    } else {
                        System.out.println("Invalid guess. Try again ");
                        number = getNumberGuess(min,max);
                    }
                }
            }
        } while (guessAgain) ;
        return keepPlaying;
    }
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        boolean keepPlaying = true;
        ;
        System.out.print("What is player 1's name? ");
        String name1 = keyboard.nextLine();
        System.out.print("What is player 2's name? ");
        String name2 = keyboard.nextLine();
          String name = name1;
        do {
            System.out.println("I'm thinking of a number between 1 - 100. What is it? ");
            int min = 1;
            int max = 100;
            int guess = getNumberGuess(min,max);
            long seed = System.currentTimeMillis();
            
            keepPlaying = checkNumber(guess, min, max, seed, name);
        } while (keepPlaying);
    }
}

        