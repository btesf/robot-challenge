package ml.bereket.robot.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ml.bereket.robot.dto.RobotScript;
import ml.bereket.robot.service.CommandParserService;
import ml.bereket.robot.service.NavigationService;
import ml.bereket.robot.dto.Location;
import ml.bereket.robot.service.command.Command;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@RequiredArgsConstructor
@RestController
public class RobotController {

    private final NavigationService navigationService;
    private final CommandParserService commandParserService;

    @PostMapping(produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Location> createSubject(@RequestBody RobotScript robotScript) {

        List<Command> commands = commandParserService.parseCommands(robotScript.getCommands(), robotScript.getGrid());
        Location startingPoint = new Location();
        startingPoint.setCoordinate(robotScript.getInitialCoordinate());
        Location destination = navigationService.moveRobot(startingPoint, commands);
        return ResponseEntity.status(OK).body(
               destination
        );
    }
}
