package com.company;

import javax.swing.*;
import java.awt.*;

public class MainArea extends JFrame {

    private JButton moveButton;
    private JLabel textLabel;
    private JTextField moveTextField;
    private JTextArea mapTextArea;
    private JScrollPane scrollPane;

    public MainArea()  {
        createView();

        setTitle("Text area test");

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 600);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void createView() {
        JPanel panel = new JPanel();
        getContentPane().add(panel);


        textLabel = new JLabel("Move player");
        panel.add(textLabel);

        moveButton = new JButton("Make a move");
        panel.add(moveButton);


        moveTextField = new JTextField(15);
        panel.add(moveTextField);

        mapTextArea = new JTextArea();
        mapTextArea.setEditable(false);
        mapTextArea.setLineWrap(true);
        mapTextArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(mapTextArea);
        scrollPane.setPreferredSize(new Dimension(350, 90));
        panel.add(scrollPane);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainArea().setVisible(true);
            }
        });
    }
}
