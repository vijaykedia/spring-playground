package in.vijaykedia;

import org.jetbrains.annotations.NotNull;
import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class Application {

  public static void main(@NotNull final String[] args) {
    new SpringApplicationBuilder(Application.class).bannerMode(Banner.Mode.OFF).run(args);
  }
}
