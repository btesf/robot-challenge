package ml.bereket.robot.service.command;

public class ForwardCommand extends Command {

    private int steps = 0;

    public ForwardCommand(int steps) {
        this.steps = steps;
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

    public int getSteps() {
        return steps;
    }
}
