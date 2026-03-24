package com.codewithmosh.store.auth;

public class InvalidTokenException extends RuntimeException {
    public InvalidTokenException() {
        super("No token or token expired.");
    }
}
