package com.batch;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

public class Sample implements Tasklet{

	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
		
		System.out.println("TRy this si the etirw esrever ");
		
		int [] arr = {12, 3,5, 6 };
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
			
		return RepeatStatus.FINISHED;
	}
	

}
