package br.com.spring.batch.demo.br.com.spring.batch.demo.config.br.com.spring.batch.demo.task;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

public class TaskTwo  implements Tasklet {


    @Override
    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {

        System.out.println("TaskTwo start");

        int count = 0;

        while(count < 100){

            count++;
        }
        System.out.println("TaskTwo stop");


        return RepeatStatus.FINISHED;
    }
}
