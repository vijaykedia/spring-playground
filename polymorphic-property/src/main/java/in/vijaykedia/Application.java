package in.vijaykedia;

import in.vijaykedia.properties.ExecutionPlan;
import org.jetbrains.annotations.NotNull;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableConfigurationProperties(ExecutionPlan.class)
public class Application {

  public static void main(@NotNull final String[] args) {
    final ConfigurableApplicationContext applicationContext =
        SpringApplication.run(Application.class);

    final ExecutionPlan executionPlan = applicationContext.getBean(ExecutionPlan.class);
    System.out.println(executionPlan);
  }
}
