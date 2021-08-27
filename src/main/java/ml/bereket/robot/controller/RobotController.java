package ml.bereket.robot.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ml.bereket.robot.service.NavigationService;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class RobotController {

    private final NavigationService navigationService;
}
