package hu.nye.progtech.wumpusz.GamePlay;

import hu.nye.progtech.wumpusz.MapEditor.MapEditor;
import java.util.Scanner;

public class Movement {
    public static void moveHero() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nMove Options:");
        System.out.println("1. Move Up");
        System.out.println("2. Move Down");
        System.out.println("3. Move Left");
        System.out.println("4. Move Right");
        System.out.print("Enter your move choice: ");
        int moveChoice = scanner.nextInt();

        int[] currentHeroPosition = findHeroPosition();

        switch (moveChoice) {
            case 1:
                moveUp(currentHeroPosition);
                break;

            case 2:
                moveDown(currentHeroPosition);
                break;

            case 3:
                moveLeft(currentHeroPosition);
                break;

            case 4:
                moveRight(currentHeroPosition);
                break;

            default:
                System.out.println("Invalid move choice. Please enter a number between 1 and 4.");
                break;
        }

        MapEditor.displayMap();
    }

    public static int[] findHeroPosition() {
        int[] position = new int[2];

        for (int i = 0; i < MapEditor.map.length; i++) {
            for (int j = 0; j < MapEditor.map[i].length; j++) {
                if (MapEditor.map[i][j] == 'H') {
                    position[0] = i;
                    position[1] = j;
                    return position;
                }
            }
        }

        position[0] = -1;
        position[1] = -1;
        return position;
    }

    private static void moveUp(int[] position) {
        int row = position[0];
        int col = position[1];

        if (MapEditor.isValidPosition(row - 1, col) && MapEditor.map[row - 1][col] != 'W') {
            MapEditor.map[row][col] = '_';
            MapEditor.map[row - 1][col] = 'H';
        } else {
            System.out.println("Invalid move. Cannot move up.");
        }
    }

    private static void moveDown(int[] position) {
        int row = position[0];
        int col = position[1];

        if (MapEditor.isValidPosition(row + 1, col) && MapEditor.map[row + 1][col] != 'W') {
            MapEditor.map[row][col] = '_';
            MapEditor.map[row + 1][col] = 'H';
        } else {
            System.out.println("Invalid move. Cannot move up.");
        }
    }

    private static void moveLeft(int[] position) {
        int row = position[0];
        int col = position[1];

        if (MapEditor.isValidPosition(row , col - 1 ) && MapEditor.map[row ][col - 1] != 'W') {
            MapEditor.map[row][col] = '_';
            MapEditor.map[row][col - 1] = 'H';
        } else {
            System.out.println("Invalid move. Cannot move up.");
        }

    }

    private static void moveRight(int[] position) {
        int row = position[0];
        int col = position[1];

        if (MapEditor.isValidPosition(row , col + 1 ) && MapEditor.map[row ][col + 1] != 'W') {
            MapEditor.map[row][col] = '_';
            MapEditor.map[row][col + 1] = 'H';
        } else {
            System.out.println("Invalid move. Cannot move up.");
        }
    }
}
