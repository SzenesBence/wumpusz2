package Menu;

import java.util.Scanner;

public class Menu {

    public static final UserName USER_NAME = new UserName();

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        USER_NAME.setUsername();
        String username = USER_NAME.getUsername();
        System.out.println("Welcome, " + username + "!");
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Map Maker");
            System.out.println("2. File Read");
            System.out.println("3. Load Database");
            System.out.println("4. Save Database");
            System.out.println("5. Play");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Selected: Map Maker");
                    // Add your map maker logic here
                    System.exit(0);
                    break;

                case 2:
                    System.out.println("Selected: File Read");
                    // Add your file read logic here
                    System.exit(0);
                    break;

                case 3:
                    System.out.println("Selected: Load Database");
                    // Add your load database logic here
                    System.exit(0);
                    break;

                case 4:
                    System.out.println("Selected: Save Database");
                    // Add your save database logic here
                    System.exit(0);
                    break;

                case 5:
                    System.out.println("Selected: Play");
                    // Add your play logic here
                    System.exit(0);
                    break;
                case 6:
                    System.out.println("Exiting the program. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
                    break;
            }
        }
    }
    }


