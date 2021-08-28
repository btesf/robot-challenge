package ml.bereket.robot.service.command;

import ml.bereket.robot.dto.Location;

public class RightCommand extends Command {

    @Override
    public Location getNewLocation(Location currentLocation) {
        //change the direction to the right side relative to current position; Don't change coordinate
        currentLocation.setDirection(currentLocation.getDirection().getRight());
        return currentLocation;
    }
}
