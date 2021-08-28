package ml.bereket.robot.service.command;

import ml.bereket.robot.service.Direction;

public class East extends Command {

    @Override
    public Location getNewLocation(Location currentLocation) {
        //only change the direction; keep the current coordinates
        currentLocation.direction = Direction.EAST;
        return currentLocation;
    }
}
