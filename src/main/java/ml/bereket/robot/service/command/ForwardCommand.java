package ml.bereket.robot.service.command;


import ml.bereket.robot.dto.Location;

public class ForwardCommand extends Command {

    private int steps = 0;
    private final int gridColumns;
    private final int gridRows;

    public ForwardCommand(Integer steps, Integer gridColumns, Integer gridRows) {
        this.steps = steps;
        this.gridColumns = gridColumns;
        this.gridRows = gridRows;
    }

    /*
     * Moves x steps in the current direction;
     * WestCommand - Decreases X coordinate by "steps" amount
     * EastCommand - Increases X coordinate by "steps" amount
     * NorthCommand - Decreases Y coordinate by "steps" amount
     * SouthCommand - Increases Y coordinate by "steps" amount
     */
    @Override
    public Location getNewLocation(Location currentLocation) {

        int x = currentLocation.getCoordinate().getX();
        int y = currentLocation.getCoordinate().getY();

        switch(currentLocation.getDirection()){
            case EAST:
                if(x < (gridColumns - 1)) x += steps;
                break;
            case WEST:
                if(x > 0)  x -= steps;
                break;
            case SOUTH:
                if(y < (gridRows - 1)) y += steps;
                break;
            case NORTH:
                if(y > 0) y -= steps;
                break;
            default:
        }
        currentLocation.getCoordinate().setX(x);
        currentLocation.getCoordinate().setY(y);
        return currentLocation;
    }

    public int getSteps() {
        return steps;
    }
}
