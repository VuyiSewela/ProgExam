public class PrintProduct {
    public static void printReport(IProduct product) {
        System.out.println("PRODUCT SALES REPORT - 2026");
        System.out.println("************************************");
        System.out.println("TOTAL PRODUCT SALES: " + product.GetTotalProductsSold());
        System.out.printf("AVERAGE PRODUCT SALES: %.2f%n", product.GetAverageProductSold());
        System.out.println("MOST POPULAR PRODUCT: " + product.GetMostPopularProduct());
    }
}
