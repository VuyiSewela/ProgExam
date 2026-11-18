public class Product implements IProduct {
    private final String[] productNames;
    private final int[][] sales;

    public Product(String[] productNames, int[][] sales) {
        this.productNames = productNames;
        this.sales = sales;
    }

    @Override
    public int GetTotalProductsSold() {
        int total = 0;
        for (int[] productSales : sales) {
            for (int amount : productSales) total += amount;
        }
        return total;
    }

    @Override
    public double GetAverageProductSold() {
        int count = 0;
        for (int[] productSales : sales) count += productSales.length;
        return count == 0 ? 0 : (double) GetTotalProductsSold() / count;
    }

    @Override
    public String GetMostPopularProduct() {
        int highest = Integer.MIN_VALUE;
        String popular = "";
        for (int i = 0; i < sales.length; i++) {
            int total = 0;
            for (int value : sales[i]) total += value;
            if (total > highest) {
                highest = total;
                popular = productNames[i];
            }
        }
        return popular;
    }
}
