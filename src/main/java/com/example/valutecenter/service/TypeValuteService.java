package com.example.valutecenter.service;

import com.example.valutecenter.model.Valute;
import com.example.valutecenter.model.response.ResponseTypeValute;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.*;

@Service
@AllArgsConstructor
public class TypeValuteService {

    private final WebClient webClient;


    public ResponseTypeValute getValueValutes() {
            String responseBody = webClient
                    .get().uri("/exchangerates_data/latest").header("apikey", "fEs4fctN0GvIw1fBAFhG9EuZxnwXtt5j")
                    .retrieve().bodyToMono(String.class).block();
            return parseStringToResponseTypeValute(responseBody);

    }

    private ResponseTypeValute parseStringToResponseTypeValute(String responseBody) {
        try {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> responseObjectFull = mapper.readValue(responseBody, new TypeReference<Map<String, Object>>() {});
        ResponseTypeValute responseTypeValute = new ResponseTypeValute();
        responseTypeValute.setDate((String) responseObjectFull.get("date"));
        responseTypeValute.setBase((String) responseObjectFull.get("base"));
        responseTypeValute.setRates(parseStringToRates((LinkedHashMap<String, Object>) responseObjectFull.get("rates")));
        return responseTypeValute;
        } catch (Exception e) {
            // show error message
            e.printStackTrace();
        }
        return null;
    }

    private Map<String, Valute> parseStringToRates(LinkedHashMap<String, Object> rates){
        Map<String, Valute> nameByValute = new HashMap<>();
        List<String> valuteNames = new ArrayList<>();
        for (String keyRate : rates.keySet()){
            Valute valute = new Valute();
            valute.setName(keyRate);
            valute.setValue(String.valueOf(rates.get(keyRate)));
            nameByValute.put(keyRate, valute);

            valuteNames.add(keyRate);
        }

        return nameByValute;
    }

}
