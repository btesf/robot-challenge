package ml.bereket.robot.service.command;

public class Forward extends Command {

    private int steps = 0;

    public Forward(int steps) {
        this.steps = steps;
    }

    /*
     * Moves x steps in the current direction;
     * West - Decreases X coordinate by "steps" amount
     * East - Increases X coordinate by "steps" amount
     * North - Decreases Y coordinate by "steps" amount
     * South - Increases Y coordinate by "steps" amount
     */
    @Override
    public Location getNewLocation(Location currentLocation) {

        int x = currentLocation.x;
        int y = currentLocation.y;

        switch(currentLocation.direction){
            case EAST:
                x+=steps;
                break;
            case WEST:
                x-=steps;
                break;
            case SOUTH:
                y+=steps;
                break;
            case NORTH:
                y-=steps;
                break;
            default:
        }
        currentLocation.x = x;
        currentLocation.y = y;

        return currentLocation;
    }
}
