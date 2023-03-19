package com.example.valutecenter.service;

import com.example.valutecenter.model.ResponseTypeValute;
import com.example.valutecenter.model.Valute;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class TypeValuteService {

    private final WebClient webClient;


    public ResponseTypeValute getValueValutes() {
        try {

            String d = webClient
                    .get().uri("/exchangerates_data/latest").header("apikey", "fEs4fctN0GvIw1fBAFhG9EuZxnwXtt5j")
                    .retrieve().bodyToMono(String.class).block();
            ObjectMapper mapper = new ObjectMapper();
            Map<String, Object> responseObjectFull = mapper.readValue(d, new TypeReference<Map<String, Object>>() {});
            LinkedHashMap<String, Object> rates = (LinkedHashMap<String, Object>) responseObjectFull.get("rates");
            ResponseTypeValute responseTypeValute = new ResponseTypeValute();
            responseTypeValute.setDate((String) responseObjectFull.get("date"));
            responseTypeValute.setBase((String) responseObjectFull.get("base"));
            List<Valute> valutes = new ArrayList<>();
            for (String keyRate : rates.keySet()){
                Valute valute = new Valute();
                valute.setName(keyRate);
                valute.setValue(String.valueOf(rates.get(keyRate)));
                valutes.add(valute);
            }
            responseTypeValute.setRates(valutes);
           return responseTypeValute;
        } catch (Exception e) {
            // show error message
            e.printStackTrace();
        }
        return null;
    }
}
