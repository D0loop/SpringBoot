package com.example.redisconsumer.repository;

import com.example.redisconsumer.model.JobProcess;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author D0Loop
 * @since 2022-03-28 [2022.3월.28]
 */

@Repository
public interface RedisRepository extends CrudRepository<JobProcess, String> {
}
