package ml.bereket.robot.service.command;

public class PositionCommand extends Command {

    private Location location;

    public PositionCommand(Location location){
        this.location = location;
    }

    @Override
    public Location getNewLocation(Location currentLocation) {
        //returns new location already passed as part of the command; Current location is unimportant
        return location;
    }

    public Location getLocation() {
        return location;
    }
}
