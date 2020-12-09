package ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.exceptions;

import java.io.Serializable;

public class DifferentLengthOfArraysException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 825539209972862277L;

    public DifferentLengthOfArraysException() {
    }

    public DifferentLengthOfArraysException(String message) {
        super(message);
    }
}
