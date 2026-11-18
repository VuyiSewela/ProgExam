public class PrintProduct {

    // Prints the mattress sales report.
    public static void printReport(IProduct product) {

        // Get results from the Product class.
        int total = product.GetTotalProductsSold();
        double average = product.GetAverageProductSold();
        String popular = product.GetMostPopularProduct();

        // Display the report.
        System.out.println("PRODUCT SALES REPORT - 2026");
        System.out.println("********************************");

        System.out.println("TOTAL PRODUCT SALES: " + total);

        System.out.printf(
            "AVERAGE PRODUCT SALES: %.2f%n", average
        );

        System.out.println(
            "MOST POPULAR PRODUCT: " + popular
        );
    }
}