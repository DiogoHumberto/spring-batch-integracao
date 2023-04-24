package br.com.apibachintegracao.domain;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="pedcomp")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Audited
public class PedCompModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "uuid_pedcomp")
	private UUID uuidPedcomp;
	
	@Column(name = "numpedcomp")
	private Integer numpedcomp;
		
	@Column(name = "dtpedido")
	private Date dtPedido;
	
	@Column(name = "dtinclusao")
	private Date dtInclusao;
	
	@Column(name = "dtalteracao")
	private Date dtAlteracao;
	
	@Column(name = "dtcancelamento")
	private Date dtCancelamento;
	
	@Column(name = "dtentrega")
	private Date dtEntrega;
	
	@Column(name = "vltotal")
	private BigDecimal vlTotal;
	
	@Column(name = "vldesc")
	private BigDecimal vlDesc;
	
	@Column(name = "vljuros")
	private BigDecimal vlJuros;
	
	@NotAudited
	@Column(name = "descricao", columnDefinition = "TEXT")
	private String descricao;
	
	@Column(name = "status")
	private Integer status;
	
	
	@Column(name = "uuidusuario")
	private UUID uuidUsuario;
	
	@JoinColumn(name = "uuid_empresa")
	@ManyToOne
	private EmpresaModel empresa;
	
	@JoinColumn(name = "uuid_empresa_forne")
	@ManyToOne
	private EmpresaModel empresaForne;
	
	@Transient
	private List<ItemPedCompModel> itens;

}
