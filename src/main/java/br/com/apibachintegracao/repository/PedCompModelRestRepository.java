package br.com.apibachintegracao.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.com.apibachintegracao.domain.PedCompModel;

@RepositoryRestResource(collectionResourceRel = "listPedComp", path = "listPedComp")
public interface  PedCompModelRestRepository extends PagingAndSortingRepository<PedCompModel, UUID> {
	
	List<PedCompModel> findByNumpedcomp(@Param("numpedcomp") String numpedcomp);
 
}
