package br.com.apibachintegracao.dto;

import java.math.BigDecimal;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
public class PedCompDto {
	
	@NotNull
	private Integer numpedcomp;
	
	@NotNull
	private String dtEntrega;
	
	@NotNull
	private String dtPedido;
	
	@NotNull
	private BigDecimal vlTotal;
	
	private BigDecimal vlDesc;
	
	private BigDecimal vlJuros;
	
	private String descricao;
	
	@NotNull
	private Integer status;
		
	@NotNull
	private UUID empresa;
	
	@NotNull
	private String cnpjFornecedor;
	
	
	//private List<ItemPedCompDto> itens;

}
