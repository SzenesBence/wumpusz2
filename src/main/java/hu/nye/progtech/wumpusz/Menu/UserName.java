package hu.nye.progtech.wumpusz.Menu;

import java.util.Scanner;

public class UserName {
    public static String username;
    public static String getUsername() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your username: ");
       return  username=scanner.nextLine();
    }

}