package ml.bereket.robot.service.command;

import lombok.Data;
import ml.bereket.robot.service.Direction;

@Data
public class Location {
    Integer x;
    Integer y;
    Direction direction;
}
