package com.epam.tc.hw1;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorDivideTest {
    @DataProvider(name = "correct data for double")
    public static Object[][] correctDataForDouble() {
        return new Object[][]{{0.0, 1.0, 0.0}, {5.0, 2.0, 2.5}, {2.0, 2.0, 1.0}};
    }

    @DataProvider (name = "correct data for long")
    public static Object[][] correctDataForLong() {
        return new Object[][]{{1L, 5L, 0L}, {5L, 2L, 2L}, {7L, 1L, 7L}};
    }

    @DataProvider (name = "invalid data for long")
    public static Object[][] invalidDataForLong() {
        return new Object[][]{{1L, 0L, NumberFormatException.class}, {0L, 0L, NumberFormatException.class}};
    }

    @Test(dataProvider = "correct data for double", groups = {"multiply and divide group"})
    public void divDoubleTest(double a, double b, double expected) {
        Calculator calculator = new Calculator();
        double result = calculator.div(a, b);
        assertThat(result).as("Calculation was wrong").isEqualTo(expected);
    }

    @Test(dataProvider = "correct data for long", groups = {"multiply and divide group"})
    public void divLongTest(long a, long b, long expected) {
        Calculator calculator = new Calculator();
        long result = calculator.div(a, b);
        assertThat(result).as("Calculation was wrong").isEqualTo(expected);
    }

    @Test(dataProvider = "invalid data for long", groups = {"multiply and divide group"})
    public void divLongTest(long a, long b, Class<? extends Exception> expected) {
        Calculator calculator = new Calculator();
        assertThatThrownBy(() -> {
            calculator.div(a, b);
        }).isInstanceOf(expected)
                .hasMessageContaining("Attempt to divide by zero");
    }
}
