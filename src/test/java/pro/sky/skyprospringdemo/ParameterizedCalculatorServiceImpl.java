package pro.sky.skyprospringdemo;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ParameterizedCalculatorServiceImpl {

    private final CalculatorServiceImpl calculatorService = new CalculatorServiceImpl();

    @ParameterizedTest
    @MethodSource("paramsForAdd")
    public void addTest(Integer a, Integer b, Integer expected) {
        assertEquals(expected, calculatorService.add(a, b));
    }

    @ParameterizedTest
    @MethodSource("paramsForMinus")
    public void minusTest(Integer a, Integer b, Integer expected) {
        assertEquals(expected, calculatorService.minus(a, b));
    }

    @ParameterizedTest
    @MethodSource("paramsForMultiply")
    public void multiplyTest(Integer a, Integer b, Integer expected) {
        assertEquals(expected, calculatorService.multiply(a, b));
    }

    @ParameterizedTest
    @MethodSource("paramsForDivide")
    public void divideTest(Integer a, Integer b, Double expected) {
        if (b == 0) {
            DivideByZeroException thrown = assertThrows(DivideByZeroException.class, () -> calculatorService.divide(a, b));
            assertEquals("Делить на ноль нельзя!", thrown.getMessage());
        } else {
            assertEquals(expected, calculatorService.divide(a, b));
        }
    }

    public static Stream<Arguments> paramsForAdd() {
        return Stream.of(
                Arguments.of(3, 2, 5),
                Arguments.of(1, -1, 0),
                Arguments.of(0, -6, -6)
        );
    }

    public static Stream<Arguments> paramsForMinus() {
        return Stream.of(
                Arguments.of(3, 2, 1),
                Arguments.of(1, -1, 2),
                Arguments.of(0, -6, 6)
        );
    }

    public static Stream<Arguments> paramsForMultiply() {
        return Stream.of(
                Arguments.of(3, 2, 6),
                Arguments.of(1, -1, -1),
                Arguments.of(0, -6, 0)
        );
    }

    public static Stream<Arguments> paramsForDivide() {
        return Stream.of(
                Arguments.of(3, 2, 1.5),
                Arguments.of(1, -1, -1d),
                Arguments.of(0, -6, -0d),
                Arguments.of(5, 0, null)
        );
    }
}
