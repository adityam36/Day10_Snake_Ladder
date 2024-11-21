import java.util.Random;

public class Uc6_Report_NoOf_Times_Dice_Die_Role {
    public static void main(String[] args) {
        int playerPosition = 0;
        int diceRollCount = 0;
        int[] snakes = new int[101];
        int[] ladders = new int[101];

        snakes[16] = 6;
        snakes[47] = 26;
        snakes[49] = 11;
        snakes[56] = 53;
        snakes[62] = 19;
        snakes[64] = 60;
        snakes[87] = 24;
        snakes[93] = 73;
        snakes[95] = 75;
        snakes[98] = 78;

        ladders[2] = 38;
        ladders[7] = 29;
        ladders[8] = 31;
        ladders[15] = 26;
        ladders[21] = 42;
        ladders[28] = 84;
        ladders[36] = 44;
        ladders[51] = 67;
        ladders[71] = 91;
        ladders[80] = 100;

        Random dice = new Random();

        System.out.println("Starting the game!");

        while (playerPosition < 100) {
            diceRollCount++;
            int roll = dice.nextInt(6) + 1;
            System.out.println("\nRoll " + diceRollCount + ": You rolled a " + roll);

            int option = dice.nextInt(3);
            System.out.println("Option: " + (option == 0 ? "No Play" : option == 1 ? "Ladder" : "Snake"));

            if (option == 0) {
                System.out.println("No Play! You stay at position " + playerPosition);
            } else if (option == 1) {
                if (playerPosition + roll <= 100) {
                    playerPosition += roll;
                    System.out.println("You landed on a ladder! Moving to position " + playerPosition);
                } else {
                    System.out.println("Roll too high! Stay at position " + playerPosition);
                }
            } else if (option == 2) {
                playerPosition -= roll;
                if (playerPosition < 0) {
                    playerPosition = 0;
                }
                System.out.println("You landed on a snake! Moving back to position " + playerPosition);
            }

            if (snakes[playerPosition] != 0) {
                System.out.println("Oops! You landed on a snake! Moving to position " + snakes[playerPosition]);
                playerPosition = snakes[playerPosition];
            } else if (ladders[playerPosition] != 0) {
                System.out.println("Great! You landed on a ladder! Climbing to position " + ladders[playerPosition]);
                playerPosition = ladders[playerPosition];
            }

            System.out.println("Current position after roll " + diceRollCount + ": " + playerPosition);
        }

        System.out.println("\nCongratulations! You've reached the end in " + diceRollCount + " rolls!");
    }

}
