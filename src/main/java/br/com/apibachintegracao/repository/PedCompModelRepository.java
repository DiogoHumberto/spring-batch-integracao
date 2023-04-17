package br.com.apibachintegracao.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.apibachintegracao.models.PedCompModel;

public interface PedCompModelRepository extends JpaRepository <PedCompModel, UUID> {

}
