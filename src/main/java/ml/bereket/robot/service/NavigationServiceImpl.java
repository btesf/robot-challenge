package ml.bereket.robot.service;

import lombok.RequiredArgsConstructor;
import ml.bereket.robot.dto.CommandDto;
import ml.bereket.robot.service.command.Command;
import ml.bereket.robot.service.command.Location;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class NavigationServiceImpl implements NavigationService {

    @Override
    public List<Command> prepareCommands(List<CommandDto> commandDtos) {
        return null;
    }

    @Override
    public Location moveRobot(List<Command> commands) {
        return null;
    }

    public Command translateCommand(CommandDto commandDto){
        return null;
    }
}
