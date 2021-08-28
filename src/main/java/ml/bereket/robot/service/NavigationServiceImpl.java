package ml.bereket.robot.service;

import lombok.RequiredArgsConstructor;
import ml.bereket.robot.dto.CommandDto;
import ml.bereket.robot.service.command.Command;
import ml.bereket.robot.service.command.CommandFactory;
import ml.bereket.robot.service.command.Location;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class NavigationServiceImpl implements NavigationService {

    protected final Log logger = LogFactory.getLog(this.getClass());

    final private CommandFactory commandFactory;

    @Override
    public List<Command> prepareCommands(List<CommandDto> commandDtos) {
        List<Command> commands = new ArrayList<>();
        for(CommandDto dto : commandDtos){
            Command command = commandFactory.getCommand(dto);
            if(command == null) {
                logger.warn("Could not translate command for " + dto.toString());
                continue;
            }
            commands.add(command);
        }
        return commands;
    }

    @Override
    public Location moveRobot(List<Command> commands, Location initialLocation) {
        Location currentLocation = initialLocation;
        for(Command command : commands){
            currentLocation = command.getNewLocation(currentLocation);
        }
        return currentLocation;
    }
}
