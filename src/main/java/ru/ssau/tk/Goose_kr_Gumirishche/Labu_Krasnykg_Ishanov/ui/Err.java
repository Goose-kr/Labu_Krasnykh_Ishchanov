package ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.ui;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Err extends JDialog {
    Err(Component parent, Exception e) {
        getErr(parent, e);
        setModal(true);
    }

    public void getErr(Component parent, Exception e) {
        String message = MessageForException(e);
        JOptionPane.showMessageDialog(parent, message, "Ошибка", JOptionPane.ERROR_MESSAGE);
    }

    private String MessageForException(Exception e) {
        if (e instanceof IOException) {
            return "Не читаемый файл";
        }
        return "Неправильно!!!";
    }
}
