import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class InterestCalculatorApp {

    private double balance = 1000.00;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new InterestCalculatorApp().createAndShowGUI());
    }

    private void createAndShowGUI() {
        JFrame frame = new JFrame("Interest Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 250);
        frame.setLayout(new FlowLayout());

        JLabel rateLabel = new JLabel("Interest Rate (%):");
        JTextField rateField = new JTextField("5.00", 10);

        JButton calculateButton = new JButton("Calculate");

        JTextArea resultArea = new JTextArea(10, 30);
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);

        DecimalFormat df = new DecimalFormat("#.00");

        calculateButton.addActionListener(e -> {
            try {
                String input = rateField.getText().trim();
                double rate = Double.parseDouble(input);
                if (rate < 0) {
                    JOptionPane.showMessageDialog(frame, "Interest rate must be non-negative.");
                    return;
                }

                balance += balance * (rate / 100.0);
                resultArea.append("New balance with " + df.format(rate) + "% interest: $" + df.format(balance) + "\n");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Please enter a valid number for the interest rate.");
            }
        });

        frame.add(rateLabel);
        frame.add(rateField);
        frame.add(calculateButton);
        frame.add(scrollPane);

        frame.setVisible(true);
    }
}
