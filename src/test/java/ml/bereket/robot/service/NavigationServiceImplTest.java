package ml.bereket.robot.service;

import ml.bereket.robot.dto.CommandDto;
import ml.bereket.robot.service.command.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NavigationServiceImplTest {

    private NavigationServiceImpl navigationService;

    @BeforeEach
    public void setup(){
        this.navigationService = new NavigationServiceImpl(new CommandFactory());
    }

    @Test
    void prepareCommands() {
        List<CommandDto> commandDtos = new ArrayList<>();
        CommandDto dto = new CommandDto();
        dto.setType(CommandType.EAST);
        commandDtos.add(dto);

        dto = new CommandDto();
        dto.setType(CommandType.WEST);
        commandDtos.add(dto);

        dto = new CommandDto();
        dto.setType(CommandType.POSITION);
        Location destination = new Location();
        destination.setDirection(Direction.NORTH);
        dto.setLocation(destination);
        commandDtos.add(dto);

        dto = new CommandDto();
        dto.setType(CommandType.FORWARD);
        dto.setSteps(3);
        commandDtos.add(dto);

        List<Command> commands = navigationService.prepareCommands(commandDtos);
        //first DTO should result EastCommand
        assertTrue(commands.get(0) instanceof EastCommand);
        //second DTO should result WestCommand
        assertTrue(commands.get(1) instanceof WestCommand);
        //third DTO should result PositionCommand
        assertTrue(commands.get(2) instanceof PositionCommand);
        PositionCommand positionCommand = ((PositionCommand)commands.get(2));
        assertEquals(positionCommand.getLocation().getDirection(), Direction.NORTH);
        //fourth DTO should result ForwardCommand
        assertTrue(commands.get(3) instanceof ForwardCommand);
        assertEquals(((ForwardCommand)commands.get(3)).getSteps(), 3);
    }

    @Test
    void moveRobot() {

        List<Command> commands = new ArrayList<>();
        //Position command: Put robot at (x,y) -> (1, 3) EAST
        Location location = new Location();
        location.setX(1);
        location.setY(3);
        location.setDirection(Direction.EAST);
        PositionCommand positionCommand = new PositionCommand(location);
        commands.add(positionCommand);

        //Forward robot by 3 steps: New location -> (4,3) EAST
        ForwardCommand forwardCommand = new ForwardCommand(3);
        commands.add(forwardCommand);

        //Wait there
        WaitCommand waitCommand = new WaitCommand();
        commands.add(waitCommand);

        //TurnAround to opposite direction: New location -> (4,3) WEST
        TurnAroundCommand turnAroundCommand = new TurnAroundCommand();
        commands.add(turnAroundCommand);

        //Forward robot by 1 steps: New location -> (3,3) WEST
        forwardCommand = new ForwardCommand(1);
        commands.add(forwardCommand);

        //Turn robot right: New location -> (3,3) NORTH
        RightCommand rightCommand = new RightCommand();
        commands.add(rightCommand);

        //set initial location for Robot at (0,0) and random Direction
        Location initialLocation = new Location();
        initialLocation.setDirection(Direction.SOUTH);
        initialLocation.setX(0);
        initialLocation.setY(0);
        //move Robot
        Location destinationLocation = navigationService.moveRobot(initialLocation, commands);
        //location should be (3,3) NORTH
        assertEquals(destinationLocation.getDirection(), Direction.NORTH);
        assertEquals(destinationLocation.getX(), 3);
        assertEquals(destinationLocation.getY(), 3);
    }
}