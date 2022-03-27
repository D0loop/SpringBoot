package com.example.redisproducer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.redis.core.RedisHash;

/**
 * @author D0Loop
 * @since 2022-03-28 [2022.3월.28]
 */

@Data
@AllArgsConstructor
@RedisHash("Job")
public class JobProcess {
    private String id;
    private int status;
    private String message;
    private String result;
}
