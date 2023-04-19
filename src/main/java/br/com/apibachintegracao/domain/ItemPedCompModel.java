package br.com.apibachintegracao.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;

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
@Audited
public class ItemPedCompModel  implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "uuid_itempedcomp")
	private UUID uuidItemPedComp;

	@Column(name = "codprod")
	private String codprod;
	
	@Column(name = "numpedcomp")
	private Integer numpedcomp;

	@Column(name = "uiid_empresa")
	private UUID empresa;	
	
	@NotAudited
	@Column(name = "descricao", columnDefinition = "TEXT")
	private String descricao;
	
	@NotAudited
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
