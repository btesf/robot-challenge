package ml.bereket.robot.service;

import ml.bereket.robot.dto.CommandDto;
import ml.bereket.robot.service.command.Command;
import ml.bereket.robot.service.command.Location;

import java.util.List;

public interface NavigationService {

    List<Command> prepareCommands(List<CommandDto> commandDtos);
    Location moveRobot(List<Command> commands, Location initialLocation);
}
