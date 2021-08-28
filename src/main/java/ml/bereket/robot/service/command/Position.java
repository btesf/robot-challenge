package ml.bereket.robot.service.command;

public class Position extends Command {

    private Location location;

    public Position(Location location){
        this.location = location;
    }

    @Override
    public Location getNewLocation(Location currentLocation) {
        //returns new location already passed as part of the command; Current location is unimportant
        return location;
    }
}
