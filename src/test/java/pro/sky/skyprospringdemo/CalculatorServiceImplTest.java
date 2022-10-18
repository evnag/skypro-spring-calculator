package pro.sky.skyprospringdemo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class CalculatorServiceImplTest {
    private final CalculatorServiceImpl calculatorService = new CalculatorServiceImpl();

    @Test
    public void addTest() {
        int actual = calculatorService.add(3, 2);
        assertEquals(5, actual);

        actual = calculatorService.add(3, -2);
        assertEquals(1, actual);
    }

    @Test
    public void minusTest() {
        int actual = calculatorService.minus(3, 2);
        assertEquals(1, actual);

        actual = calculatorService.minus(3, -2);
        assertEquals(5, actual);
    }

    @Test
    public void multiplyTest() {
        int actual = calculatorService.multiply(3, 2);
        assertEquals(6, actual);

        actual = calculatorService.multiply(3, -2);
        assertEquals(-6, actual);
    }

    @Test
    public void dividePositiveTest() {
        double actual = calculatorService.divide(3, 2);
        assertEquals(1.5, actual);

        actual = calculatorService.divide(3, -2);
        assertEquals(-1.5, actual);
    }

    @Test
    @DisplayName("Division by zero should throw an DivideByZeroException")
    public void divideNegativeTest() {
        DivideByZeroException thrown = assertThrows(DivideByZeroException.class, () -> calculatorService.divide(1, 0));
        assertEquals("Делить на ноль нельзя!", thrown.getMessage());

        assertThrows(DivideByZeroException.class, () -> calculatorService.divide(0, 0));
        assertEquals("Делить на ноль нельзя!", thrown.getMessage());
    }
}
