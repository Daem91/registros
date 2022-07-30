package com.embutidosdemo.domain.repositories;

import com.embutidosdemo.domain.entities.Chofer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChoferRepository extends JpaRepository<Chofer, Integer> {

}
