package hu.nye.progtech.wumpusz.GamePlay;

import hu.nye.progtech.wumpusz.MapEditor.MapEditor;

import java.util.Scanner;


public class Gameplay {
    private final char[][] gameBoard;
    public int wumpusCount;
    public static int arrowCount;
    public boolean heroHasGold;
    private int heroRow;
    private int heroCol;
    public static int moveCounter;

    public Gameplay(char[][] gameBoard, int wumpusCount) {
        this.gameBoard = gameBoard;
        this.wumpusCount = wumpusCount;
        arrowCount = wumpusCount;
        this.heroHasGold = false;
        findInitialHeroPosition();
    }
    private void findInitialHeroPosition() {
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                if (gameBoard[i][j] == 'H') {
                    heroRow = i;
                    heroCol = j;
                    return;
                }
            }
        }
    }

    public void playGame() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nActions:");
            System.out.println("1. Move");
            System.out.println("2. Turn Right");
            System.out.println("3. Turn Left");
            System.out.println("4. Pick Up Gold");
            System.out.println("5. Quit");

            System.out.print("Enter your action: ");
            int actionChoice = scanner.nextInt();

            switch (actionChoice) {
                case 1:
                    moveCounter++;
                   Movement movement= new Movement();
                   movement.moveHero();
                   Turn.displayHeroDirection();
                    break;

                case 2:
                    Turn.turnRight(gameBoard,heroRow,heroCol);
                    Turn.displayHeroDirection();
                    break;

                case 3:
                    Turn.turnLeft(gameBoard,heroRow,heroCol);
                    Turn.displayHeroDirection();
                    break;

                case 4:
                    PickupGold.goldPickUp();
                    MapEditor.displayMap();
                  //  System.out.println("Number of steps: "+moveCounter);
                    break;

                case 5:
                    System.out.println('\0');
                    break;

                default:
                    System.out.println("Invalid action. Please enter a number between 1 and 6.");
                    break;
            }
        }
    }



}
