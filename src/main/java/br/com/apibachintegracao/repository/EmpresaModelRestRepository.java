package br.com.apibachintegracao.repository;

import br.com.apibachintegracao.domain.EmpresaModel;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.UUID;

@RepositoryRestResource(collectionResourceRel = "empresa", path = "empresa")
public interface EmpresaModelRestRepository extends PagingAndSortingRepository<EmpresaModel, UUID> {
	
	List<EmpresaModel> findByCnpj(@Param("cnpj") String cnpj);
 
}
