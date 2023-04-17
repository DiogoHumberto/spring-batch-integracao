package br.com.apibachintegracao.jobs.processor;

import org.springframework.batch.item.ItemProcessor;

import br.com.apibachintegracao.models.PedCompModel;

public class PedCompProcessor implements ItemProcessor <PedCompModel , PedCompModel> {

	@Override
	public PedCompModel process(PedCompModel item) throws Exception {
		
		// EXECUTA CHAMADA DE INTEGRAÇÃO
		
		// TODO Auto-generated method stub
		return null;
	}

}
