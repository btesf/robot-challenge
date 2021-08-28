package ml.bereket.robot.service;

import lombok.RequiredArgsConstructor;
import ml.bereket.robot.service.command.Command;
import ml.bereket.robot.dto.Location;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class NavigationServiceImpl implements NavigationService {

    protected final Log logger = LogFactory.getLog(this.getClass());

    @Override
    public Location moveRobot(Location initialLocation, List<Command> commands) {
        Location currentLocation = initialLocation;
        for(Command command : commands){
            currentLocation = command.getNewLocation(currentLocation);
        }
        return currentLocation;
    }
}
