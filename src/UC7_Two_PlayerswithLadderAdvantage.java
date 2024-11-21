import java.util.Random;

public class UC7_Two_PlayerswithLadderAdvantage {
    public static void main(String[] args) {
        int player1Position = 0;
        int player2Position = 0;
        int diceRollCount = 0;
        int currentPlayer = 1;
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

        System.out.println("Starting the game! Two players will play the game.");

        while (player1Position < 100 && player2Position < 100) {
            diceRollCount++;
            int roll = dice.nextInt(6) + 1;
            System.out.println("\nDice Roll " + diceRollCount + ": Player " + currentPlayer + " rolled a " + roll);

            int option = dice.nextInt(3); // 0: No Play, 1: Ladder, 2: Snake
            int playerPosition = (currentPlayer == 1) ? player1Position : player2Position;

            System.out.println("Option: " + (option == 0 ? "No Play" : option == 1 ? "Ladder" : "Snake"));

            if (option == 0) {
                System.out.println("No Play! Player " + currentPlayer + " stays at position " + playerPosition);
            } else if (option == 1) {
                if (playerPosition + roll <= 100) {
                    playerPosition += roll;
                    System.out.println("Player " + currentPlayer + " landed on a ladder! Moving to position " + playerPosition);

                    if (ladders[playerPosition] != 0) {
                        System.out.println("Great! Player " + currentPlayer + " climbed to position " + ladders[playerPosition]);
                        playerPosition = ladders[playerPosition];
                    }

                    System.out.println("Player " + currentPlayer + " gets another turn!");
                    continue; // Ladder: Same player rolls again
                } else {
                    System.out.println("Roll too high! Player " + currentPlayer + " stays at position " + playerPosition);
                }
            } else if (option == 2) {
                playerPosition -= roll;
                if (playerPosition < 0) {
                    playerPosition = 0;
                }
                System.out.println("Player " + currentPlayer + " landed on a snake! Moving back to position " + playerPosition);

                if (snakes[playerPosition] != 0) {
                    System.out.println("Oops! Player " + currentPlayer + " slid down to position " + snakes[playerPosition]);
                    playerPosition = snakes[playerPosition];
                }
            }

            if (currentPlayer == 1) {
                player1Position = playerPosition;
                System.out.println("Player 1's current position: " + player1Position);
            } else {
                player2Position = playerPosition;
                System.out.println("Player 2's current position: " + player2Position);
            }

            if (player1Position >= 100 || player2Position >= 100) {
                break; // Stop the game when one player reaches the winning position
            }

            // Switch turn to the other player
            currentPlayer = (currentPlayer == 1) ? 2 : 1;
        }

        // Determine and announce the winner
        if (player1Position >= 100) {
            System.out.println("\nCongratulations! Player 1 wins the game in " + diceRollCount + " rolls!");
        } else if (player2Position >= 100) {
            System.out.println("\nCongratulations! Player 2 wins the game in " + diceRollCount + " rolls!");
        }
    }

}
