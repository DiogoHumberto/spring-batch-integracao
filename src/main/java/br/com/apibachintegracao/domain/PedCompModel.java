package br.com.apibachintegracao.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Audited
@Entity
@Table(name="pedcomp", uniqueConstraints = @UniqueConstraint(columnNames = "numpedcomp"))
public class PedCompModel implements Serializable {
	
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
	
	//@NotAudited
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
