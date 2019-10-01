package com.example.ashevtsov.sms.twilio.controller;

import com.example.ashevtsov.sms.twilio.model.SmsSenderRequest;
import com.example.ashevtsov.sms.twilio.model.SmsSenderResponse;
import com.example.ashevtsov.sms.twilio.service.SmsSenderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/sendSms")
@RequiredArgsConstructor
public class SmsSenderController {

    private final SmsSenderService smsSenderService;

    @PostMapping
    public ResponseEntity<SmsSenderResponse> sendSms(@RequestBody SmsSenderRequest request) {
        SmsSenderResponse smsSenderResponse = smsSenderService.sendMessage(request);
        return smsSenderResponse.isSuccess()
                ? ResponseEntity.ok(smsSenderResponse)
                : ResponseEntity.badRequest().body(smsSenderResponse);
    }
}
