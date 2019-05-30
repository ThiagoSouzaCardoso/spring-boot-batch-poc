package br.com.spring.batch.demo.br.com.spring.batch.demo.config;

import br.com.spring.batch.demo.br.com.spring.batch.demo.config.br.com.spring.batch.demo.task.TaskOne;
import br.com.spring.batch.demo.br.com.spring.batch.demo.config.br.com.spring.batch.demo.task.TaskTwo;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private  RestTemplate restTemplate;

    @Bean
    public Step steapTwo(){
        return stepBuilderFactory.get("stepTwo").tasklet(new TaskTwo()).build();
    }


    @Bean
    public Step steapOne(){
        return stepBuilderFactory.get("stepOne").tasklet(new TaskOne(restTemplate)).build();
    }


    @Bean
    public Job demoJob(){
        return jobBuilderFactory.get("demojob").incrementer(new RunIdIncrementer()).start(steapOne()).next(steapTwo()).build();
    }

}
