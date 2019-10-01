package com.example.ashevtsov.sms.twilio.service;

import com.example.ashevtsov.sms.twilio.config.TwilioProperties;
import com.example.ashevtsov.sms.twilio.model.SmsSenderRequest;
import com.example.ashevtsov.sms.twilio.model.SmsSenderResponse;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
public class TwilioSmsSenderService implements SmsSenderService {

    private final TwilioProperties twilioProperties;

    public TwilioSmsSenderService(TwilioProperties twilioProperties) {
        this.twilioProperties = twilioProperties;
        Twilio.init(twilioProperties.getAccountSid(), twilioProperties.getAuthToken());
    }

    @Override
    public SmsSenderResponse sendMessage(SmsSenderRequest request) {
        try {
            Message message = Message.creator(
                    new PhoneNumber(request.getPhoneNumberTo()),
                    new PhoneNumber(twilioProperties.getPhoneNumberFrom()),
                    request.getText())
                    .create();

            return SmsSenderResponse.builder()
                    .success(true)
                    .dateTime(LocalDateTime.now())
                    .sid(message.getSid())
                    .build();
        } catch (Exception e) {
            log.error(e.getLocalizedMessage(), e);
            return SmsSenderResponse.builder()
                    .dateTime(LocalDateTime.now())
                    .errorMessage(e.getLocalizedMessage())
                    .build();
        }
    }
}
