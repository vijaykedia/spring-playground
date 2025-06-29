package in.vijaykedia.properties;

import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.Arrays;
import org.jetbrains.annotations.NotNull;

public enum StepType {
  NOTHING,
  RAMP;

  @JsonCreator
  public static StepType forValue(@NotNull final String value) {
    return Arrays.stream(StepType.values())
        .filter(v -> v.name().equalsIgnoreCase(value))
        .findFirst()
        .orElseThrow();
  }
}
