package ml.bereket.robot.service.command;

import ml.bereket.robot.dto.Location;

public class LeftCommand extends Command {

    @Override
    public Location getNewLocation(Location currentLocation) {
        //change the direction to the left side relative to current position; Don't change coordinate
        currentLocation.setDirection(currentLocation.getDirection().getLeft());
        return currentLocation;
    }
}
