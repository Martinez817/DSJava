import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InterestCalculatorGUI extends JFrame {
    private JTextField interestRateField;
    private JLabel balanceLabel;
    private static final double INITIAL_BALANCE = 1000.00;

    public InterestCalculatorGUI() {
        setTitle("Interest Calculator");
        setSize(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        add(new JLabel("Enter Interest Rate (%):"));
        interestRateField = new JTextField("5.00", 10);
        add(interestRateField);

        JButton calculateButton = new JButton("Calculate");
        add(calculateButton);

        balanceLabel = new JLabel("Balance: $1000.00");
        add(balanceLabel);

        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculateNewBalance();
            }
        });
    }

    private void calculateNewBalance() {
        String rateText = interestRateField.getText().trim();
        try {
            double rate = Double.parseDouble(rateText);
            if (rate < 0) {
                throw new NumberFormatException("Negative rate");
            }
            double newBalance = INITIAL_BALANCE + (INITIAL_BALANCE * rate / 100);
            balanceLabel.setText(String.format("Balance: $%.2f", newBalance));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, 
                "Please enter a valid positive number for the interest rate.",
                "Input Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new InterestCalculatorGUI().setVisible(true);
        });
    }
}
