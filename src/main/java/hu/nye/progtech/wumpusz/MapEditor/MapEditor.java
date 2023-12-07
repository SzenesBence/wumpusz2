package hu.nye.progtech.wumpusz.MapEditor;

import hu.nye.progtech.wumpusz.Menu.Menu;
import hu.nye.progtech.wumpusz.Menu.UserName;

import java.util.Scanner;


public class MapEditor {
    public static char[][] map;
    public static int wumpusCount;
    public static int arrowCount;
    public static boolean heroHasGold;
    public static int N;

    public static void MapInitialization() {
        System.out.println("Enter the size of the map! ");
        Scanner scanner = new Scanner(System.in);
         N= scanner.nextInt();
        if (N < 6 || N > 20) {
            throw new NullPointerException("Square table size must be between 6 and 20.");
        }
            map = new char[N][N];
            //wumpusCount = calculateWumpusCount(N);
            arrowCount = calculateArrowCount(wumpusCount);
            heroHasGold = false;
            for (int i = 0; i < N; i++) {
                map[0][i] = 'W'; //  first row
                map[N - 1][i] = 'W'; //  last row
                map[i][0] = 'W'; // first column
                map[i][N - 1] = 'W'; //  last column
        }
    }
    public static void startMapEditing() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nMap Editing:");
        MapInitialization();
        while (true) {
            System.out.println("\nEditing Options:");
            System.out.println("1. Add Element");
            System.out.println("2. Remove Element");
            System.out.println("3. Finish Editing");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    AddElement addElement = new AddElement();
                    addElement.initialize(map);
                    addElement.addElement();
                    break;

                case 2:
                    RemoveElement removeElement = new RemoveElement();
                    removeElement.initialize(map, wumpusCount);
                    removeElement.removeElement();
                    break;

                case 3:
                    Menu.displayMenu(UserName.username);
                    System.out.println("Finishing Game Board Editing.");
                    return;

                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 3.");
                    break;
            }
        }
    }

    public static int calculateArrowCount(int wumpusCount) {
        return wumpusCount;
    }

    public static void displayMap() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                char displayChar = (map[i][j] == '\0') ? '_' : map[i][j];
                System.out.print(displayChar + " ");
            }
            System.out.println();
        }
    }
    public static boolean isValidPosition(int row, int col) {
        return row > 0 && row < map.length - 1 && col > 0 && col < map[0].length - 1;
    }

    public static char[][] getMap() {
        return map;
    }
}
