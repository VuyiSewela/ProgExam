import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Q2.6 - Unit tests for ProductCalculations.
 * Tests VAT and total sale calculations.
 */
public class ProductCalculationsTest {

    /**
     * Unit Test 1:
     * Verify that VAT is calculated correctly.
     */
    @Test
    public void GetVat_WithValidData_ReturnsCorrectValue() {

        // Arrange: Create a product with price R3500
        ProductCalculations product =
            new ProductCalculations(3500);

        // Act: Calculate VAT
        double actualVat = product.GetVat();

        // Assert: 15% of R3500 = R525
        assertEquals(525.0, actualVat, 0.001);
    }

    /**
     * Unit Test 2:
     * Verify that total sale amount is correct.
     */
    @Test
    public void GetTotal_WithValidData_ReturnsCorrectValue() {

        // Arrange: Create a product with price R3500
        ProductCalculations product =
            new ProductCalculations(3500);

        // Act: Calculate total sale
        double actualTotal = product.GetTotal();

        // Assert: 3500 + 525 VAT + 175 commission
        assertEquals(4200.0, actualTotal, 0.001);
    }
}