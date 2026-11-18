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

        // Calculate the average across 9 sales entries
        double averageSales = (double) totalSales / 9;

        // Display the sales report
        System.out.println("\nPRODUCT SALES REPORT - 2026");
        System.out.println("************************************");
        System.out.println("TOTAL PRODUCT SALES: " + totalSales);
        System.out.printf(
            "AVERAGE PRODUCT SALES: %.2f%n",
            averageSales
        );
        System.out.println(
            "MOST POPULAR PRODUCT: "
            + popularProduct + "(" + highestSales + ")"
        );

        input.close();
    }
}
