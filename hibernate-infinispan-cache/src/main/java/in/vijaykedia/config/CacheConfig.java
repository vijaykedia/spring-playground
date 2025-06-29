package in.vijaykedia.config;

import org.infinispan.configuration.global.GlobalConfigurationBuilder;
import org.infinispan.spring.starter.embedded.InfinispanGlobalConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CacheConfig {

  @Bean
  public InfinispanGlobalConfigurer globalConfigurer() {
    return () -> GlobalConfigurationBuilder.defaultClusteredBuilder().build();
  }
}
