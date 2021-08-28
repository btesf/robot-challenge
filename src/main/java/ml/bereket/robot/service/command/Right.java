package ml.bereket.robot.service.command;

public class Right extends Command {

    @Override
    public Location getNewLocation(Location currentLocation) {
        //change the direction to the right side relative to current position; Don't change coordinate
        currentLocation.direction = currentLocation.direction.getRight();
        return currentLocation;
    }
}
