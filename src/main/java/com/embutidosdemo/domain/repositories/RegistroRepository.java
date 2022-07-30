package com.embutidosdemo.domain.repositories;

import com.embutidosdemo.domain.entities.Registro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistroRepository extends JpaRepository<Registro, Integer> {
}
