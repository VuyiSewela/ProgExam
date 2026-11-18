import java.util.Scanner;

public class MattressSalesReport {

    public static void main(String[] args) {

        // Create Scanner to capture user input
        Scanner input = new Scanner(System.in);

        // 1D array: Store the three mattress names
        String[] products = {
            "Cozy Nights Monarch",
            "Restonic Barbados",
            "Sealy Phuket"
        };
        // Stores sales in 2D ARRAY
        // 2D array: 3 products and 3 months
        int[][] sales = new int[3][3];

        // Variables for sales calculations
        int totalSales = 0;
        int highestSales = 0;
        String popularProduct = "";

        // Loop through each mattress
        for (int i = 0; i < products.length; i++) {

            // Loop through the three months
            for (int j = 0; j < 3; j++) {

                System.out.print(
                    "Enter number of sales for month "
                    + (j + 1) + " for "
                    + products[i] + " mattress: "
                );

                sales[i][j] = input.nextInt();

                // Add sales to the total
                totalSales += sales[i][j];

                // Identify highest monthly sales
                if (sales[i][j] > highestSales) {
                    highestSales = sales[i][j];
                    popularProduct = products[i];
                }
            }
        }

       // Create a Product object using the sales data.
// IMPORTANT: This assumes your Product class has
// a constructor accepting String[] and int[][].
Product product = new Product(products, sales);

// Print the report using the PrintProduct class.
PrintProduct.printReport(product);

// Close Scanner
input.close();