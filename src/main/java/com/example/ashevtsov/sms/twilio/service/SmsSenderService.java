package com.example.ashevtsov.sms.twilio.service;

import com.example.ashevtsov.sms.twilio.model.SmsSenderRequest;
import com.example.ashevtsov.sms.twilio.model.SmsSenderResponse;

public interface SmsSenderService {
    SmsSenderResponse sendMessage(SmsSenderRequest request);
}
