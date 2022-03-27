package com.example.redisproducer.service;

import com.example.redisproducer.model.JobProcess;
import com.example.redisproducer.repository.RedisRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

/**
 * @author D0Loop
 * @since 2022-03-28 [2022.3월.28]
 */

@Service
@RequiredArgsConstructor
public class RedisService {
    private final RedisRepository redisRepository;

    public JobProcess retrieveJob(String jobId) {
        Optional<JobProcess> jobProcess = this.redisRepository.findById(jobId);

        return jobProcess.orElseThrow(() -> {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        });
    }
}
