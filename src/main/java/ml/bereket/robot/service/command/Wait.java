package ml.bereket.robot.service.command;

public class Wait extends Command {

    @Override
    public Location getNewLocation(Location currentLocation) {
        //Do nothing.
        return currentLocation;
    }
}
