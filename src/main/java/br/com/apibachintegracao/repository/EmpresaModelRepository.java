package br.com.apibachintegracao.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;

import br.com.apibachintegracao.domain.EmpresaModel;

public interface EmpresaModelRepository extends RevisionRepository<EmpresaModel, UUID, Integer> , JpaRepository <EmpresaModel, UUID> {

}
