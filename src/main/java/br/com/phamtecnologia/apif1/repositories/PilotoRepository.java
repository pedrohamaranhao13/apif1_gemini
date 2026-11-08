package br.com.phamtecnologia.apif1.repositories;

import br.com.phamtecnologia.apif1.entities.Piloto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PilotoRepository extends JpaRepository<Piloto, Integer> {


}
