package eu.deswaef.cinderpup.roboinsta.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.support.NoOpCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableCaching
@AutoConfigureBefore(value = {WebConfigurer.class})
public class CacheConfiguration {

    private final Logger log = LoggerFactory.getLogger(CacheConfiguration.class);

    public CacheConfiguration() {
    }

    @Bean
    public CacheManager cacheManager() {
        log.debug("No cache");
        return new NoOpCacheManager();
    }
}
