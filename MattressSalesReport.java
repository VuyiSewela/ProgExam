import java.util.Scanner;

public class MattressSalesReport {
    public static void main(String[] args) {
        String[] products = {"Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"};
        int[][] sales = new int[products.length][3];
        try (Scanner input = new Scanner(System.in)) {
            for (int i = 0; i < products.length; i++) {
                for (int j = 0; j < sales[i].length; j++) {
                    System.out.print("Enter number of sales for month " + (j + 1)
                            + " for " + products[i] + " mattress: ");
                    sales[i][j] = input.nextInt();
                }
            }
        }
        Product product = new Product(products, sales);
        PrintProduct.printReport(product);
    }
}
