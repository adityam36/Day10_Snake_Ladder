import java.util.Random;

public class Uc1_game_played
{
        public static void main(String[] args) {
            int playerPosition = 0;
            Random dice = new Random();

            int[] snakes = new int[101];
            int[] ladders = new int[101];

            snakes[15] = 6;
            ladders[7] = 38;
            ladders[21] = 42;
            ladders[35] = 44;
            ladders[47] = 67;
            ladders[56] = 91;
            ladders[62] = 100;

            while (playerPosition < 100) {
                int roll = dice.nextInt(6) + 1;
                System.out.println("You rolled a " + roll);
                playerPosition += roll;

                if (playerPosition > 100) {
                    playerPosition -= roll;
                    System.out.println("Roll exceeds 100. Try again!");
                    continue;
                }

                if (snakes[playerPosition] != 0) {
                    System.out.println("Oops! You landed on a snake! Moving to position " + snakes[playerPosition]);
                    playerPosition = snakes[playerPosition];
                }

                if (ladders[playerPosition] != 0) {
                    System.out.println("Great! You landed on a ladder! Climbing to position " + ladders[playerPosition]);
                    playerPosition = ladders[playerPosition];
                }

                System.out.println("You are now at position: " + playerPosition);
            }

            System.out.println("Congratulations! You've reached the end!");
        }
    }