package com.example.ashevtsov.sms.twilio.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SmsSenderResponse {
    private boolean success;
    private LocalDateTime dateTime;
    private String sid;
    private String errorMessage;
}
