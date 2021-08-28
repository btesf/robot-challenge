package ml.bereket.robot.service.command;

import ml.bereket.robot.dto.CommandDto;
import org.springframework.stereotype.Component;

@Component
public class CommandFactory {

    public Command getCommand(CommandDto commandDto){

        if(commandDto == null) return null;

        switch(commandDto.getType()){
            case EAST:
                return new East();
            case WEST:
                return new West();
            case NORTH:
                return new North();
            case SOUTH:
                return new South();
            case POSITION:
                return new Position(commandDto.getLocation());
            case FORWARD:
                Integer steps = commandDto.getSteps();
                return new Forward(steps);
            case WAIT:
                return new Wait();
            case TURNAROUND:
                return new TurnAround();
            case RIGHT:
                return new Right();
            case LEFT:
                return new Left();
            default: throw new IllegalArgumentException("Cannot determine command");
        }
    }
}
