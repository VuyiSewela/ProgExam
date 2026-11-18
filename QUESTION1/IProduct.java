/**
 * IProduct interface
 * Defines the methods required for product sales.
 */
public interface IProduct {

    // Returns the total number of products sold
    int GetTotalProductsSold();

    // Returns the average number of products sold
    double GetAverageProductSold();

    // Returns the name of the most popular product
    String GetMostPopularProduct();

}
