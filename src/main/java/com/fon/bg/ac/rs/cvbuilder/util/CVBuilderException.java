package com.fon.bg.ac.rs.cvbuilder.util;

public class CVBuilderException extends RuntimeException {
    private final String message;

    public CVBuilderException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
