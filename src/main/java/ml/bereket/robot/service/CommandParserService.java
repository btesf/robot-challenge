package ml.bereket.robot.service;

import ml.bereket.robot.dto.Grid;
import ml.bereket.robot.service.command.Command;

import java.util.List;

public interface CommandParserService {

    Command parseCommand(String string);
    List<Command> parseCommands(String commands, Grid grid);
}
