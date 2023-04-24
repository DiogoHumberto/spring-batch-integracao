package br.com.apibachintegracao.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemPedCompDto {

	@NotBlank
	private String codprod;
	
	@NotNull
	private Integer numpedcomp;
	
	private String descricao;
	
	@NotBlank
	private String unidadeMedida;
	
	@NotNull
	private BigDecimal qtdSolicitada;
		
	@NotNull
	private BigDecimal precounit;
		
	private BigDecimal vldesc;
		
	private Integer status;
	
}
