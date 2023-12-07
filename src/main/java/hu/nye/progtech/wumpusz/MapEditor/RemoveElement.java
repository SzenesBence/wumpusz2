package hu.nye.progtech.wumpusz.MapEditor;

import java.util.Scanner;

import static hu.nye.progtech.wumpusz.MapEditor.MapEditor.calculateArrowCount;
import static hu.nye.progtech.wumpusz.MapEditor.MapEditor.isValidPosition;

public class RemoveElement {

    public static char[][] map;
    public static int wumpusCount=AddElement.getWumpusCount();
    public static int arrowCount;
    public static boolean heroHasGold;

    public static void initialize(char[][] gameBoard, int wumpusCount) {
        map = gameBoard;
        RemoveElement.wumpusCount = wumpusCount;
        heroHasGold = false;
    }
    public void removeElement() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nRemove Element:");
        System.out.println("1. Wumpus");
        System.out.println("2. Hero");
        System.out.println("3. Gold");
        System.out.println("4. Wall");
        System.out.println("5. Pit");
        System.out.println("6. Exit");

        System.out.print("Enter the element to remove: ");
        int elementChoice = scanner.nextInt();

        System.out.print("Enter the row: ");
        int row = scanner.nextInt();

        System.out.print("Enter the column: ");
        int col = scanner.nextInt();

        if (isValidPosition(row, col)) {
            switch (elementChoice) {
                case 1:
                    if (map[row][col] == 'U') {
                        map[row][col] = '\0';
                        System.out.println("Wumpus removed from position (" + row + ", " + col + ").");
                    } else {
                        System.out.println("No Wumpus at the specified position.");
                    }
                    break;

                case 2:
                    if (map[row][col] == 'H') {
                        map[row][col] = '\0';
                        heroHasGold = false;
                        arrowCount = calculateArrowCount(wumpusCount);
                        System.out.println("Hero removed from position (" + row + ", " + col + ").");
                    } else {
                        System.out.println("No Hero at the specified position.");
                    }
                    break;

                case 3:
                   RemoveGold.removeGold(row,col);
                    break;

                case 4:
                    if (map[row][col] == 'W') {
                        map[row][col] = '\0';
                        heroHasGold = false;
                        System.out.println("Wall removed from position (" + row + ", " + col + ").");
                    } else {
                        System.out.println("No wall at the specified pisito");
                    }
                    break;
                case 5:
                    if (map[row][col] == 'P') {
                        map[row][col] = '\0';
                        heroHasGold = false;
                        System.out.println("Pit removed from position (" + row + ", " + col + ").");
                    } else {
                        System.out.println("No pit at the specified pisito");
                    }
                    break;
                case 6:
                    System.out.println("Exiting map editor!");
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
                    break;
            }
        } else {
            System.out.println("Invalid position. Position should be within the game board boundaries.");
        }
        MapEditor.displayMap();
    }
}
