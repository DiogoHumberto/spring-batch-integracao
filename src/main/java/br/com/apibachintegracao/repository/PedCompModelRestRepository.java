package br.com.apibachintegracao.repository;

import br.com.apibachintegracao.domain.PedCompModel;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.UUID;

@RepositoryRestResource(collectionResourceRel = "produto", path = "produto")
public interface  PedCompModelRestRepository extends PagingAndSortingRepository<PedCompModel, UUID> {
	
	List<PedCompModel> findByNumpedcomp(@Param("numpedcomp") String numpedcomp);
 
}
