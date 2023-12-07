package hu.nye.progtech.wumpusz;

import hu.nye.progtech.wumpusz.MapEditor.AddElement;
import hu.nye.progtech.wumpusz.MapEditor.MapEditor;
import hu.nye.progtech.wumpusz.MapEditor.RemoveElement;
import hu.nye.progtech.wumpusz.Menu.Menu;
import hu.nye.progtech.wumpusz.Menu.UserName;

public class Main {
    public static void main(String[] args) {
       String username= UserName.getUsername();
        Menu.displayMenu(username);

    }
}
