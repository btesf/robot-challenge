package ml.bereket.robot.service.command;

public class Forward extends Command {

    private int steps = 0;

    public Forward(int steps) {
        this.steps = steps;
    }

    @Override
    public Location getNewLocation(Location currentLocation) {
        return null;
    }
}
