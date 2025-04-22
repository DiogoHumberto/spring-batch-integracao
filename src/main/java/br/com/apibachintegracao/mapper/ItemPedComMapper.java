package br.com.apibachintegracao.mapper;

import java.util.List;
import java.util.stream.Collectors;

import br.com.apibachintegracao.domain.ItemPedCompModel;
import br.com.apibachintegracao.dto.ItemPedCompDto;

public class ItemPedComMapper {

	public static ItemPedCompModel toEntity(ItemPedCompDto dto) {

		return ItemPedCompModel.builder().codprod(dto.getCodprod()).numpedcomp(dto.getNumpedcomp())
				.descricao(dto.getDescricao()).unidadeMedida(dto.getUnidadeMedida())
				.qtdSolicitada(dto.getQtdSolicitada()).precounit(dto.getPrecounit()).vldesc(dto.getVldesc())
				.status(dto.getStatus()).build();

	}

	public static ItemPedCompDto toDto(ItemPedCompModel model) {

		return ItemPedCompDto.builder().codprod(model.getCodprod()).numpedcomp(model.getNumpedcomp())
				.descricao(model.getDescricao()).unidadeMedida(model.getUnidadeMedida())
				.qtdSolicitada(model.getQtdSolicitada()).precounit(model.getPrecounit()).vldesc(model.getVldesc())
				.status(model.getStatus()).build();
	}

	public static List<ItemPedCompDto> toItemPedCompDto(List<ItemPedCompModel> itensDto) {

		return itensDto.stream().map(ItemPedComMapper::toDto).collect(Collectors.toList());
	}

	public static List<ItemPedCompModel> toItemPedCompModel(List<ItemPedCompDto> itensDto) {

		return itensDto.stream().map(ItemPedComMapper::toEntity).collect(Collectors.toList());
	}

}
