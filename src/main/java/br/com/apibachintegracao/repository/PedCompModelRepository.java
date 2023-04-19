package br.com.apibachintegracao.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;

import br.com.apibachintegracao.domain.PedCompModel;

public interface PedCompModelRepository extends RevisionRepository<PedCompModel, UUID, Integer> , JpaRepository <PedCompModel, UUID> {

}
