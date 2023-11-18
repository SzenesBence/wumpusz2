package Menu;

import java.util.Scanner;

public class UserName {
    private String username;

    public void setUsername() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your username: ");
        this.username = scanner.nextLine();
    }

    public String getUsername() {
        return username;
    }
}