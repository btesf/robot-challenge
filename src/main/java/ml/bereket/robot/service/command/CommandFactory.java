package ml.bereket.robot.service.command;

import ml.bereket.robot.dto.CommandDto;
import org.springframework.stereotype.Component;

@Component
public class CommandFactory {

    public Command getCommand(CommandDto commandDto){

        if(commandDto == null) return null;

        switch(commandDto.getType()){
            case EAST:
                return new EastCommand();
            case WEST:
                return new WestCommand();
            case NORTH:
                return new NorthCommand();
            case SOUTH:
                return new SouthCommand();
            case POSITION:
                return new PositionCommand(commandDto.getLocation());
            case FORWARD:
                Integer steps = commandDto.getSteps();
                return new ForwardCommand(steps);
            case WAIT:
                return new WaitCommand();
            case TURNAROUND:
                return new TurnAroundCommand();
            case RIGHT:
                return new RightCommand();
            case LEFT:
                return new LeftCommand();
            default: throw new IllegalArgumentException("Cannot determine command");
        }
    }
}
