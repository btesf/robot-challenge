package ml.bereket.robot.service.command;

import ml.bereket.robot.dto.Location;

public class TurnAroundCommand extends Command {

    @Override
    public Location getNewLocation(Location currentLocation) {
        //change the direction to the opposite side relative to current position; Don't change coordinate
        currentLocation.setDirection(currentLocation.getDirection().getOpposite());
        return currentLocation;
    }
}
