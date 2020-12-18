package ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FirstWindow extends JFrame {
    private JButton button=new JButton("enter");
    private JTextField input=new JTextField("This is text field");
    private JLabel label=new JLabel("Input size:");

    public FirstWindow(){
        super("Hey hey");
        this.setBounds(200,200,500,200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container=this.getContentPane();
        container.add(button);
        container.add(input);
        container.add(label);
    }
}
