/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman;

/**
 * Hangman.java - It is a famous words game around the world. You have to choose
 * a letter to guess the word. Each wrong letter you lose a life. Good Luck!
 * @author Talita Silva Lima
 * @studentID x14127733
 * @date 15.04.2015
 */
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
public class Hangman {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //creating and starting objects
        Scanner sc = new Scanner(System.in);
        GameCounter count = new GameCounter();
        
        //welcome message
        System.out.println("***Hangman Game***");
        System.out.println("Welcome to this game :)");
        System.out.println("You win this game if you guess all letters in a random word.");
        System.out.println("Good Luck!");
        
        //if the player wants to play again
        boolean play = true;
        
        do {
            //creating array of words
            String words[] = {
                "programming",
                "exhaustive",
                "violin",
                "selection",
                "repetition",
                "serendipity",
                "love",
                "peace",
                "joy",
                "happiness",
                "spring",
                "summer",
                "affection",
                "laugh",
                "smile",
                "cat",
                "chocolate",
                "cupcake",
                "gypsy",
                "abstentious",
                "uncopyrightable",
                "sex",
                "travelling",
                "beach",
                "brazil",
                "ireland",
                "family",
                "boyfriend",
                "sherlock",
                "sheakespeare"
            };
        
            //creating and starting a variable to get a random number to use as 
            //index of the array words
            Random randomNumber = new Random();
            int wordsIndex = randomNumber.nextInt(29);

            //creating a variable to store the word picked from the array through
            //the wordIndex number
            String guessWord = words[wordsIndex];
            int wordLength = guessWord.length();
        
            //boolean to indicate that the game started
            boolean game = true;
            count.incrementPlayed();
            do{
                int lives = 7;
                //array that has the letters of the word
                char letters[] = new char[wordLength];
                System.out.print("Word: ");
                for (int i = 0; i < wordLength; i++) {
                    letters[i] = guessWord.charAt(i);
                    System.out.print(" _ ");
                }
      
                //boolean to say that allow to the user type letters
                boolean tries = true;

                    //INPUT
                    // array to store matched letters (the ones that the player type and are in the guessword)
                    char wordMatchedLetters[] = new char[wordLength];
                    while (tries) {
                        if (lives > 0){ 
                            System.out.println("\nLives: " + lives);
                            System.out.print("\nType a letter:");
                            
                            /*the variable lettersIndex store the letter when the letter didn't appear in the array */
                            int lettersIndex = 0;
                            
                            char givenLetter = sc.next().charAt(0);
                            char letter = Character.toLowerCase(givenLetter);
                                                        
                            //PROCESSING
                            //In this place goes a code of a boolean expression to test 
                            //if the given letter is a letter indeed. If not ask for other letter.
                            try{
				while (Character.isDigit(letter)){
				  	System.out.print("It is a number, please type a letter: ");
                                        givenLetter = sc.next().charAt(0);
                                        letter = Character.toLowerCase(givenLetter);
				}
                            }catch(NumberFormatException e){}
        
                            //loop to test if the letter was chosen
                            char lettersChosen[] = new char[26];
                            int lettersChosenLen = lettersChosen.length;
                                                                                   
                            for(int alphaIndex=0;alphaIndex < lettersChosenLen;alphaIndex++){
                                if(letter == lettersChosen[alphaIndex]){
                                    System.out.print("This letter was already chosen, please type other letter: ");
                                    givenLetter = sc.next().charAt(0);
                                    letter = Character.toLowerCase(givenLetter);
                                }else{
                                    lettersChosen[alphaIndex]=letter;
                                    alphaIndex++;
                                }
                            }
                            // creates a variable to store the matched letters
                            String nWord = "";
                            //System.out.println("Letters chosen: "+Arrays.toString(lettersChosen));
                            System.out.print("Word: ");
                            for (int wordIndex = 0; wordIndex < wordLength; wordIndex++) {
                                /* if the typed letter is in the position word index of the array guessWord, the value is stored at the same index of the array
                                wordIndex, if not increases the value lettersIndex */
                                if (letter == letters[wordIndex]) {
                                    wordMatchedLetters[wordIndex] = letter;
                                } else{
                                    lettersIndex++;
                                }
                            
                                /* if it already has the correct letter in the same position that the letter is in the guess word, the
                                letter is printed and its value is add to the variable that contains the correct letters typed by the player ('nWord').
                                Otherwise, it prints an (_) */
                                if (wordMatchedLetters[wordIndex] == letters[wordIndex]) {
                                    nWord += wordMatchedLetters[wordIndex];
                                    System.out.print(" " + wordMatchedLetters[wordIndex] + " ");
                                } else {
                                    System.out.print(" _ ");
                                }
                            }
                            if (lettersIndex >= wordLength) {
                                System.out.println("\nThis letter doesn't exists");
                                lives--;
                            }
                            /* if the player guess the letters until finish the word it hides the 'tries' variable
                            to 'false', and ends the game! */
                            if (guessWord.equals(nWord)) {
                                System.out.println("\nCongratulations! You won the game :)");
                                count.incrementWon();
                                tries = false;
                            }
                    }else{
                        System.out.println("\nUnfortunately, you lost the game :(");
                        System.out.println("The word was: "+guessWord);
                        count.incrementLost();
                        tries = false;
                    }
                }
                //false game ends the match
                game = false;
            }while (game);

            // message if the player wants to play again
            System.out.println("Do you want to play again  ? ('Y' to play again e 'N' if you don't want)");

            char playAgain = sc.next().charAt(0);
            if (playAgain == 'Y' || playAgain == 'y') {
                play = true;//if the player wants to play again.
            } else {//if not it finishes the game
                System.out.println("Games Played: "+count.getGamesPlayed());
                System.out.println("Games Won: "+count.getGamesWon());
                System.out.println("Games Lost: "+count.getGamesLost());
                play = false;
                System.out.println("\n  Bye Bye :)  \n");
            }
        }while (play);
    }
}