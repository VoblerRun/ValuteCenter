package com.example.valutecenter.service.bisness;

import com.example.valutecenter.model.Email;
import com.example.valutecenter.service.DefaultEmailService;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CalculationAverageValuesService {

    DefaultEmailService defaultEmailService;

    @Async
    public void sendMessage(String nameRecords) throws InterruptedException {
        Email email = new Email();
        email.setMessage("PRivet DOROGOY");
        email.setRecipient("star01010scream@gmail.com");
        email.setSubject("subject");
        defaultEmailService.sendSimpleEmail(email);
//        return result;
    }


}
