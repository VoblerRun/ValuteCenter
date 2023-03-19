package com.example.valutecenter.repository;


import com.example.valutecenter.model.Valute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ValuteRepository extends JpaRepository<Valute, Integer> {

    @Override
    <S extends Valute> List<S> saveAll(Iterable<S> entities);
}