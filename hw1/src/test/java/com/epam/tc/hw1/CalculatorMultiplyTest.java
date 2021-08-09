package com.epam.tc.hw1;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorMultiplyTest {
    @DataProvider(name = "correct data for double")
    public static Object[][] correctDataForDouble() {
        return new Object[][]{{0.0, 1.0, 0.0}, {5.5, 2.0, 11.0}, {2.0, 2.0, 4.0}};
    }

    @DataProvider (name = "correct data for long")
    public static Object[][] correctDataForLong() {
        return new Object[][]{{2L, 0L, 0L}, {0L, 0L, 0L}, {7L, 1L, 7L}};
    }

    @Test(dataProvider = "correct data for double", groups = {"multiply and divide group"})
    public void multDoubleTest(double a, double b, double expected) {
        Calculator calculator = new Calculator();
        double result = calculator.mult(a, b);
        assertThat(result).as("Calculation was wrong").isEqualTo(expected);
    }

    @Test(dataProvider = "correct data for long", groups = {"multiply and divide group"})
    public void multLongTest(long a, long b, Object expected) {
        Calculator calculator = new Calculator();
        long result = calculator.mult(a, b);
        assertThat(result).as("Calculation was wrong").isEqualTo(expected);
    }
}
