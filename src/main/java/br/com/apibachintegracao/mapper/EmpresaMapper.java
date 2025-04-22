package br.com.apibachintegracao.mapper;

import br.com.apibachintegracao.domain.EmpresaModel;
import br.com.apibachintegracao.domain.PedCompModel;
import br.com.apibachintegracao.dto.EmpresaDto;
import br.com.apibachintegracao.dto.PedCompDto;

public class EmpresaMapper {
	
	public static EmpresaModel toEntity(EmpresaDto dto) {
		
		return EmpresaModel.builder()
					.cnpj(dto.getCnpj())
					.fantasia(dto.getFantasia())
					.razsoc(dto.getRazsoc())
					.telefone(dto.getTelefone())
					.email(dto.getEmail())
					.build();					
		
	}
	
	 public static EmpresaDto toDto(EmpresaModel model) {
		 
		 return EmpresaDto.builder()
				 .uuid(model.getUuid())
					.cnpj(model.getCnpj())
					.fantasia(model.getFantasia())
					.razsoc(model.getRazsoc())
					.telefone(model.getTelefone())
					.email(model.getEmail())
					.build();	
				 
	 }	

}
