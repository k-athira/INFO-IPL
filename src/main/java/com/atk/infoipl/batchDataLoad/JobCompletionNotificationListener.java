package com.atk.infoipl.batchDataLoad;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component
public class JobCompletionNotificationListener extends JobExecutionListenerSupport {

    private static final Logger log = LoggerFactory.getLogger(JobCompletionNotificationListener.class);

    @Autowired
    public JobCompletionNotificationListener() {
    }

    @Override
    @Transactional
    public void afterJob(JobExecution jobExecution){

        if(jobExecution.getStatus() == BatchStatus.COMPLETED){
            log.info("Job Finished");

            /*Map<String, Team> teamData = new HashMap<>();
            em.createQuery("SELECT EXTERNAL_ID, CODE_NAME, FULL_NAME, STATUS, INTRO_YEAR, LAST_PLAYED_YEAR FROM TEAM", Object[].class)
                .getResultList()
                .stream()
                .map( e-> new Team((String) e[0], (String) e[1], (String) e[2], (String) e[3], (String) e[4], (String) e[4]))
                .forEach(team -> teamData.put(team.getFullName(), team));

            
                teamData.values().forEach(team -> System.out.println(team));*/

        }

    }
    
}
