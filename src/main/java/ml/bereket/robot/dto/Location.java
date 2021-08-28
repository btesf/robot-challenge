package ml.bereket.robot.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import ml.bereket.robot.service.Direction;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Location {
    @JsonProperty("coordinate")
    Coordinate coordinate;
    @JsonProperty("direction")
    Direction direction;
}