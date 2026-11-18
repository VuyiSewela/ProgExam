import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;

public class ProductApp extends JFrame {
    private final JTextField txtCustomerName;
    private final JTextField txtPrice;
    private final JComboBox<String> cmbProduct;

    public ProductApp() {
        setTitle("Product App");
        setSize(500, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 15));
        panel.setBorder(BorderFactory.createEmptyBorder(30, 20, 30, 20));
        panel.add(new JLabel("Customer Name:"));
        txtCustomerName = new JTextField();
        panel.add(txtCustomerName);
        panel.add(new JLabel("Select Product:"));
        cmbProduct = new JComboBox<>(new String[] {
            "Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"
        });
        panel.add(cmbProduct);
        panel.add(new JLabel("Enter Price:"));
        txtPrice = new JTextField();
        panel.add(txtPrice);
        panel.add(new JLabel(""));
        JButton btnProcess = new JButton("PROCESS");
        btnProcess.addActionListener(e -> processSale());
        panel.add(btnProcess);
        add(panel);

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(e -> dispose());
        fileMenu.add(exitItem);
        JMenu toolsMenu = new JMenu("Tools");
        JMenuItem processItem = new JMenuItem("Process");
        processItem.addActionListener(e -> processSale());
        JMenuItem clearItem = new JMenuItem("Clear");
        clearItem.addActionListener(e -> clearForm());
        toolsMenu.add(processItem);
        toolsMenu.add(clearItem);
        menuBar.add(fileMenu);
        menuBar.add(toolsMenu);
        setJMenuBar(menuBar);
    }

    private void processSale() {
        String customer = txtCustomerName.getText().trim();
        String product = (String) cmbProduct.getSelectedItem();
        if (customer.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter customer name.");
            return;
        }
        try {
            double price = Double.parseDouble(txtPrice.getText().trim());
            if (!Double.isFinite(price) || price < 0) {
                JOptionPane.showMessageDialog(this, "Please enter a valid price.");
                return;
            }
            ProductCalculations calculations = new ProductCalculations(price);
            String result = String.format(Locale.US,
                "Customer Name: %s%nProduct: %s%nVAT: R %.1f%nCOMMISSION: R %.1f%nTOTAL: R %.1f",
                customer, product, calculations.GetVat(),
                calculations.GetCommission(), calculations.GetTotal());
            try (FileWriter writer = new FileWriter("data.txt", true)) {
                writer.write("DATA LOG\n");
                writer.write("********************************\n");
                writer.write(result + "\n");
                writer.write("********************************\n");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error saving data: " + ex.getMessage());
                return;
            }
            JOptionPane.showMessageDialog(this, result, "Message", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid numeric price.");
        }
    }

    private void clearForm() {
        txtCustomerName.setText("");
        txtPrice.setText("");
        cmbProduct.setSelectedIndex(0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ProductApp().setVisible(true));
    }
}
