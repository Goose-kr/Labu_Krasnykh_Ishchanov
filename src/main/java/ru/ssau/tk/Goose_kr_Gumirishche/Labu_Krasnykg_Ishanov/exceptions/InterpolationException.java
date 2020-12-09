package ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.exceptions;

import java.io.Serializable;

public class InterpolationException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = -308509252681199416L;

    public InterpolationException() {
    }

    public InterpolationException(String message) {
        super(message);
    }
}
