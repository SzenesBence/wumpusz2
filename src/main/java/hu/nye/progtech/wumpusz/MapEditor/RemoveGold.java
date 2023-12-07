package hu.nye.progtech.wumpusz.MapEditor;

public class RemoveGold {
    public static void removeGold(int row, int col) {
        char[][] map = MapEditor.getMap();

        if (map[row][col] == 'G') {
            map[row][col] = '\0';
            System.out.println("Gold removed from position (" + row + ", " + col + ").");
        } else {
            System.out.println("No Gold at the specified position.");
        }
    }
}

