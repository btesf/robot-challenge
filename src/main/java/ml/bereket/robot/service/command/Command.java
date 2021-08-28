package ml.bereket.robot.service.command;

public abstract class Command {

    public abstract Location getNewLocation(Location currentLocation);
}
