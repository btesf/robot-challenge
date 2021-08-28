package ml.bereket.robot.service;

import ml.bereket.robot.service.command.Command;
import ml.bereket.robot.dto.Location;

import java.util.List;

public interface NavigationService {

    Location moveRobot(Location initialLocation, List<Command> commands);
}
