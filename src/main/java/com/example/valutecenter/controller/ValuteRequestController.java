package com.example.valutecenter.controller;

import com.example.valutecenter.model.Valute;
import com.example.valutecenter.service.TypeValuteService;
import com.example.valutecenter.service.ValuteService;
import com.example.valutecenter.service.bisness.CalculationAverageValuesService;
import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

import static org.springframework.http.ResponseEntity.ok;


@RequestMapping("/api")
@AllArgsConstructor
@RestController
@EnableAsync
class ValuteRequestController {

    private TypeValuteService typeValuteService;

    private ValuteService valuteService;

    private CalculationAverageValuesService calculationAverageValuesService;

    @GetMapping("/valutes")
    ResponseEntity<Collection<Valute>> getValutes() throws InterruptedException {
        calculationAverageValuesService.sendMessage("Dollar");
        val result = typeValuteService.getValueValutes();
        List<Valute> valutes = valuteService.findAllValutes();
        valutes.forEach(valute -> {valute.setValue(result.getRates().get(valute.getName()).getValue());});


        return ok().body(result.getRates().values());
    }

    @PostMapping("/valutes")
    ResponseEntity<String> newEmployee(@RequestBody List<Valute> valute) {
        valuteService.create(valute);
        return ok().body(valute.toString());
    }

}

