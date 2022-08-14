package com.codingchallenge.exception;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class GenericExceptionObject implements Serializable {
    @JsonProperty("message")
    private String message = null;

    public GenericExceptionObject message(String message) {
        this.message = message;
        return this;
    }
}
