/*
 * Class: CMSC203 
 * Instructor: Khandan Monshi
 * Description: An application that will receive a guess and report if the guess is the random number that was generated.  
 * This application will narrow down the choices according to the previous guesses and continue to prompt us to enter a guess until we guess correctly.
 * Due: 2/23/2021
 * Platform/compiler:
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Njenwieh Onya Clovis
*/

import java.util.Scanner;
/**
 * Driver Class, responsible to print the head and also ask the user for 
 * an initial guess of the RNG between 0 and 100
 * print out the result for that guess using the method from the RNG class
 */
public class RandonNumberGuesser {
    public static Scanner scan;
    public static int randNum;
    public static int nextGuess, highGuess, lowGuess;
    public static RNG rang;
    /**
     * The main method for the RNG app
     * @param args
     */
    public static void main(String[] args) {
        rang = new RNG();
        String play_or_not = "yes";
        while ( play_or_not.equals("yes")) {
            initialiseGame();
            playGame();
            System.out.println("Try again? (yes or no)");
            play_or_not = scan.next();    
        }
        System.out.println("Thanks for playing...");
    }
    /**
     * initialize the game by using the initializeGame method
     */
    public static void initialiseGame() {
        lowGuess = 0;
        highGuess = 100;
        randNum = rang.rand();
        rang.resetCount();
    }
    
    /**
     * play the game
     */
    public static void playGame() {
        scan = new Scanner(System.in);
        System.out.println("Enter your first guess");
        nextGuess = scan.nextInt();

        while(nextGuess != randNum) {
            if (!rang.inputValidation(nextGuess, lowGuess, highGuess)) {
                nextGuess = scan.nextInt();
                continue;
            }

            System.out.println("Number of guesses is "+rang.getCount());
            if (nextGuess>randNum) {
                highGuess = nextGuess;
                System.out.println("Your guess is too high");
                
            } else {
                lowGuess = nextGuess;
                System.out.println("Your guess is too low");
            }
            System.out.println("Enter your next guess between "+ lowGuess + " and " + highGuess);
            nextGuess = scan.nextInt();
        }
        System.out.println("Number of guesses is "+(rang.getCount()+1));
        System.out.println("Congratulations, you guessed correctly");
    }
}