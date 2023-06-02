package com.example.demo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Swing App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 500);
        frame.setLocationRelativeTo(null);

        JPanel root = new JPanel();
        root.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        root.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        frame.setContentPane(root);

        JPanel group1 = createRectangleWithText("Bob");
        group1.addMouseListener((MouseListener) new MouseClickListener("Bob matou o guarda!"));

        JPanel group2 = createRectangleWithText("Rafa");
        group2.addMouseListener((MouseListener) new MouseClickListener("Nhec nhec nhec"));

        JPanel group3 = createRectangleWithText("Leo");
        group3.addMouseListener((MouseListener) new MouseClickListener("Roubou mais comida do refeitório."));

        root.add(group1);
        root.add(group2);
        root.add(group3);

        frame.setVisible(true);
    }

    private static JPanel createRectangleWithText(String text) {
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(250, 400));
        panel.setBackground(Color.BLUE);

        JLabel label = new JLabel(text);
        label.setForeground(Color.WHITE);

        panel.setLayout(new GridBagLayout());
        panel.add(label);

        return panel;
    }

    private static class MouseClickListener extends MouseAdapter {
        private final String newText;

        public MouseClickListener(String newText) {
            this.newText = newText;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            JFrame dialogFrame = new JFrame("Nova Janela");
            dialogFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            dialogFrame.setSize(300, 200);
            dialogFrame.setLocationRelativeTo(null);

            JLabel label = new JLabel(newText);
            JButton closeButton = new JButton("Fechar");
            closeButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dialogFrame.dispose();
                }
            });

            JPanel dialogPanel = new JPanel();
            dialogPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
            dialogPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
            dialogPanel.add(label);
            dialogPanel.add(closeButton);

            dialogFrame.setContentPane(dialogPanel);
            dialogFrame.setVisible(true);
        }
    }
}
