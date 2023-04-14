package br.com.apibachintegracao.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="item_pedcomp")
@Getter
@Setter
public class ItemPedCompModel  implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "uuid_itempedcomp")
	private UUID uuidItemPedComp;
	
	@Column(name = "empresa")
	private UUID empresa;
	
	@Column(name = "numpedcomp")
	private Integer numpedcomp;
			
	@Column(name = "codprod")
	private String codprod;
	
	@Column(name = "descricao", columnDefinition = "TEXT")
	private String descricao;

	@Column(name = "unidade_medida")
	private String unidadeMedida;
	
	@Column(name = "qtd_solicitada")
	private BigDecimal qtdSolicitada;
		
	@Column(name = "precounit")
	private BigDecimal precounit;
	
	@Column(name = "vldesc")
	private BigDecimal vldesc;
	
	@Column(name = "status")
	private Integer status;
	
	
}
