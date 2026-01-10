import java.util.ArrayList;
import java.util.Random;
import  java.util.Scanner;

public class Main {
    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String[] words = {"apple", "bread", "chair", "table", "clock", "plant", "smile", "house", "river", "beach",
                    "train", "shirt", "light", "phone", "music", "glass", "stone", "water", "mouse", "paper",
                    "candy", "pizza", "fruit", "jungle", "shadow", "bright", "wooden", "happy", "sleep", "laugh",
                    "dance", "drink", "drive", "watch", "learn", "reader", "write", "paint", "build", "clean",
                    "money", "store", "school", "friend", "family", "people", "teacher", "student", "office", "window",
                    "garden", "flower", "animal", "kitten", "puppy", "horse", "tiger", "zebra", "monkey", "rabbit",
                    "summer", "winter", "spring", "autumn", "sunny", "cloudy", "rainy", "storm", "snowy", "breeze",
                    "travel", "ticket", "hotel", "flight", "luggage", "camera", "picture", "memory", "holiday", "weekend",
                    "cookie", "butter", "cheese", "sugar", "coffee", "dinner", "lunch", "snack", "dessert", "breakfast"};
            //status
            String board = ""; //symbolizes the lines for each letter (Ex: _______)
            boolean solved = false;
            int lives = 5;

            Random random = new Random();

            int randomIndex = random.nextInt(words.length);
            String randomWord = words[randomIndex];
            int randomWordLength = randomWord.length();

            for(int i = 0; i < randomWordLength; i++){
                board+="_";
            }

            System.out.println("Lets play Hangman!");
            System.out.printf("Your word is %d letters long\n\n", randomWordLength);

            ArrayList<Character> lettersGuessed = new ArrayList<>();


        while (!solved && lives != 0) {
            System.out.print("Guess a letter: ");
            char letter = sc.nextLine().charAt(0);

            int numLettersFound = 0;
            if (!lettersGuessed.isEmpty()) { //if the lettersGuessed ArrayList is empty, it skips this
                for (Character s : lettersGuessed) {
                    if (letter == s) {
                        System.out.print("\nYou've guessed that letter already\n");
                        break;
                    }
                }
            }
            lettersGuessed.add(letter);
            for (int i = 0; i < randomWordLength; i++) {

                if (randomWord.charAt(i) == letter) {
                    board = board.substring(0, i) + letter + board.substring(i + 1);
                    numLettersFound++;
                }
            }
            if (numLettersFound > 0) {
                System.out.printf("\nCorrect! %d letters found\n", numLettersFound);
                System.out.println(board);
            } else {
                lives--;
                System.out.printf("\nNo letters found. %d lives left\n", lives);

            }
            if (board.equals(randomWord))
                solved = true;

        }
        if (board.equals(randomWord))
            System.out.println("You win!");
        else
            System.out.println("You loose");

    }
}