package br.edu.unicesumar.folia.domain.boleto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BoletoRepository extends JpaRepository<Boleto, UUID> {
}
