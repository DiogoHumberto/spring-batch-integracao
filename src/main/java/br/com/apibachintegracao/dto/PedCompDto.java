package br.com.apibachintegracao.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.validation.constraints.NotEmpty;
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
	
	private UUID uuidPedcomp;
	
	@NotNull
	private Integer numpedcomp;
	
	@NotNull
	@JsonFormat(pattern="dd-MM-yyyy HH:mm:ss")
	private Date dtEntrega;
	
	@NotNull
	@JsonFormat(pattern="dd-MM-yyyy HH:mm:ss")
	private Date dtPedido;
	
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
	
	@NotEmpty
	private List<ItemPedCompDto> itens;

}
