package ml.bereket.robot.service.command;

public class TurnAroundCommand extends Command {

    @Override
    public Location getNewLocation(Location currentLocation) {
        //change the direction to the opposite side relative to current position; Don't change coordinate
        currentLocation.direction = currentLocation.direction.getOpposite();
        return currentLocation;
    }
}
