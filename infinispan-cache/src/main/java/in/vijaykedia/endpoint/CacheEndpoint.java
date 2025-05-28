package in.vijaykedia.endpoint;

import in.vijaykedia.config.CacheListener;
import in.vijaykedia.model.CacheRequest;
import org.infinispan.Cache;
import org.infinispan.configuration.cache.CacheMode;
import org.infinispan.configuration.cache.ConfigurationBuilder;
import org.infinispan.manager.EmbeddedCacheManager;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CacheEndpoint {

  private static final Logger logger = LoggerFactory.getLogger(CacheEndpoint.class);

  private final EmbeddedCacheManager cacheManager;

  private final CacheListener listener;

  @Autowired
  public CacheEndpoint(@NotNull final EmbeddedCacheManager cacheManager) {
    this.cacheManager = cacheManager;
    this.listener = new CacheListener();
  }

  @PostMapping("/cache")
  public void setKey(@NotNull @RequestBody final CacheRequest request) {
    if (cacheManager.cacheExists(request.cacheName())) {
      Cache<String, String> cache = cacheManager.getCache(request.cacheName());
      if (cache.containsKey(request.key())) {
        logger.info(
            "Cache {} already contains key {} with value : {}",
            request.cacheName(),
            request.key(),
            cache.get(request.key()));
      } else {
        logger.info("Cache {} does not contains key {}", request.cacheName(), request.key());
      }
      cacheManager.getCache(request.cacheName()).put(request.key(), request.value());
      logger.info(
          "Adding key {} with value {} in the cache {}",
          request.key(),
          request.value(),
          request.cacheName());
    } else {
      logger.info("Cache with name {} not existed", request.cacheName());
      cacheManager.defineConfiguration(
          request.cacheName(),
          new ConfigurationBuilder().clustering().cacheMode(CacheMode.INVALIDATION_SYNC).build());
      Cache<String, String> cache = cacheManager.getCache(request.cacheName());
      cache.addListener(this.listener);
      cache.put(request.key(), request.value());
      logger.info(
          "Updated cache {} with key {} and value : {}",
          request.cacheName(),
          request.key(),
          request.value());
    }
  }
}
