package ml.bereket.robot.service.command;

import ml.bereket.robot.dto.Coordinate;
import ml.bereket.robot.dto.Location;
import ml.bereket.robot.service.Direction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommandsTest {

    private Location currentLocation;

    @BeforeEach
    public void setup(){
        currentLocation = new Location();
        currentLocation.setCoordinate(new Coordinate(2, 2));
        currentLocation.setDirection(Direction.EAST);
    }

    @Test
    public void test_move_east(){

        currentLocation.setDirection(Direction.WEST);
        EastCommand command = new EastCommand();
        Location newLocation = command.getNewLocation(currentLocation);
        //coordinates do not change, direction changes to EAST
        assertEquals(newLocation.getCoordinate().getX(), 2);
        assertEquals(newLocation.getCoordinate().getY(), 2);
        assertEquals(newLocation.getDirection(), Direction.EAST);
    }

    @Test
    public void test_move_west(){

        WestCommand command = new WestCommand();
        Location newLocation = command.getNewLocation(currentLocation);
        //coordinates do not change, direction changes to WEST
        assertEquals(newLocation.getCoordinate().getX(), 2);
        assertEquals(newLocation.getCoordinate().getY(), 2);
        assertEquals(newLocation.getDirection(), Direction.WEST);
    }

    @Test
    public void test_move_north(){

        NorthCommand command = new NorthCommand();
        Location newLocation = command.getNewLocation(currentLocation);
        //coordinates do not change, direction changes to NORTH
        assertEquals(newLocation.getCoordinate().getX(), 2);
        assertEquals(newLocation.getCoordinate().getY(), 2);
        assertEquals(newLocation.getDirection(), Direction.NORTH);
    }

    @Test
    public void test_move_south(){

        SouthCommand command = new SouthCommand();
        Location newLocation = command.getNewLocation(currentLocation);
        //coordinates do not change, direction changes to SOUTH
        assertEquals(newLocation.getCoordinate().getX(), 2);
        assertEquals(newLocation.getCoordinate().getY(), 2);
        assertEquals(newLocation.getDirection(), Direction.SOUTH);
    }

    @Test
    public void test_turnaround(){

        TurnAroundCommand command = new TurnAroundCommand();
        Location newLocation = command.getNewLocation(currentLocation);
        //coordinates do not change, direction changes from EAST -> WEST
        assertEquals(newLocation.getCoordinate().getX(), 2);
        assertEquals(newLocation.getCoordinate().getY(), 2);
        assertEquals(newLocation.getDirection(), Direction.WEST);

        currentLocation.setDirection(Direction.WEST);
        //coordinates do not change, direction changes from WEST -> EAST
        newLocation = command.getNewLocation(currentLocation);
        assertEquals(newLocation.getCoordinate().getX(), 2);
        assertEquals(newLocation.getCoordinate().getY(), 2);
        assertEquals(newLocation.getDirection(), Direction.EAST);

        currentLocation.setDirection(Direction.NORTH);
        //coordinates do not change, direction changes from NORTH -> SOUTH
        newLocation = command.getNewLocation(currentLocation);
        assertEquals(newLocation.getCoordinate().getX(), 2);
        assertEquals(newLocation.getCoordinate().getY(), 2);
        assertEquals(newLocation.getDirection(), Direction.SOUTH);

        currentLocation.setDirection(Direction.SOUTH);
        //coordinates do not change, direction changes from SOUTH -> NORTH
        newLocation = command.getNewLocation(currentLocation);
        assertEquals(newLocation.getCoordinate().getX(), 2);
        assertEquals(newLocation.getCoordinate().getY(), 2);
        assertEquals(newLocation.getDirection(), Direction.NORTH);
    }

    @Test
    public void test_wait(){

        WaitCommand command = new WaitCommand();
        Location newLocation = command.getNewLocation(currentLocation);
        //coordinates do not change, direction do not change
        assertEquals(newLocation.getCoordinate().getX(), 2);
        assertEquals(newLocation.getCoordinate().getY(), 2);
        assertEquals(newLocation.getDirection(), Direction.EAST);
    }

    @Test
    public void test_move_left(){

        LeftCommand command = new LeftCommand();
        Location newLocation = command.getNewLocation(currentLocation);
        //coordinates do not change, direction changes from EAST -> NORTH
        assertEquals(newLocation.getCoordinate().getX(), 2);
        assertEquals(newLocation.getCoordinate().getY(), 2);
        assertEquals(newLocation.getDirection(), Direction.NORTH);

        //coordinates do not change, direction changes from NORTH -> WEST
        newLocation = command.getNewLocation(currentLocation);
        assertEquals(newLocation.getCoordinate().getX(), 2);
        assertEquals(newLocation.getCoordinate().getY(), 2);
        assertEquals(newLocation.getDirection(), Direction.WEST);

        //coordinates do not change, direction changes from WEST -> SOUTH
        newLocation = command.getNewLocation(currentLocation);
        assertEquals(newLocation.getCoordinate().getX(), 2);
        assertEquals(newLocation.getCoordinate().getY(), 2);
        assertEquals(newLocation.getDirection(), Direction.SOUTH);

        //coordinates do not change, direction changes from SOUTH -> EAST
        newLocation = command.getNewLocation(currentLocation);
        assertEquals(newLocation.getCoordinate().getX(), 2);
        assertEquals(newLocation.getCoordinate().getY(), 2);
        assertEquals(newLocation.getDirection(), Direction.EAST);
    }

    @Test
    public void test_move_right(){

        RightCommand command = new RightCommand();
        Location newLocation = command.getNewLocation(currentLocation);
        //coordinates do not change, direction changes from EAST -> SOUTH
        assertEquals(newLocation.getCoordinate().getX(), 2);
        assertEquals(newLocation.getCoordinate().getY(), 2);
        assertEquals(newLocation.getDirection(), Direction.SOUTH);

        //coordinates do not change, direction changes from SOUTH -> WEST
        newLocation = command.getNewLocation(currentLocation);
        assertEquals(newLocation.getCoordinate().getX(), 2);
        assertEquals(newLocation.getCoordinate().getY(), 2);
        assertEquals(newLocation.getDirection(), Direction.WEST);

        //coordinates do not change, direction changes from WEST -> NORTH
        newLocation = command.getNewLocation(currentLocation);
        assertEquals(newLocation.getCoordinate().getX(), 2);
        assertEquals(newLocation.getCoordinate().getY(), 2);
        assertEquals(newLocation.getDirection(), Direction.NORTH);

        //coordinates do not change, direction changes from NORTH -> EAST
        newLocation = command.getNewLocation(currentLocation);
        assertEquals(newLocation.getCoordinate().getX(), 2);
        assertEquals(newLocation.getCoordinate().getY(), 2);
        assertEquals(newLocation.getDirection(), Direction.EAST);
    }

    @Test
    public void test_set_position(){

        Location moveLocation = new Location();
        moveLocation.setCoordinate(new Coordinate(3, 3));
        moveLocation.setDirection(Direction.NORTH);

        PositionCommand command = new PositionCommand(moveLocation);
        Location newLocation = command.getNewLocation(currentLocation);
        //coordinates and directions will change to the "moveLocation" location
        assertEquals(newLocation.getCoordinate().getX(), 3);
        assertEquals(newLocation.getCoordinate().getY(), 3);
        assertEquals(newLocation.getDirection(), Direction.NORTH);
    }

    @Test
    public void test_move_forward(){
        //move forward by two steps from current position
        ForwardCommand command = new ForwardCommand(2, 5, 5);
        Location newLocation = command.getNewLocation(currentLocation);
        //coordinates and directions will change to the "moveLocation" location
        assertEquals(newLocation.getCoordinate().getX(), 4);
        assertEquals(newLocation.getCoordinate().getY(), 2);
        assertEquals(newLocation.getDirection(), Direction.EAST);

        //robot cannot move beyond the grid X limit. From position (4, 4) try to move it forward EAST by 2 steps.
        currentLocation = new Location();
        currentLocation.setDirection(Direction.EAST);
        currentLocation.setCoordinate(new Coordinate(4, 4));
        newLocation = command.getNewLocation(currentLocation);
        //robot should remain at the 5th column (index 4)
        assertEquals(newLocation.getCoordinate().getX(), 4);
        assertEquals(newLocation.getCoordinate().getY(), 4);
        assertEquals(newLocation.getDirection(), Direction.EAST);

        //robot cannot move beyond the grid Y limit. From position (4, 2) try to move it forward SOUTH by 2 steps.
        currentLocation = new Location();
        currentLocation.setDirection(Direction.SOUTH);
        currentLocation.setCoordinate(new Coordinate(4, 4));
        newLocation = command.getNewLocation(currentLocation);
        //robot should remain at the 5th column (index 4)
        assertEquals(newLocation.getCoordinate().getX(), 4);
        assertEquals(newLocation.getCoordinate().getY(), 4);
        assertEquals(newLocation.getDirection(), Direction.SOUTH);

    }
}