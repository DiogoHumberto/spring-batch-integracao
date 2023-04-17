package br.com.apibachintegracao.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.com.apibachintegracao.models.PedCompModel;

@RepositoryRestResource(collectionResourceRel = "listPedComp", path = "listPedComp")
public interface  PedCompModelRepository extends PagingAndSortingRepository<PedCompModel, UUID> {
	
	List<PedCompModel> findByNumpedcomp(@Param("numpedcomp") String numpedcomp);
 
}
