package hu.nye.progtech.wumpusz.GamePlay;

public class Turn {
    public enum Direction {
        NORTH,
        SOUTH,
        EAST,
        WEST
    }

    private static Direction heroDirection = Direction.NORTH;

    public static void turnLeft(char[][] map, int heroRow, int heroCol) {
        Direction newDirection = calculateTurnLeftDirection(heroDirection);

        if (isValidDirection(map, heroRow, heroCol, newDirection)) {
            heroDirection = newDirection;
        }
    }

    public static void turnRight(char[][] map, int heroRow, int heroCol) {
        Direction newDirection = calculateTurnRightDirection(heroDirection);

        if (isValidDirection(map, heroRow, heroCol, newDirection)) {
            heroDirection = newDirection;
        }
    }

    public static void displayHeroDirection() {
        System.out.println("Hero is facing " + heroDirection);
    }

    private static Direction calculateTurnLeftDirection(Direction currentDirection) {
        switch (currentDirection) {
            case NORTH:
                return Direction.WEST;
            case SOUTH:
                return Direction.EAST;
            case EAST:
                return Direction.NORTH;
            case WEST:
                return Direction.SOUTH;
            default:
                return currentDirection;
        }
    }

    private static Direction calculateTurnRightDirection(Direction currentDirection) {
        switch (currentDirection) {
            case NORTH:
                return Direction.EAST;
            case SOUTH:
                return Direction.WEST;
            case EAST:
                return Direction.SOUTH;
            case WEST:
                return Direction.NORTH;
            default:
                return currentDirection;
        }
    }

    private static boolean isValidDirection(char[][] map, int heroRow, int heroCol, Direction direction) {
        switch (direction) {
            case NORTH:
                return heroRow > 0 && map[heroRow - 1][heroCol] != 'W';
            case SOUTH:
                return heroRow < map.length - 1 && map[heroRow + 1][heroCol] != 'W';
            case EAST:
                return heroCol < map[0].length - 1 && map[heroRow][heroCol + 1] != 'W';
            case WEST:
                return heroCol > 0 && map[heroRow][heroCol - 1] != 'W';
            default:
                return false;
        }
    }
}


