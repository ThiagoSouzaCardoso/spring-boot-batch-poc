package br.com.spring.batch.demo.br.com.spring.batch.demo.config.br.com.spring.batch.demo.task;

import br.com.spring.batch.demo.br.com.spring.batch.demo.config.br.com.spring.batch.demo.entity.Person;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

public class TaskOne implements Tasklet {

    RestTemplate restTemplate;

    public TaskOne(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {

        System.out.println("TaskTwo start");

        ResponseEntity<Person> person =  restTemplate.getForEntity("http://www.mocky.io/v2/5cef5681300000e72a3ccf48", Person.class);
        System.out.println(person);

        System.out.println("TaskTwo stop");

        return RepeatStatus.FINISHED;
    }
}
