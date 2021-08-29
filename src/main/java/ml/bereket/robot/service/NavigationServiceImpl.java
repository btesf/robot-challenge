package ml.bereket.robot.service;

import lombok.RequiredArgsConstructor;
import ml.bereket.robot.dto.Location;
import ml.bereket.robot.service.command.Command;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class NavigationServiceImpl implements NavigationService {

    @Override
    public Location moveRobot(Location initialLocation, List<Command> commands) {
        Location currentLocation = initialLocation;
        for(Command command : commands){
            currentLocation = command.getNewLocation(currentLocation);
        }
        return currentLocation;
    }
}
