package com.example.valutecenter.repository;


import com.example.valutecenter.model.Valute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Transactional
public interface ValuteRepository extends JpaRepository<Valute, Integer> {

    @Override
    <S extends Valute> List<S> saveAll(Iterable<S> entities);
    @Override
    List<Valute> findAll ();
    @Query("SELECT v FROM Valute v WHERE v.name IN (:names)")
    List<Valute> findByValuteNames(@Param("names")List<String> names);
}