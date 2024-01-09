package org.simple.sm.config;

import org.simple.sm.component.snowflake.IdWorker;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 雪花算法初始化配置
 */
@Configuration
public class IdWorkerConfig {

    @Value("${sys.id-worker.worker-id:0}")
    private int workerId;
    @Value("${sys.id-worker.data-center-id:0}")
    private int dataCenterId;

    @Bean
    public IdWorker getIdWorker() {
        return new IdWorker(workerId, dataCenterId);
    }
}
