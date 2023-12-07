package hu.nye.progtech.wumpusz.Menu;

import hu.nye.progtech.wumpusz.GamePlay.Gameplay;
import hu.nye.progtech.wumpusz.MapEditor.AddElement;
import hu.nye.progtech.wumpusz.MapEditor.MapEditor;

import java.util.Scanner;

import static hu.nye.progtech.wumpusz.MapEditor.MapEditor.map;
import static hu.nye.progtech.wumpusz.MapEditor.MapEditor.wumpusCount;

public class Menu {

    public static void displayMenu(String username) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Welcome " + username + ":");
            System.out.println("1. Map Editor");
            System.out.println("2. Play");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Selected: Map Editor");
                    MapEditor gameBoardEditor = new MapEditor();
                   gameBoardEditor.startMapEditing();
                    gameBoardEditor.displayMap();
                    break;


                case 2:
                    System.out.println("Selected: Play");
                    Gameplay gameplay= new Gameplay(map,wumpusCount);
                    gameplay.playGame();
                    System.exit(0);
                    break;

                case 3:
                    System.out.println("Exiting the program. Goodbye, " + username + "!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
                    break;
            }
        }

    }
}