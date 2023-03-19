package com.example.valutecenter.service;

import com.example.valutecenter.model.Valute;
import com.example.valutecenter.repository.ValuteRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;


@AllArgsConstructor
@Service
public class ValuteService {
    private ValuteRepository valuteRepository;



    public void create(List<Valute> valutes){
        valuteRepository.saveAll(valutes);
    }

}
