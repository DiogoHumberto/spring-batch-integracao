package br.com.apibachintegracao.jobs.writer;

import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.apibachintegracao.domain.PedCompModel;
import br.com.apibachintegracao.repository.PedCompModelRepository;

public class PedCompItemWriter implements ItemWriter<PedCompModel>{

	@Autowired
	private PedCompModelRepository pedCompModelRepository;
	
	@Override
	public void write(Chunk<? extends PedCompModel> chunk) throws Exception {
		
		pedCompModelRepository.saveAll(chunk.getItems());		
		
	}

}
