package in.vijaykedia.endpoint;

import in.vijaykedia.Application;
import in.vijaykedia.model.CacheRequest;
import java.net.http.HttpClient;
import java.time.Duration;
import org.junit.jupiter.api.Test;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

class CacheEndpointTest {

  private final HttpClient client = HttpClient.newBuilder().build();

  private final RestTemplate restTemplate = new RestTemplateBuilder().build();

  @Test
  void testMultipleInstances() throws Exception {

    Application.main(new String[] {"--server.port=6080"});
    Application.main(new String[] {"--server.port=7080"});

    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);

    // Fill both nodes with different value
    final HttpEntity<CacheRequest> request1 =
        new HttpEntity<>(new CacheRequest("test", "name", "dummy"), headers);

    final HttpEntity<CacheRequest> request2 =
        new HttpEntity<>(new CacheRequest("test", "name", "dummy2"), headers);

    restTemplate.postForObject("http://localhost:6080/cache", request1, Void.class);
    Thread.sleep(Duration.ofSeconds(5));
    restTemplate.postForObject("http://localhost:7080/cache", request2, Void.class);
    Thread.sleep(Duration.ofSeconds(5));

    final HttpEntity<CacheRequest> request3 =
        new HttpEntity<>(new CacheRequest("test", "name", "dummy3"), headers);

    final HttpEntity<CacheRequest> request4 =
        new HttpEntity<>(new CacheRequest("test", "name", "dummy4"), headers);

    restTemplate.postForObject("http://localhost:6080/cache", request3, Void.class);
    Thread.sleep(Duration.ofSeconds(5));
    restTemplate.postForObject("http://localhost:7080/cache", request4, Void.class);
    Thread.sleep(Duration.ofSeconds(5));
  }
}
