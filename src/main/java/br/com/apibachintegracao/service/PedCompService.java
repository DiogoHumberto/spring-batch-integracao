package br.com.apibachintegracao.service;

import org.springframework.stereotype.Service;

import br.com.apibachintegracao.dto.PedCompDto;
import br.com.apibachintegracao.repository.PedCompModelRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PedCompService {
	
	private final PedCompModelRepository pedCompRepository;
	
	public PedCompDto savarNovoPed(PedCompDto pedCompDto) {
		//ELABORAR
		return null;
	}
	
	

}
