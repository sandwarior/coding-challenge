package com.codingchallenge.exception;

public class ClientConnectionRefusedException extends RuntimeException {
    public ClientConnectionRefusedException(String message) {
        super(message);
    }
}
