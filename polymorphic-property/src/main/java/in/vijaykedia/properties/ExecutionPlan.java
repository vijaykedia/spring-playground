package in.vijaykedia.properties;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.util.List;
import java.util.Map;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("execution-plan")
@Getter
public class ExecutionPlan {

  final ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());

  private final String name;

  private final ExecutionPlanType type;

  private final List<Step> steps;

  public ExecutionPlan(
      @NotNull final String name,
      @NotNull final ExecutionPlanType type,
      @NotNull final List<Map<String, Object>> steps) {
    this.name = name;
    this.type = type;
    this.steps = steps.stream().map(map -> objectMapper.convertValue(map, Step.class)).toList();
  }
}
