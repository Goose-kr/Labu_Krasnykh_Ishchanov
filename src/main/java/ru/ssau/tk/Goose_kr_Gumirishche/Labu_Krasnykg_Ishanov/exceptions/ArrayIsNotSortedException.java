package ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.exceptions;

import java.io.Serializable;

public class ArrayIsNotSortedException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 1606994559359520949L;

    public ArrayIsNotSortedException() {
    }

    public ArrayIsNotSortedException(String message) {
        super(message);
    }
}
