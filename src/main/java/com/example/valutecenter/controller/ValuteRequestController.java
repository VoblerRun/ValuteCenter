package com.example.valutecenter.controller;

import com.example.valutecenter.model.ResponseTypeValute;
import com.example.valutecenter.service.TypeValuteService;
import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.ok;


@RequestMapping("/api-public")
@AllArgsConstructor
@RestController
class ValuteRequestController {

    private TypeValuteService typeValuteService;

    @GetMapping("/allValutes")
    ResponseEntity<ResponseTypeValute> getValutes() {
        val result = typeValuteService.getValueValutes();
        return ok().body(result);
    }

}

