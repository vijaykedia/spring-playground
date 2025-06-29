package in.vijaykedia.properties;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.Duration;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NothingStep implements Step {

  @JsonProperty("properties")
  private NothingProperties properties;

  @Override
  public StepType getType() {
    return StepType.NOTHING;
  }

  @Getter
  @Setter
  public static class NothingProperties {
    private Duration duration;
  }
}
