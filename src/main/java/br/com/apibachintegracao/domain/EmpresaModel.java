package br.com.apibachintegracao.domain;

import java.io.Serializable;
import java.util.UUID;

import org.hibernate.envers.Audited;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="empresa", uniqueConstraints = @UniqueConstraint(columnNames = "cnpj"))
@Audited
public class EmpresaModel implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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