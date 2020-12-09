package ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.exceptions;

import java.io.Serializable;

public class InconsistentFunctionsException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 6485895451938296798L;

    public InconsistentFunctionsException() {
    }

    public InconsistentFunctionsException(String message) {
        super(message);
    }
}

