package ml.bereket.robot.dto;

import lombok.Data;
import ml.bereket.robot.service.command.Location;
import ml.bereket.robot.service.command.Type;

@Data
public class CommandDto {
    Type type;
    Location location;
    Integer steps;
}
