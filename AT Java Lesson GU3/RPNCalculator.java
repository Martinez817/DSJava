/*
 * 5/22/25 
 * RPNCalculator 
 * Jonathan Martinez 
 * AT Java
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RPNCalculator extends JFrame {
    private JTextField display;
    private JTextArea stackArea;
    private DoubleStack stack;

    public RPNCalculator() {
        super("RPN Calculator");
        stack = new DoubleStack();
        setupUI();
    }

    private void setupUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 500);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        display = new JTextField();
        display.setEditable(false);
        display.setFont(new Font("Monospaced", Font.PLAIN, 18));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(display, gbc);

        stackArea = new JTextArea(10, 30);
        stackArea.setEditable(false);
        stackArea.setFont(new Font("Monospaced", Font.PLAIN, 16));
        JScrollPane scrollPane = new JScrollPane(stackArea);
        gbc.gridy = 1;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.BOTH;
        add(scrollPane, gbc);

        String[] buttons = {
            "7", "8", "9", "+",
            "4", "5", "6", "-",
            "1", "2", "3", "*",
            "0", ".", "ENTER", "/",
            "CLEAR"
        };

        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridwidth = 1;
        int row = 2;

        for (int i = 0; i < buttons.length; i++) {
            String label = buttons[i];
            JButton button = new JButton(label);
            button.setFont(new Font("Arial", Font.BOLD, 18));

            button.addActionListener(new ButtonHandler());

            gbc.gridx = i % 4;
            gbc.gridy = row + i / 4;
            if (label.equals("CLEAR")) {
                gbc.gridwidth = 4;
                add(button, gbc);
                break;
            } else {
                gbc.gridwidth = 1;
                add(button, gbc);
            }
        }

        setVisible(true);
    }

    private class ButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String cmd = e.getActionCommand();
            switch (cmd) {
                case "ENTER":
                    try {
                        double val = Double.parseDouble(display.getText());
                        stack.push(val);
                        display.setText("");
                        updateStackDisplay();
                    } catch (NumberFormatException ex) {
                        display.setText("Error");
                    }
                    break;
                case "+":
                case "-":
                case "*":
                case "/":
                    try {
                        double b = stack.pop();
                        double a = stack.pop();
                        double result = switch (cmd) {
                            case "+" -> a + b;
                            case "-" -> a - b;
                            case "*" -> a * b;
                            case "/" -> a / b;
                            default -> 0;
                        };
                        stack.push(result);
                        updateStackDisplay();
                    } catch (Exception ex) {
                        display.setText("Stack Error");
                    }
                    break;
                case "CLEAR":
                    stack.clear();
                    display.setText("");
                    updateStackDisplay();
                    break;
                default: // digits and .
                    display.setText(display.getText() + cmd);
            }
        }
    }

    private void updateStackDisplay() {
        stackArea.setText(stack.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new RPNCalculator());
    }
}
