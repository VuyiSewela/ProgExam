
/**
 * Product class
 * Implements IProduct and calculates mattress sales.
 */
public class Product implements IProduct {

    // Store product names and monthly sales
    private String[] productNames;
    private int[][] sales;

    /**
     * Constructor: receives product names and sales data.
     */
    public Product(String[] productNames, int[][] sales) {
        this.productNames = productNames;
        this.sales = sales;
    }

    /**
     * Calculates total sales across all products.
     */
    @Override
    public int GetTotalProductsSold() {

        int total = 0;

        // Loop through products
        for (int i = 0; i < sales.length; i++) {

            // Loop through months
            for (int j = 0; j < sales[i].length; j++) {

                total += sales[i][j];
            }
        }

        return total;
    }

    /**
     * Calculates the average monthly sales entry.
     */
    @Override
    public double GetAverageProductSold() {

        int total = GetTotalProductsSold();
        int count = 0;

        // Count all monthly sales entries
        for (int i = 0; i < sales.length; i++) {
            count += sales[i].length;
        }

        if (count == 0) {
            return 0;
        }

        return (double) total / count;
    }

    /**
     * Finds the most popular mattress based on
     * the highest total sales across three months.
     */
    @Override
    public String GetMostPopularProduct() {

        int highestTotal = -1;
        String popularProduct = "";

        // Check each mattress
        for (int i = 0; i < sales.length; i++) {

            int productTotal = 0;

            // Add the three monthly sales values
            for (int j = 0; j < sales[i].length; j++) {

                productTotal += sales[i][j];
            }

            // Compare product totals
            if (productTotal > highestTotal) {

                highestTotal = productTotal;
                popularProduct = productNames[i];
            }
        }

        return popularProduct;
    }
}