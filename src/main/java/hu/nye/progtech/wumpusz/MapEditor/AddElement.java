package hu.nye.progtech.wumpusz.MapEditor;

import java.util.Scanner;

public class AddElement {
    private static char[][] map;
    private static final int n = MapEditor.N;

    public static int getWumpusCount() {
        return wumpusCount;
    }

    private static int wumpusCount;
    private static final int wumpusLimit = calculateWumpusCount();
    private static boolean heroHasGold=false;
    private static int goldcount;
    private static int herocount;

    public static void initialize(char[][] gameBoard) {
        map = gameBoard;
        heroHasGold = false;
    }

    public void addElement() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("\nAdd Element:");
        System.out.println("1. Wumpus");
        System.out.println("2. Hero");
        System.out.println("3. Gold");
        System.out.println("4. Wall");
        System.out.println("5. Pit");
        System.out.println("6. Exit");

        System.out.print("Enter the element to add: ");
        int elementChoice = scanner.nextInt();

        System.out.print("Enter the row: ");
        int row = scanner.nextInt();

        System.out.print("Enter the column: ");
        int col = scanner.nextInt();

        if (isValidPosition(row, col)) {
            switch (elementChoice) {
                case 1:
                    if (wumpusCount < wumpusLimit) {
                        map[row][col] = 'U';
                        System.out.println("Wumpus added at position (" + row + ", " + col + ").");
                        wumpusCount++;
                        System.out.println(wumpusCount);
                    } else {
                        System.out.println("No more Wumpus allowed.");
                    }
                    break;

                case 2:
                    if (!heroHasGold && herocount < 1) {
                        map[row][col] = 'H';
                        herocount++;
                      //  arrowCount = MapEditor.calculateArrowCount(wumpusCount);
                        System.out.println("Hero added at position (" + row + ", " + col + ").");
                    } else {
                        System.out.println("Hero already has the gold. Cannot add another hero.");
                    }
                    break;

                case 3:
                    if (!heroHasGold && goldcount < 1) {
                        map[row][col] = 'G';
                        goldcount++;
                        heroHasGold = true;
                        System.out.println("Gold added at position (" + row + ", " + col + ").");
                    } else {
                        System.out.println("Cannot add more gold.");
                    }
                    break;

                case 4:
                    if (!heroHasGold) {
                        map[row][col] = 'W';
                        System.out.println("Wall added at position (" + row + ", " + col + ").");
                    } else {
                        System.out.println("Cannot add wall here.");
                    }
                    break;
                case 5:
                    if (!heroHasGold) {
                        map[row][col] = 'P';
                        System.out.println("Pit added at position (" + row + ", " + col + ").");
                    } else {
                        System.out.println("Cannot add pit here.");
                    }
                    break;

                case 6:
                    System.out.println("Exiting map editor!");
                    MapEditor.startMapEditing();
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

    private static boolean isValidPosition(int row, int col) {
        return row >= 0 && row < map.length && col >= 0 && col < map[0].length;
    }
    private static int calculateWumpusCount() {
        if (AddElement.n <= 8) {
            return 1;
        } else if (AddElement.n <= 14) {
            return 2;
        } else {
            return 3;
        }
    }


}
