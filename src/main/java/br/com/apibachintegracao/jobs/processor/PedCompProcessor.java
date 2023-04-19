package br.com.apibachintegracao.jobs.processor;

import org.springframework.batch.item.ItemProcessor;

import br.com.apibachintegracao.domain.PedCompModel;

public class PedCompProcessor implements ItemProcessor <PedCompModel , PedCompModel> {

	@Override
	public PedCompModel process(PedCompModel item) throws Exception {
		
		item.setDescricao("alterado");
		
		// TODO Auto-generated method stub
		return item;
	}

}
