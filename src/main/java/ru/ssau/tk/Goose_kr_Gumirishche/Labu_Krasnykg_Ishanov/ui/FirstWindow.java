package ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FirstWindow extends JFrame {

    public FirstWindow(){
        super("Hey hey");
        this.setBounds(200,200,500,200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());
        Container container=this.getContentPane();
        JLabel label = new JLabel("Input size:");
        container.add(label);
        JTextField input = new JTextField("This is text field");
        container.add(input);
        JButton button = new JButton("enter");
        container.add(button);
    }
    public static void main(String[] args) {
        JFrame firstWindow=new FirstWindow();
        firstWindow.setVisible(true);
    }
}
