import java.util.ArrayList;
import java.util.Random;
import  java.util.Scanner;

public class Main {
    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            Category[] words = {
                    // Food
                    new Category("Food", "apple"),
                    new Category("Food", "bread"),
                    new Category("Food", "pizza"),
                    new Category("Food", "candy"),
                    new Category("Food", "butter"),
                    new Category("Food", "cheese"),
                    new Category("Food", "coffee"),
                    new Category("Food", "dinner"),
                    new Category("Food", "dessert"),
                    new Category("Food", "breakfast"),

                    // Animals
                    new Category("Animals", "kitten"),
                    new Category("Animals", "puppy"),
                    new Category("Animals", "horse"),
                    new Category("Animals", "tiger"),
                    new Category("Animals", "zebra"),
                    new Category("Animals", "monkey"),
                    new Category("Animals", "rabbit"),

                    // Nature
                    new Category("Nature", "river"),
                    new Category("Nature", "beach"),
                    new Category("Nature", "jungle"),
                    new Category("Nature", "garden"),
                    new Category("Nature", "flower"),
                    new Category("Nature", "breeze"),
                    new Category("Nature", "storm"),
                    new Category("Nature", "snowy"),

                    // Objects
                    new Category("Objects", "chair"),
                    new Category("Objects", "table"),
                    new Category("Objects", "clock"),
                    new Category("Objects", "phone"),
                    new Category("Objects", "camera"),
                    new Category("Objects", "window"),
                    new Category("Objects", "ticket"),
                    new Category("Objects", "luggage"),

                    // Actions
                    new Category("Actions", "dance"),
                    new Category("Actions", "drink"),
                    new Category("Actions", "drive"),
                    new Category("Actions", "watch"),
                    new Category("Actions", "learn"),
                    new Category("Actions", "write"),
                    new Category("Actions", "paint"),
                    new Category("Actions", "build"),
                    new Category("Actions", "clean"),

                    // Places
                    new Category("Places", "house"),
                    new Category("Places", "school"),
                    new Category("Places", "office"),
                    new Category("Places", "store"),
                    new Category("Places", "hotel"),

                    // Seasons & Time
                    new Category("Seasons", "summer"),
                    new Category("Seasons", "winter"),
                    new Category("Seasons", "spring"),
                    new Category("Seasons", "autumn"),
                    new Category("Time", "weekend"),
                    new Category("Time", "holiday"),

                    // People
                    new Category("People", "friend"),
                    new Category("People", "family"),
                    new Category("People", "teacher"),
                    new Category("People", "student"),

                    // Descriptive
                    new Category("Descriptive", "bright"),
                    new Category("Descriptive", "shadow"),
                    new Category("Descriptive", "wooden"),
                    new Category("Descriptive", "happy"),
                    new Category("Descriptive", "sleep"),
                    new Category("Descriptive", "laugh")};
            //status
            String board = ""; //symbolizes the lines for each letter (Ex: _______)
            boolean solved = false;
            int lives = 6;

            Random random = new Random();

            int randomIndex = random.nextInt(words.length);
            Category randomWord = words[randomIndex];
            int randomWordLength = randomWord.getWord().length();

            for(int i = 0; i < randomWordLength; i++){
                board+="_";
            }

            System.out.println("Lets play Hangman!");
            System.out.printf("The category is %s", randomWord.getCategoryName());
            System.out.printf("\nYour word is %d letters long\n\n", randomWordLength);

            ArrayList<Character> lettersGuessed = new ArrayList<>();


        while (!solved) {
            if (lives == 0) break;
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

                if (randomWord.getWord().charAt(i) == letter) {
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
            switch (lives) {
                case 6:
                    System.out.println(" +---+");
                    System.out.println(" |   |");
                    System.out.println("     |");
                    System.out.println("     |");
                    System.out.println("     |");
                    System.out.println("     |");
                    System.out.println("=======");
                    break;
                case 5:
                    System.out.println(" +---+");
                    System.out.println(" |   |");
                    System.out.println(" O   |");
                    System.out.println("     |");
                    System.out.println("     |");
                    System.out.println("=======");
                    break;
                case 4:
                    System.out.println(" +---+");
                    System.out.println(" |   |");
                    System.out.println(" O   |");
                    System.out.println(" |   |");
                    System.out.println("     |");
                    System.out.println("     |");
                    System.out.println("=======");
                    break;
                case 3:
                    System.out.println(" +---+");
                    System.out.println(" |   |");
                    System.out.println(" O   |");
                    System.out.println("/|   |");
                    System.out.println("     |");
                    System.out.println("     |");
                    System.out.println("=======");
                    break;
                case 2:
                    System.out.println(" +---+");
                    System.out.println(" |   |");
                    System.out.println(" O   |");
                    System.out.println("/|\\  |");
                    System.out.println("     |");
                    System.out.println("     |");
                    System.out.println("=======");
                    break;
                case 1:
                    System.out.println(" +---+");
                    System.out.println(" |   |");
                    System.out.println(" O   |");
                    System.out.println("/|\\  |");
                    System.out.println("/    |");
                    System.out.println("     |");
                    System.out.println("=======");
                    break;
                default:
                    System.out.println(" +---+");
                    System.out.println(" |   |");
                    System.out.println(" O   |");
                    System.out.println("/|\\  |");
                    System.out.println("/ \\  |");
                    System.out.println("     |");
                    System.out.println("=======");
            }
            if (board.equals(randomWord.getWord()))
                solved = true;

        }
        if (board.equals(randomWord.getWord()))
            System.out.println("You win!");
        else
            System.out.println("You loose");

    }
}