package br.com.apibachintegracao.repository;

import br.com.apibachintegracao.domain.EmpresaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;

import java.util.Optional;
import java.util.UUID;

public interface EmpresaModelRepository extends RevisionRepository<EmpresaModel, UUID, Integer> , JpaRepository <EmpresaModel, UUID> {

    Optional<EmpresaModel> findByCnpj(String cnpj);

    boolean existsByCnpj(String cnpj);
}
