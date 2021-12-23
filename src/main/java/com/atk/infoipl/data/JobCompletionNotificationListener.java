package com.atk.infoipl.data;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;

import com.atk.infoipl.model.Team;

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

    private final EntityManager em;

    @Autowired
    public JobCompletionNotificationListener(EntityManager em) {
        this.em = em;
    }

    @Override
    @Transactional
    public void afterJob(JobExecution jobExecution){

        if(jobExecution.getStatus() == BatchStatus.COMPLETED){
            log.info("Job Finished");

            Map<String, Team> teamData = new HashMap<>();
            em.createQuery("SELECT * FROM TEAM", Object[].class)
                .getResultList()
                .stream()
                .map( e-> new Team((long) e[0], (String) e[1], (String) e[2], (String) e[3], (String) e[4], (String) e[4]))
                .forEach(team -> teamData.put(team.getFullName(), team));

            
                teamData.values().forEach(team -> System.out.println(team));

        }

    }
    
}
