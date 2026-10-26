package br.com.unicuritiba.concessionaria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.unicuritiba.concessionaria.models.Peca;

@Repository
public interface PecaRepository extends JpaRepository<Peca, Long> {
}