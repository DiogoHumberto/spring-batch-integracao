package br.com.apibachintegracao.job.listener;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PedCompJobExecutionListener implements JobExecutionListener {

	//PODE SER ADTAPTADO UM DISPARO EMAIL OU ALERTA DE INICIO E FIM DE INTEGRAÇÃO
    public void beforeJob(JobExecution jobExecution) {
        log.info("------  INICIANDO BATCH INTEGRAÇÃO DE PEDIDOS  ------");
    }

    public void afterJob(JobExecution jobExecution) {
        if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
            log.info("BATCH JOB INTEGRAÇÃO DE PEDIDOS COMPLETO COM SUCESSO!");
        }else if(jobExecution.getStatus() == BatchStatus.FAILED){        	
            log.info("ERROR ----->>> BATCH JOB INTEGRAÇÃO DE PEDIDOS COM FALHA! JOB : {}" , jobExecution.toString());
        }
    }
	
}
