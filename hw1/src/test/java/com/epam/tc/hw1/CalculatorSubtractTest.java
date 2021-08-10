package com.epam.tc.hw1;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.testng.annotations.Test;

public class CalculatorSubtractTest extends BaseTest {

    @Test(dataProviderClass = DataProviders.class, dataProvider = "correct data for subtract double",
            groups = {"add and subtract group"})
    public void subtractDoubleTest(double a, double b, double expected) {
        double result = calculator.sub(a, b);
        assertThat(result).as("Calculation was wrong").isEqualTo(expected);
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "correct data for subtract long",
            groups = {"add and subtract group"})
    public void subtractLongTest(long a, long b, long expected) {
        long result = calculator.sub(a, b);
        assertThat(result).as("Calculation was wrong").isEqualTo(expected);
    }
}
