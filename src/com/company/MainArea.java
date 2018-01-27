package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainArea extends JFrame {

    private JButton moveButton;
    private JButton boardButton;
    private JLabel textLabel;
    private JTextField moveTextField;
    private JTextArea mapTextArea;
    private JScrollPane scrollPane;

    private Board board;

    public MainArea() {
        createView();
        board = new Board();
        board.populateBoard();


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
        moveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                board.checkMovement();
                mapTextArea.setText(board.printBoard());
            }
        });

        boardButton = new JButton("Check board");
        panel.add(boardButton);

        boardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                mapTextArea.setText(board.printBoard());
            }
        });

        moveTextField = new JTextField(8);
        panel.add(moveTextField);

        mapTextArea = new JTextArea();
        mapTextArea.setEditable(false);
        mapTextArea.setLineWrap(true);
        mapTextArea.setWrapStyleWord(true);
        mapTextArea.setColumns(8);
        mapTextArea.setRows(8);

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
