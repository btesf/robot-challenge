package ml.bereket.robot.dto;

import lombok.Data;
import ml.bereket.robot.service.command.Location;
import ml.bereket.robot.service.command.CommandType;

@Data
public class CommandDto {
    CommandType type;
    Location location;
    Integer steps;
}
