package com.example.valutecenter.service;

import com.example.valutecenter.model.Valute;
import com.example.valutecenter.repository.ValuteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@AllArgsConstructor
@Service
public class ValuteService {
    private ValuteRepository valuteRepository;

    public void create(List<Valute> valutes){
        valuteRepository.saveAll(valutes);
    }

    public List<Valute> findAllValutes(){
        return valuteRepository.findAll();
    }

}
