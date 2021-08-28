package ml.bereket.robot.service;

import ml.bereket.robot.service.command.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CommandParserServiceImplTest {

    private CommandParserServiceImpl commandParserService;

    @BeforeEach
    public void setup(){
        this.commandParserService = new CommandParserServiceImpl();
    }

    @Test
    void test_parse_commands() {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("EAST\n");
        stringBuilder.append("WEST\r\n");
        stringBuilder.append("POSITION 1 2 NORTH\n");
        stringBuilder.append("FORWARD 3\n");

        List<Command> commands = commandParserService.parseCommands(stringBuilder.toString(), null);
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

}