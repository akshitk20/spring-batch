package com.batch.example.BootBatchExample.config;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;

@Component
public class JobCompletionNotificationImpl implements JobExecutionListener {

    private Logger log = LoggerFactory.getLogger(JobCompletionNotificationImpl.class);
    @Override
    public void beforeJob(JobExecution jobExecution) {
        log.info("Job Started");
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        if (jobExecution.getStatus().equals(BatchStatus.COMPLETED)) {
            log.info("Job Completed");
        }
    }
}
