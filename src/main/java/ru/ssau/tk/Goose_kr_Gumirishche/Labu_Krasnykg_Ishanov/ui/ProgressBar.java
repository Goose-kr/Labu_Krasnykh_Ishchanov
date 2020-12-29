package ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.ui;

import javax.swing.*;
import java.awt.*;

public class ProgressBar extends JDialog {
    public int count;

    public ProgressBar() {
        super();
        JProgressBar progressBar = new JProgressBar();
        setModal(true);
        progressBar.setStringPainted(true);
        setSize(new Dimension(400, 200));
        progressBar.setMinimum(0);
        progressBar.setMaximum(100);
        Timer timer = new Timer(1000, e -> {
            count = progressBar.getValue();
            if (count < 100) {
                count += Math.random() * 100;
                progressBar.setValue(count);
            }
        });
        progressBar.addChangeListener(e -> {
            if (progressBar.getValue() == 100) {
                timer.stop();
                dispose();
            }
        });
        timer.start();

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER).addGroup(layout.createSequentialGroup().addComponent(progressBar)));

        layout.setVerticalGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(progressBar)));
        setLocationRelativeTo(null);
    }
}
