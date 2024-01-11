package org.simple.sm.cache;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CaffeineCache {

    @Bean
    void createCache(){
        // 创建缓存
        Cache<String, String> cache = Caffeine.newBuilder()
                // 缓存的最大条目数
                .maximumSize(10000)
                .build();

        // 向缓存中放入数据
        cache.put("key1", "value1");
        cache.put("key2", "value2");

        // 从缓存中获取数据
        String value1 = cache.getIfPresent("key1");
        String value2 = cache.getIfPresent("key2");
    }

}
