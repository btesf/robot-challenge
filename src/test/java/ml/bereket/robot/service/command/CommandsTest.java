package ml.bereket.robot.service.command;

import ml.bereket.robot.service.Direction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommandsTest {

    private Location currentLocation;

    @BeforeEach
    public void setup(){
        currentLocation = new Location();
        currentLocation.x = 2;
        currentLocation.y = 2;
        currentLocation.direction = Direction.EAST;
    }

    @Test
    public void test_move_east(){

        currentLocation.direction = Direction.WEST;
        EastCommand command = new EastCommand();
        Location newLocation = command.getNewLocation(currentLocation);
        //coordinates do not change, direction changes to EAST
        assertEquals(newLocation.x, 2);
        assertEquals(newLocation.y, 2);
        assertEquals(newLocation.direction, Direction.EAST);
    }

    @Test
    public void test_move_west(){

        WestCommand command = new WestCommand();
        Location newLocation = command.getNewLocation(currentLocation);
        //coordinates do not change, direction changes to WEST
        assertEquals(newLocation.x, 2);
        assertEquals(newLocation.y, 2);
        assertEquals(newLocation.direction, Direction.WEST);
    }

    @Test
    public void test_move_north(){

        NorthCommand command = new NorthCommand();
        Location newLocation = command.getNewLocation(currentLocation);
        //coordinates do not change, direction changes to NORTH
        assertEquals(newLocation.x, 2);
        assertEquals(newLocation.y, 2);
        assertEquals(newLocation.direction, Direction.NORTH);
    }

    @Test
    public void test_move_south(){

        SouthCommand command = new SouthCommand();
        Location newLocation = command.getNewLocation(currentLocation);
        //coordinates do not change, direction changes to SOUTH
        assertEquals(newLocation.x, 2);
        assertEquals(newLocation.y, 2);
        assertEquals(newLocation.direction, Direction.SOUTH);
    }

    @Test
    public void test_turnaround(){

        TurnAroundCommand command = new TurnAroundCommand();
        Location newLocation = command.getNewLocation(currentLocation);
        //coordinates do not change, direction changes from EAST -> WEST
        assertEquals(newLocation.x, 2);
        assertEquals(newLocation.y, 2);
        assertEquals(newLocation.direction, Direction.WEST);

        currentLocation.direction = Direction.WEST;
        //coordinates do not change, direction changes from WEST -> EAST
        newLocation = command.getNewLocation(currentLocation);
        assertEquals(newLocation.x, 2);
        assertEquals(newLocation.y, 2);
        assertEquals(newLocation.direction, Direction.EAST);

        currentLocation.direction = Direction.NORTH;
        //coordinates do not change, direction changes from NORTH -> SOUTH
        newLocation = command.getNewLocation(currentLocation);
        assertEquals(newLocation.x, 2);
        assertEquals(newLocation.y, 2);
        assertEquals(newLocation.direction, Direction.SOUTH);

        currentLocation.direction = Direction.SOUTH;
        //coordinates do not change, direction changes from SOUTH -> NORTH
        newLocation = command.getNewLocation(currentLocation);
        assertEquals(newLocation.x, 2);
        assertEquals(newLocation.y, 2);
        assertEquals(newLocation.direction, Direction.NORTH);
    }

    @Test
    public void test_wait(){

        WaitCommand command = new WaitCommand();
        Location newLocation = command.getNewLocation(currentLocation);
        //coordinates do not change, direction do not change
        assertEquals(newLocation.x, 2);
        assertEquals(newLocation.y, 2);
        assertEquals(newLocation.direction, Direction.EAST);
    }

    @Test
    public void test_move_left(){

        LeftCommand command = new LeftCommand();
        Location newLocation = command.getNewLocation(currentLocation);
        //coordinates do not change, direction changes from EAST -> NORTH
        assertEquals(newLocation.x, 2);
        assertEquals(newLocation.y, 2);
        assertEquals(newLocation.direction, Direction.NORTH);

        //coordinates do not change, direction changes from NORTH -> WEST
        newLocation = command.getNewLocation(currentLocation);
        assertEquals(newLocation.x, 2);
        assertEquals(newLocation.y, 2);
        assertEquals(newLocation.direction, Direction.WEST);

        //coordinates do not change, direction changes from WEST -> SOUTH
        newLocation = command.getNewLocation(currentLocation);
        assertEquals(newLocation.x, 2);
        assertEquals(newLocation.y, 2);
        assertEquals(newLocation.direction, Direction.SOUTH);

        //coordinates do not change, direction changes from SOUTH -> EAST
        newLocation = command.getNewLocation(currentLocation);
        assertEquals(newLocation.x, 2);
        assertEquals(newLocation.y, 2);
        assertEquals(newLocation.direction, Direction.EAST);
    }

    @Test
    public void test_move_right(){

        RightCommand command = new RightCommand();
        Location newLocation = command.getNewLocation(currentLocation);
        //coordinates do not change, direction changes from EAST -> SOUTH
        assertEquals(newLocation.x, 2);
        assertEquals(newLocation.y, 2);
        assertEquals(newLocation.direction, Direction.SOUTH);

        //coordinates do not change, direction changes from SOUTH -> WEST
        newLocation = command.getNewLocation(currentLocation);
        assertEquals(newLocation.x, 2);
        assertEquals(newLocation.y, 2);
        assertEquals(newLocation.direction, Direction.WEST);

        //coordinates do not change, direction changes from WEST -> NORTH
        newLocation = command.getNewLocation(currentLocation);
        assertEquals(newLocation.x, 2);
        assertEquals(newLocation.y, 2);
        assertEquals(newLocation.direction, Direction.NORTH);

        //coordinates do not change, direction changes from NORTH -> EAST
        newLocation = command.getNewLocation(currentLocation);
        assertEquals(newLocation.x, 2);
        assertEquals(newLocation.y, 2);
        assertEquals(newLocation.direction, Direction.EAST);
    }

    @Test
    public void test_set_position(){

        Location moveLocation = new Location();
        moveLocation.x = 3;
        moveLocation.y = 3;
        moveLocation.direction = Direction.NORTH;

        PositionCommand command = new PositionCommand(moveLocation);
        Location newLocation = command.getNewLocation(currentLocation);
        //coordinates and directions will change to the "moveLocation" location
        assertEquals(newLocation.x, 3);
        assertEquals(newLocation.y, 3);
        assertEquals(newLocation.direction, Direction.NORTH);
    }

    @Test
    public void test_move_forward(){
        //move forward by two steps from current position
        ForwardCommand command = new ForwardCommand(2);
        Location newLocation = command.getNewLocation(currentLocation);
        //coordinates and directions will change to the "moveLocation" location
        assertEquals(newLocation.x, 4);
        assertEquals(newLocation.y, 2);
        assertEquals(newLocation.direction, Direction.EAST);
    }
}