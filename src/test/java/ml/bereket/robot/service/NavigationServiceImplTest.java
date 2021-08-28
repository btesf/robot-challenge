package ml.bereket.robot.service;

import ml.bereket.robot.dto.Coordinate;
import ml.bereket.robot.dto.Location;
import ml.bereket.robot.service.command.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NavigationServiceImplTest {

    private NavigationServiceImpl navigationService;

    @BeforeEach
    public void setup(){
        this.navigationService = new NavigationServiceImpl();
    }

    @Test
    void test_move_robot() {

        List<Command> commands = new ArrayList<>();
        //Position command: Put robot at (x,y) -> (1, 3) EAST
        Location location = new Location();
        location.setCoordinate(new Coordinate(1,3));
        location.setDirection(Direction.EAST);
        PositionCommand positionCommand = new PositionCommand(location);
        commands.add(positionCommand);

        //Forward robot by 3 steps: New location -> (4,3) EAST
        ForwardCommand forwardCommand = new ForwardCommand(3, 5, 5);
        commands.add(forwardCommand);

        //Wait there
        WaitCommand waitCommand = new WaitCommand();
        commands.add(waitCommand);

        //TurnAround to opposite direction: New location -> (4,3) WEST
        TurnAroundCommand turnAroundCommand = new TurnAroundCommand();
        commands.add(turnAroundCommand);

        //Forward robot by 1 steps: New location -> (3,3) WEST
        forwardCommand = new ForwardCommand(1, 5, 5);
        commands.add(forwardCommand);

        //Turn robot right: New location -> (3,3) NORTH
        RightCommand rightCommand = new RightCommand();
        commands.add(rightCommand);

        //set initial location for Robot at (0,0) and random Direction
        Location initialLocation = new Location();
        initialLocation.setDirection(Direction.SOUTH);
        initialLocation.setCoordinate(new Coordinate(0,0));
        //move Robot
        Location destinationLocation = navigationService.moveRobot(initialLocation, commands);
        //location should be (3,3) NORTH
        assertEquals(destinationLocation.getDirection(), Direction.NORTH);
        assertEquals(destinationLocation.getCoordinate().getX(), 3);
        assertEquals(destinationLocation.getCoordinate().getY(), 3);
    }
}