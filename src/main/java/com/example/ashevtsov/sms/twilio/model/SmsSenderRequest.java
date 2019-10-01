package com.example.ashevtsov.sms.twilio.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SmsSenderRequest {
    private String phoneNumberTo;
    private String text;
}
