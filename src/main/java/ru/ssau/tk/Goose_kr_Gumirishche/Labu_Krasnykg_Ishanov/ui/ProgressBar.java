package ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.ui;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class ProgressBar extends JDialog {
    public int count;
    public ProgressBar() {
        super();
        JProgressBar progressBar = new JProgressBar();
        WindowEvent event=new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
        progressBar.setStringPainted(true);
        setSize(new Dimension(400,200));
        progressBar.setMinimum(0);
        progressBar.setMaximum(100);
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                count = progressBar.getValue();
                if (count < 100) {
                    count+=Math.random()*100;
                    progressBar.setValue(count);
                }
            }
        });
        progressBar.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (progressBar.getValue() == 100) {
                    timer.stop();
                    dispose();
                }
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
