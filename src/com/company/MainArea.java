package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainArea extends JFrame {

    private JButton moveButton;
    private JButton boardButton;
    private JButton startButton;
    private JLabel textLabel;
    private JLabel[][] labelGrid;
    private JTextField moveTextField;
    private JTextArea mapTextArea;
    private JTextArea chessMoveArea;
    private JScrollPane scrollPane;

    private Board board;

    public MainArea() {
        createView();
        board = new Board();
        board.populateBoard();

        setTitle("Text area test");

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1200, 1200);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void createView() {
        JPanel panel = new JPanel();
        getContentPane().add(panel);


        textLabel = new JLabel("Chess game");
        panel.add(textLabel);

        moveButton = new JButton("White Turn     ");
        panel.add(moveButton);
        moveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                board.checkMovement();

                if (board.playerWhite.isMyTurn())
                    moveButton.setText("Black");
                else
                    moveButton.setText("White");
                board.playerTurn();

                mapTextArea.setText(board.printBoard());
//                chessMoveArea.setText(board.getPrintMoves());
            }
        });

        boardButton = new JButton("Start board");
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
        scrollPane.setPreferredSize(new Dimension(350, 150));
        panel.add(scrollPane);

        chessMoveArea = new JTextArea("Hej hej");
        chessMoveArea.setEditable(false);
        chessMoveArea.setLineWrap(true);
        chessMoveArea.setWrapStyleWord(true);
        chessMoveArea.setColumns(8);
        chessMoveArea.setRows(8);
        panel.add(chessMoveArea);

        labelGrid = new JLabel[8][8];
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
