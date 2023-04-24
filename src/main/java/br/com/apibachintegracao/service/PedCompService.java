package br.com.apibachintegracao.service;

import org.springframework.stereotype.Service;

import br.com.apibachintegracao.domain.mapper.PedCompMapper;
import br.com.apibachintegracao.dto.PedCompDto;
import br.com.apibachintegracao.repository.EmpresaModelRepository;
import br.com.apibachintegracao.repository.PedCompModelRepository;
import br.com.apibachintegracao.service.exceptions.BadRequestException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PedCompService {
	
	private final PedCompModelRepository pedCompRepository;
	
	private final EmpresaModelRepository empresaRepository;
	
	public PedCompDto savarNovoPed(PedCompDto pedCompDto) {
				
		if (!empresaRepository.findById(pedCompDto.getEmpresa()).isPresent()) {
			
			throw new BadRequestException("Empresa não existem em nossa base!");
		}
		
		var pedComModel = PedCompMapper.toEntity(pedCompDto);
		
		
		return PedCompMapper.toDto(pedCompRepository.save(pedComModel));

	}
	
	

}
