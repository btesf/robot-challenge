package ml.bereket.robot.service.command;

public class WaitCommand extends Command {

    @Override
    public Location getNewLocation(Location currentLocation) {
        //Do nothing.
        return currentLocation;
    }
}
