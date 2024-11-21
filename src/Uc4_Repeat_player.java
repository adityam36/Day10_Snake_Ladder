import java.util.Random;

public class Uc4_Repeat_player {
    public class SnakeAndLadder {
        public static void main(String[] args) {
            int playerPosition = 0;
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

            while (playerPosition < 100) {
                int roll = (int) (Math.random() * 6) + 1;
                System.out.println("You rolled a " + roll);

                int option = (int) (Math.random() * 3);  // Generates a number between 0 and 2
                System.out.println("Option: " + option); // 0: No Play, 1: Ladder, 2: Snake

                if (option == 0) {
                    System.out.println("No Play! You stay at the same position.");
                } else if (option == 1) {
                    playerPosition += roll;
                    if (playerPosition > 100) {
                        playerPosition = 100;
                    }
                    System.out.println("You landed on a ladder! You move ahead to position " + playerPosition);
                } else if (option == 2) {
                    playerPosition -= roll;
                    if (playerPosition < 0) {
                        playerPosition = 0;
                    }
                    System.out.println("You landed on a snake! You move back to position " + playerPosition);
                }

                if (snakes[playerPosition] != 0) {
                    System.out.println("Oops! You landed on a snake! Moving to position " + snakes[playerPosition]);
                    playerPosition = snakes[playerPosition];
                } else if (ladders[playerPosition] != 0) {
                    System.out.println("Great! You landed on a ladder! Climbing to position " + ladders[playerPosition]);
                    playerPosition = ladders[playerPosition];
                }

                if (playerPosition < 0) {
                    playerPosition = 0;  // Restart from 0 if player position is below 0
                }

                System.out.println("You are now at position: " + playerPosition);
            }

            System.out.println("Congratulations! You've reached the end!");
        }
    }
}
