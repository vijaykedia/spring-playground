package in.vijaykedia.properties;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
  @JsonSubTypes.Type(value = NothingStep.class, name = "nothing"),
  @JsonSubTypes.Type(value = RampStep.class, name = "ramp")
})
public interface Step {

  StepType getType();
}
