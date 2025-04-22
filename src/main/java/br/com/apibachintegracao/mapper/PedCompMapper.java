package br.com.apibachintegracao.mapper;

import br.com.apibachintegracao.domain.PedCompModel;
import br.com.apibachintegracao.dto.PedCompDto;

public class PedCompMapper {
	
	public static PedCompModel toEntity(PedCompDto dto) {
		
		return PedCompModel.builder()
					.uuidPedcomp(dto.getUuidPedcomp())
					.numpedcomp(dto.getNumpedcomp())
					.dtPedido(dto.getDtPedido())
					.dtEntrega(dto.getDtEntrega())
					.vlTotal(dto.getVlTotal())
					.vlDesc(dto.getVlDesc())
					.vlJuros(dto.getVlJuros())
					.descricao(dto.getDescricao())
					.status(dto.getStatus())
					.itens(ItemPedComMapper.toItemPedCompModel(dto.getItens()))
					.build();					
		
	}
	
	 public static PedCompDto toDto(PedCompModel model) {
		 
		 return PedCompDto.builder()
				 .uuidPedcomp(model.getUuidPedcomp())
					.numpedcomp(model.getNumpedcomp())
					.dtPedido(model.getDtPedido())
					.dtEntrega(model.getDtEntrega())
					.vlTotal(model.getVlTotal())
					.vlDesc(model.getVlDesc())
					.vlJuros(model.getVlJuros())
					.descricao(model.getDescricao())
					.status(model.getStatus())
					.itens(ItemPedComMapper.toItemPedCompDto(model.getItens()))
					.build();	
				 
	 }	

}
