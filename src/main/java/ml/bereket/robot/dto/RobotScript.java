package ml.bereket.robot.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RobotScript {
    @JsonProperty("grid")
    Grid grid;
    @JsonProperty("initial_location")
    Location initialLocation;
    @JsonProperty("commands")
    String commands;
}
