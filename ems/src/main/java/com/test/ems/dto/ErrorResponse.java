package com.test.ems.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {
    @JsonProperty("StatusCode")
    private int statusCode;
    @JsonProperty("Message")
    private String message;
    @JsonProperty("TimeStamp")
    private LocalDateTime timeStamp;
    @JsonProperty("Error")
    private HttpStatus error;
    public ErrorResponse(String message){
        super();
        this.message=message;
    }
}
