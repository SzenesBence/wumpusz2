package hu.nye.progtech.wumpusz.GamePlay;

import hu.nye.progtech.wumpusz.MapEditor.MapEditor;
import hu.nye.progtech.wumpusz.MapEditor.RemoveGold;

import static hu.nye.progtech.wumpusz.GamePlay.Movement.findHeroPosition;

public class PickupGold {
   public static int[] currentHeroPosition = findHeroPosition();
    public static int[] currrentGoldPosition=findGoldPosition();

    public static void goldPickUp() {
        if (currrentGoldPosition != null && isAdjacent(currentHeroPosition, currrentGoldPosition)) {
            RemoveGold.removeGold(currrentGoldPosition[0], currrentGoldPosition[1]);
            MapEditor.heroHasGold = true;
        } else {
            System.out.println("No gold nearby!");
        }
    }

    public static boolean isAdjacent(int[] position1, int[] position2) {
        int rowDiff = Math.abs(position1[0] - position2[0]);
        int colDiff = Math.abs(position1[1] - position2[1]);

        return rowDiff <= 1 && colDiff <= 1 && (rowDiff + colDiff) == 1;
    }
    public static int[] findGoldPosition() {
        int[] position = new int[2];

        for (int i = 0; i < MapEditor.map.length; i++) {
            for (int j = 0; j < MapEditor.map[i].length; j++) {
                if (MapEditor.map[i][j] == 'G') {
                    position[0] = i;
                    position[1] = j;

                    return position;
                }
            }
        }
        return null;

    }
}

