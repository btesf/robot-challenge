package ml.bereket.robot.service.command;

public class Left extends Command {

    @Override
    public Location getNewLocation(Location currentLocation) {
        //change the direction to the left side relative to current position; Don't change coordinate
        currentLocation.direction = currentLocation.direction.getLeft();
        return currentLocation;
    }
}
