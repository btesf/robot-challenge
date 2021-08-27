package ml.bereket.robot.service.command;

public abstract class Command {

    abstract Location getNewLocation(Location currentLocation);
}
