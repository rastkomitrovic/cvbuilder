package com.fon.bg.ac.rs.cvbuilder.util;

import java.util.List;

public class CVBuilderException extends RuntimeException {
    private final List<String> messages;

    public CVBuilderException(List<String> messages) {
        super("Greska");
        this.messages = messages;
    }

    public List<String> getMessages() {
        return messages;
    }
}
