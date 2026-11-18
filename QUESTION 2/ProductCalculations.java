
public class ProductCalculations implements IProductCalculations {

    private double price;

    // Constructor receives the mattress price
    public ProductCalculations(double price) {
        this.price = price;
    }

    // Calculate VAT at 15%
    @Override
    public double GetVat() {
        return price * 0.15;
    }

    // Calculate commission at 5%
    @Override
    public double GetCommission() {
        return price * 0.05;
    }

    // Total = price + VAT + commission
    @Override
    public double GetTotal() {
        return price + GetVat() + GetCommission();
    }
}