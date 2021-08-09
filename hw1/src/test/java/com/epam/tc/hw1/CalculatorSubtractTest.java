package com.epam.tc.hw1;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorSubtractTest {
    @DataProvider(name = "correct data for double")
    public static Object[][] correctDataForDouble() {
        return new Object[][]{{2.0, 0.0, 2.0}, {-2.0, 2.0, -4.0}, {0.0, 0.0, 0.0}, {0.0, 1.0, -1.0}};
    }

    @DataProvider (name = "correct data for long")
    public static Object[][] correctDataForLong() {
        return new Object[][]{{2L, 0L, 2L}, {-2L, 3L, -5L}, {0L, 1L, -1L}};
    }

    @Test(dataProvider = "correct data for double", groups = {"add and subtract group"})
    public void subtractDoubleTest(double a, double b, double expected) {
        Calculator calculator = new Calculator();
        double result = calculator.sub(a, b);
        assertThat(result).as("Calculation was wrong").isEqualTo(expected);
    }

    @Test(dataProvider = "correct data for long", groups = {"add and subtract group"})
    public void subtractLongTest(long a, long b, long expected) {
        Calculator calculator = new Calculator();
        long result = calculator.sub(a, b);
        assertThat(result).as("Calculation was wrong").isEqualTo(expected);
    }
}
