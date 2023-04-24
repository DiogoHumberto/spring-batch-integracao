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

		validaPed(pedCompDto);

		var pedComModel = PedCompMapper.toEntity(pedCompDto);

		return PedCompMapper.toDto(pedCompRepository.save(pedComModel));

	}
	
	public PedCompDto alterarPed(PedCompDto pedCompDto) {
		
		var pedCompModel = pedCompRepository.findByNumpedcomp(pedCompDto.getNumpedcomp());
		
		if (!pedCompModel.isPresent()) {

			throw new BadRequestException("Pedido " + pedCompDto.getNumpedcomp() + "não encontrado ou inexistente, Utilize POST  URI /api/pedido!");
		}
		
		

		var pedComModel = PedCompMapper.toEntity(pedCompDto);

		return PedCompMapper.toDto(pedCompRepository.save(pedComModel));

	}

	private void validaPed(PedCompDto pedCompDto) {

		if (!empresaRepository.findById(pedCompDto.getEmpresa()).isPresent()) {

			throw new BadRequestException("Empresa " + pedCompDto.getEmpresa() + "não existem em nossa base!");
		}
		
		if (pedCompRepository.findByNumpedcomp(pedCompDto.getNumpedcomp()).isPresent()) {

			throw new BadRequestException("Pedido já existente! Utilize PUT  URI /api/pedido ");
		}		
		
	}

}
