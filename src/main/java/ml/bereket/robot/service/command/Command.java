package ml.bereket.robot.service.command;

import ml.bereket.robot.dto.Location;

public abstract class Command {

    public abstract Location getNewLocation(Location currentLocation);
}
