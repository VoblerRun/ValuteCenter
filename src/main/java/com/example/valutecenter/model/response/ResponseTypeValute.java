package com.example.valutecenter.model.response;

import com.example.valutecenter.model.Valute;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class ResponseTypeValute {

        private String date;

        private String base;

        private List<Valute> rates;

        @Override
        public String toString()
        {
                return " [date = "+date+",  rates = "+rates+", base = "+base+"]";
        }

}
