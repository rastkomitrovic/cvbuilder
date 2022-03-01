package com.fon.bg.ac.rs.cvbuilder.util;

public class CVBuilderException extends Exception {
    private String message;

    public CVBuilderException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
