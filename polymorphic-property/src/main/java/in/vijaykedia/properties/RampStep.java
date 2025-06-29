package in.vijaykedia.properties;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.Duration;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RampStep implements Step {

  @JsonProperty("properties")
  private RampProperties properties;

  @Override
  public StepType getType() {
    return StepType.RAMP;
  }

  @Getter
  @Setter
  public static class RampProperties {
    private Duration duration;
    private Integer users;
  }
}
