package br.com.apibachintegracao.domain;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="integra_ped_comp")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class IntegraPedCompModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "uuid")
	private UUID uuid;
	
	@JoinColumn(name = "uuid_ped_comp")
	@ManyToOne
	private PedCompModel pedComp;
	
	@Column(name = "numpedcomp")
	private Integer numpedcomp;
	
	@Column(name = "http_status")
	private Integer httpStatus;
	
	@Column(name = "json_request", columnDefinition = "TEXT")
	private String jsonRequest;
	
	@Column(name = "json_response", columnDefinition = "TEXT")
	private String jsonResponse;	
	

}
