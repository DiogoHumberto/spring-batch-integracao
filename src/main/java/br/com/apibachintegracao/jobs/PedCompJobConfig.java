package br.com.apibachintegracao.jobs;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.database.builder.JpaPagingItemReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import br.com.apibachintegracao.jobs.listener.PedCompJobExecutionListener;
import br.com.apibachintegracao.jobs.processor.PedCompProcessor;
import br.com.apibachintegracao.jobs.writer.PedCompItemWriter;
import br.com.apibachintegracao.models.PedCompModel;
import jakarta.persistence.EntityManagerFactory;


@Configuration
public class PedCompJobConfig {
	
	@Autowired
	private EntityManagerFactory entityManagerFactory;
	
	@Autowired
	@Qualifier("transactionManagerApp")
	private PlatformTransactionManager transactionManager;
	
	

		
    @Bean
    public Job myJob(JobRepository jobRepository, Step step) {
        return new JobBuilder("myJob", jobRepository)
                .start(step)
                .incrementer(new RunIdIncrementer())
                .listener(new PedCompJobExecutionListener())
                .build();
        
        
    }
    
    @Bean
    Step step(JobRepository jobRepository, ItemReader<PedCompModel> reader, PedCompItemWriter writer) {
         	
    	return new StepBuilder("step1", jobRepository)
          .<PedCompModel, PedCompModel>chunk(200, transactionManager)
          .reader(reader)
          .processor(pedCompProcessor())
          .writer(writer)
          .faultTolerant()
          .retry(Exception.class)
          .retryLimit(3)
          .build();
    }
   
    @Bean
    ItemReader<PedCompModel> reader() {
        return new JpaPagingItemReaderBuilder<PedCompModel>()
                .name("PedCompModel")
                .entityManagerFactory(entityManagerFactory)
                .queryString("select s from PedCompModel s")// Personalizar consulta PSQL
                .build();
    }
	
	@Bean
	PedCompProcessor pedCompProcessor(){
		return new PedCompProcessor();
	}
	
	@Bean
	PedCompItemWriter writer() {
		return new PedCompItemWriter();
	}

        

}
