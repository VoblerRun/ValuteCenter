package com.example.valutecenter.model.response;

import com.example.valutecenter.model.Valute;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class ResponseTypeValute {

        private String date;

        private String base;

        private Map<String, Valute> rates;

        @Override
        public String toString()
        {
                return " [date = "+date+",  rates = "+rates+", base = "+base+"]";
        }

}
