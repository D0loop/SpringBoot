package com.example.redisconsumer.service;

import com.example.redisconsumer.model.JobProcess;
import com.example.redisconsumer.model.JobRequest;
import com.example.redisconsumer.repository.RedisRepository;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @author D0Loop
 * @since 2022-03-27 [2022.3월.27]
 */

@Service
@RequiredArgsConstructor
@RabbitListener(queues = "boot.amqp.worker-queue")
public class ConsumerService {

    private static final Logger logger = LoggerFactory.getLogger(ConsumerService.class);

    private final RedisRepository redisRepository;
    private final Gson gson;

    @RabbitHandler
    public void receive(String message) throws InterruptedException {
        logger.info("Received: {}", message);
        String jobId;
        try {
            JobRequest newJob = gson.fromJson(message, JobRequest.class);
            jobId = newJob.getJobId();

            JobProcess jobProcess = new JobProcess();
            jobProcess.setId(newJob.getJobId());
            jobProcess.setMessage("Job being processed");
            jobProcess.setStatus(1);
            jobProcess.setResult("");

            redisRepository.save(jobProcess);
        } catch (Exception e) {
            throw new AmqpRejectAndDontRequeueException(e);
        }

        Thread.sleep(5000);

        JobProcess jobProcess = new JobProcess();
        jobProcess.setId(jobId);
        jobProcess.setMessage("Finished");
        jobProcess.setStatus(0);
        jobProcess.setResult("Success");
        redisRepository.save(jobProcess);
    }

}
