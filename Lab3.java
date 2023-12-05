package edu.neu.megn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Lab3 {
    private JFrame frame;
    private JComboBox<String> colorDropdown;
    private JPanel circlePanel;
    private JTextField outputField;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Lab3().createAndShowGUI());
    }

    private void createAndShowGUI() {
        frame = new JFrame("Color Chooser App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);

        colorDropdown = new JComboBox<>(new String[]{"Select Color", "Red", "Blue", "Green"});
        colorDropdown.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                updateColor();
            }
        });

        circlePanel = new JPanel() {
            
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawCircle(g);
            }
        };

        outputField = new JTextField();
        outputField.setEditable(false);

        JPanel mainPanel = new JPanel(new GridLayout(3, 1));
        mainPanel.add(colorDropdown);
        mainPanel.add(circlePanel);
        mainPanel.add(outputField);

        frame.getContentPane().add(mainPanel);
        frame.setVisible(true);
    }

    private void drawCircle(Graphics g) {
        int diameter = 100;
        int x = (circlePanel.getWidth() - diameter) / 2;
        int y = (circlePanel.getHeight() - diameter) / 2;

        Color selectedColor = getColorFromDropdown();
        g.setColor(selectedColor);
        g.fillOval(x, y, diameter, diameter);
    }

    private Color getColorFromDropdown() {
        String selectedColor = (String) colorDropdown.getSelectedItem();

        switch (selectedColor) {
            case "Red":
                outputField.setText("Selected Color: Red");
                return Color.RED;
            case "Blue":
                outputField.setText("Selected Color: Blue");
                return Color.BLUE;
            case "Green":
                outputField.setText("Selected Color: Green");
                return Color.GREEN;
            default:
                outputField.setText("Selected Color: ");
                return Color.WHITE;
        }
    }

    private void updateColor() {
        circlePanel.repaint();
    }
}