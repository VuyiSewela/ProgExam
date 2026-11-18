import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;

public class ProductApp extends JFrame {

    private JTextField txtCustomerName;
    private JTextField txtPrice;
    private JComboBox<String> cmbProduct;
    private JButton btnProcess;

    // Constructor creates the GUI
    public ProductApp() {

        setTitle("Product App");
        setSize(500, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(
            new GridLayout(4, 2, 10, 15)
        );

        panel.setBorder(
            BorderFactory.createEmptyBorder(30, 20, 30, 20)
        );

        // Customer name
        panel.add(new JLabel("Customer Name:"));
        txtCustomerName = new JTextField();
        panel.add(txtCustomerName);

        // Product selection
        panel.add(new JLabel("Select Product:"));

        String[] products = {
            "Cozy Nights Monarch",
            "Restonic Barbados",
            "Sealy Phuket"
        };

        cmbProduct = new JComboBox<>(products);
        panel.add(cmbProduct);

        // Product price
        panel.add(new JLabel("Enter Price:"));
        txtPrice = new JTextField();
        panel.add(txtPrice);

        // Process button
        panel.add(new JLabel(""));
        btnProcess = new JButton("PROCESS");
        panel.add(btnProcess);

        // Process button calls processing method
        btnProcess.addActionListener(e -> processSale());

        add(panel);

        // Q2.4 - Create menu bar
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenuItem exitItem = new JMenuItem("Exit");

        exitItem.addActionListener(e -> dispose());
        fileMenu.add(exitItem);

        JMenu toolsMenu = new JMenu("Tools");

        JMenuItem processItem = new JMenuItem("Process");
        JMenuItem clearItem = new JMenuItem("Clear");

        // Reuse same processing logic
        processItem.addActionListener(e -> processSale());

        // Clear all fields
        clearItem.addActionListener(e -> clearForm());

        toolsMenu.add(processItem);
        toolsMenu.add(clearItem);

        menuBar.add(fileMenu);
        menuBar.add(toolsMenu);

        setJMenuBar(menuBar);
    }

    /**
     * Q2.3 - Process the mattress sale.
     * Calculate VAT, commission and total.
     * Display results and save to data.txt.
     */
    private void processSale() {

        String customer = txtCustomerName.getText().trim();

        String product =
            (String) cmbProduct.getSelectedItem();

        // Validate customer name
        if (customer.isEmpty()) {
            JOptionPane.showMessageDialog(
                this, "Please enter customer name."
            );
            return;
        }

        try {

            double price = Double.parseDouble(
                txtPrice.getText().trim()
            );

            if (!Double.isFinite(price) || price < 0) {
                JOptionPane.showMessageDialog(
                    this, "Please enter a valid price."
                );
                return;
            }

            // Create calculation object
            ProductCalculations calculations =
                new ProductCalculations(price);

            double vat = calculations.GetVat();
            double commission = calculations.GetCommission();
            double total = calculations.GetTotal();

            // Prepare the output
            String result = String.format(
                java.util.Locale.US,
                "Customer Name: %s%n" +
                "Product: %s%n" +
                "VAT: R %.1f%n" +
                "COMMISSION: R %.1f%n" +
                "TOTAL: R %.1f",
                customer, product, vat, commission, total
            );

            // Save data to text file
            try (FileWriter writer =
                    new FileWriter("data.txt", true)) {

                writer.write("DATA LOG\n");
                writer.write(
                    "********************************\n"
                );
                writer.write(result + "\n");
                writer.write(
                    "********************************\n"
                );

            } catch (IOException ex) {

                JOptionPane.showMessageDialog(
                    this,
                    "Error saving data: " + ex.getMessage()
                );
                return;
            }

            // Display sale information
            JOptionPane.showMessageDialog(
                this,
                result,
                "Message",
                JOptionPane.INFORMATION_MESSAGE
            );

        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(
                this,
                "Please enter a valid numeric price."
            );
        }
    }

    /**
     * Q2.4 - Clear the form.
     */
    private void clearForm() {

        txtCustomerName.setText("");
        txtPrice.setText("");
        cmbProduct.setSelectedIndex(0);
    }

    // Start application
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new ProductApp().setVisible(true);
        });
    }
}
