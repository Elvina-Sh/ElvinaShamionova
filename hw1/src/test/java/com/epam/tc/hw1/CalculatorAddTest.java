package com.epam.tc.hw1;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorAddTest {
    @DataProvider (name = "correct data for double")
    public static Object[][] correctDataForDouble() {
        return new Object[][]{{2.0, 0.0, 2.0}, {-2.0, 2.0, 0}, {0.0, 0.0, 0.0}};
    }

    @DataProvider (name = "correct data for long")
    public static Object[][] correctDataForLong() {
        return new Object[][]{{2L, 3L, 5L}, {0L, 7L, 7L}, {7L, 0L, 7L}};
    }

    @Test(dataProvider = "correct data for double", groups = {"add and subtract group"})
    public void addDoubleTest(double a, double b, double expected) {
        Calculator calculator = new Calculator();
        double result = calculator.sum(a, b);
        assertThat(result).as("Calculation was wrong").isEqualTo(expected);
    }

    @Test(dataProvider = "correct data for long", groups = {"add and subtract group"})
    public void addLongTest(long a, long b, long expected) {
        Calculator calculator = new Calculator();
        long result = calculator.sum(a, b);
        assertThat(result).as("Calculation was wrong").isEqualTo(expected);
    }
}
