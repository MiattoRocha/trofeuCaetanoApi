package com.trofeuCaetano.Repositories;

import com.trofeuCaetano.Models.Apontamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface ApontamentoRepository extends JpaRepository<Apontamento, Integer> {

    @Query(value = "SELECT * FROM apontamento WHERE data BETWEEN :data1 AND :data2", nativeQuery = true)
    List<Apontamento> findByIntervaloData(Date data1 , Date data2);

}
