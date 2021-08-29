package ml.bereket.robot.service;

import lombok.RequiredArgsConstructor;
import ml.bereket.robot.dto.Coordinate;
import ml.bereket.robot.dto.Grid;
import ml.bereket.robot.dto.Location;
import ml.bereket.robot.service.command.*;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommandParserServiceImpl implements CommandParserService {

    private Grid grid = new Grid(5, 5); //default size

    @Override
    public Command parseCommand(String line) {

        if(!StringUtils.hasText(line) || !StringUtils.hasText(line.trim())) return null;
        line = line.trim().toUpperCase();
        String[] parts = line.split("\\s+");

        if(parts[0].equals("POSITION")){
            return parsePositionCommand(parts);
        }

        if(parts[0].equals("FORWARD")){
            return parseForwardCommand(parts, grid.getColumns(), grid.getRows());
        }

        if(parts[0].equals("WAIT")){
            return parseWaitCommand(parts);
        }

        if(parts[0].equals("TURNAROUND")){
            return parseTurnAroundCommand(parts);
        }

        if(parts[0].equals("RIGHT")){
            return parseRightCommand(parts);
        }

        if(parts[0].equals("LEFT")){
            return parseLeftCommand(parts);
        }

        if(parts[0].equals("EAST")){
            return parseEastCommand(parts);
        }

        if(parts[0].equals("WEST")){
            return parseWestCommand(parts);
        }

        if(parts[0].equals("NORTH")){
            return parseNorthCommand(parts);
        }

        if(parts[0].equals("SOUTH")){
            return parseSouthCommand(parts);
        }

        throw new RuntimeException("Cannot determine command: " + parts[0]);
    }

    private Command parsePositionCommand(String[] parts) {

        if(parts.length != 4) {
            throw new RuntimeException("POSITION command is not properly formed. Expected format: POSITION <X> <Y> <DIRECTION>");
        }
        Location location = new Location();

        try{
            int x = Integer.parseInt(parts[1]);
            int y = Integer.parseInt(parts[2]);
            Coordinate coordinate = new Coordinate(x, y);
            location.setCoordinate(coordinate);
        } catch(NumberFormatException e){
            throw new RuntimeException("Invalid coordinate number format for POSITION command.");
        }

        try{
            Direction direction = Direction.valueOf(parts[3]);
            location.setDirection(direction);
        } catch (Exception e){
            throw new RuntimeException(String.format("Invalid direction name '%s', for POSITION command.", parts[3]));
        }

        return new PositionCommand(location);
    }

    private Command parseForwardCommand(String[] parts, int gridColumns, int gridRows) {

        if(parts.length != 2) {
            throw new RuntimeException("FORWARD command is not properly formed. Expected format: FORWARD <STEPS>");
        }

        int steps;
        try{
            steps = Integer.parseInt(parts[1]);
        } catch(NumberFormatException e){
            throw new RuntimeException("Invalid no. of steps for FORWARD command.");
        }

        return new ForwardCommand(steps, gridColumns, gridRows);
    }

    private Command parseWaitCommand(String[] parts) {
        return new WaitCommand();
    }

    private Command parseTurnAroundCommand(String[] parts) {
        return new TurnAroundCommand();
    }

    private Command parseLeftCommand(String[] parts) {
        return new LeftCommand();
    }

    private Command parseRightCommand(String[] parts) {
        return new RightCommand();
    }

    private Command parseEastCommand(String[] parts) {
        return new EastCommand();
    }

    private Command parseWestCommand(String[] parts) {
        return new WestCommand();
    }

    private Command parseSouthCommand(String[] parts) {
        return new SouthCommand();
    }

    private Command parseNorthCommand(String[] parts) {
        return new NorthCommand();
    }

    @Override
    public List<Command> parseCommands(String script, Grid grid) {

        if(grid != null) this.grid = grid;
        if(!StringUtils.hasText(script) || !StringUtils.hasText(script.trim())){
            return new ArrayList<>();
        }
        //script can be separated by either \n or \r\n
        String[] lines = script.split("(\n|\r\n)");
        List<Command> commands = new ArrayList<>();
        for(int i = 0; i < lines.length; i++){
            commands.add(parseCommand(lines[i]));
        }
        return commands;
    }
}
