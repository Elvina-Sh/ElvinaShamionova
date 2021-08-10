package com.epam.tc.hw1;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.testng.annotations.Test;

public class CalculatorAddTest extends BaseTest {

    @Test(dataProviderClass = DataProviders.class, dataProvider = "correct data for add double",
            groups = {"add and subtract group"})
    public void addDoubleTest(double a, double b, double expected) {
        double result = calculator.sum(a, b);
        assertThat(result).as("Calculation was wrong").isEqualTo(expected);
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "correct data for add long",
            groups = {"add and subtract group"})
    public void addLongTest(long a, long b, long expected) {
        long result = calculator.sum(a, b);
        assertThat(result).as("Calculation was wrong").isEqualTo(expected);
    }
}
