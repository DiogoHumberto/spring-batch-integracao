package br.com.apibachintegracao.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.database.JpaPagingItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import br.com.apibachintegracao.domain.PedCompModel;
import br.com.apibachintegracao.job.listener.PedCompJobExecutionListener;
import br.com.apibachintegracao.job.processor.PedCompProcessor;
import br.com.apibachintegracao.job.writer.PedCompItemWriter;
import jakarta.persistence.EntityManagerFactory;

@Configuration
public class PedCompJobConfig {

	
	@Autowired
	private EntityManagerFactory entityManagerFactory;
	
	@Autowired
	private PlatformTransactionManager transactionManager;
	
		
    @Bean
    public Job integraPedidoNovoJob(JobRepository jobRepository, Step step) {
        return new JobBuilder("integraPedidoNovoJob", jobRepository)
                .start(step)
                //.incrementer(new RunIdIncrementer())
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
   
//    @Bean
//    ItemReader<PedCompModel> reader() {
//        return new JpaPagingItemReaderBuilder<PedCompModel>()
//                .name("PedCompModel")
//                .entityManagerFactory(entityManagerFactory)
//                .queryString("select s from PedCompModel s")// Personalizar consulta PSQL
//                .build();
//    }
    
    @Bean
    public JpaPagingItemReader<PedCompModel> reader() {
        JpaPagingItemReader<PedCompModel> reader = new JpaPagingItemReader<>();
        reader.setEntityManagerFactory(entityManagerFactory);
        reader.setQueryString("SELECT p FROM PedCompModel p");
        reader.setPageSize(10);
        return reader;
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
