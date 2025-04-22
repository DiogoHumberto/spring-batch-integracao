package br.com.apibachintegracao.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="empresa", uniqueConstraints = @UniqueConstraint(columnNames = "cnpj"))
@Audited
public class EmpresaModel implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "uuid")
	private UUID uuid;
	
	@Column(name = "cnpj")
	private String cnpj;
	
	@Column(name = "fantasia")
	private String fantasia;
	
	@Column(name = "razsoc")
	private String razsoc;
	
	@Column(name = "telefone")
	private String telefone;
	
	@Column(name = "email")
	private String email;
	
//	@ManyToMany(fetch = FetchType.EAGER)
//	@JoinTable(name = "associacao_forne_parametro",
//	joinColumns = @JoinColumn(name = "uuid_forne"), inverseJoinColumns = @JoinColumn(name = "uuid_parametro"))
//	private Set<ParametroModel> parametros;
	
}