import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Convertor valutar");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);

        JPanel panel = new JPanel(new GridLayout(5, 2));

        JComboBox<String> fromCurrency = new JComboBox<>(new String[]{"RON", "EUR", "USD", "XAU", "AUD", "CAD"});
        JComboBox<String> toCurrency = new JComboBox<>(new String[]{"RON", "EUR", "USD", "XAU", "AUD", "CAD"});
        JTextField amountField = new JTextField();
        JLabel resultLabel = new JLabel("Aici va aparea rezultatul!");
        JButton convertButton = new JButton("Converteste");

        panel.add(new JLabel("Din moneda:"));
        panel.add(fromCurrency);
        panel.add(new JLabel("In moneda:"));
        panel.add(toCurrency);
        panel.add(new JLabel("Suma:"));
        panel.add(amountField);
        panel.add(new JLabel(" "));
        panel.add(convertButton);
        panel.add(new JLabel("Rezultatul este:"));
        panel.add(resultLabel);

        frame.add(panel, BorderLayout.CENTER);

        convertButton.addActionListener(e -> {
            double[] rates = {1.0, 4.97, 4.78, 0.0025, 0.3349, 0.301}; // RON, EUR, USD, XAU, AUD, CAD
            int fromIndex = fromCurrency.getSelectedIndex();
            int toIndex = toCurrency.getSelectedIndex();
            try {
                double amount = Double.parseDouble(amountField.getText());
                double result = amount * rates[fromIndex] / rates[toIndex];
                resultLabel.setText(String.format("%.2f", result));
                resultLabel.setForeground(Color.BLACK);
            } catch (NumberFormatException ex) {
                resultLabel.setText("Suma invalida!");
                resultLabel.setFont(new Font("Calibri", Font.BOLD, 16));
                resultLabel.setForeground(Color.RED);
            }
        });

        frame.setVisible(true);
    }
}
