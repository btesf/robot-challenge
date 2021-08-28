package ml.bereket.robot.service.command;

import ml.bereket.robot.dto.Location;

public class WaitCommand extends Command {

    @Override
    public Location getNewLocation(Location currentLocation) {
        //Do nothing.
        return currentLocation;
    }
}
