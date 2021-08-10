package com.epam.tc.hw1;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.testng.annotations.Test;

public class CalculatorMultiplyTest extends BaseTest {

    @Test(dataProviderClass = DataProviders.class, dataProvider = "correct data for multiply double",
            groups = {"multiply and divide group"})
    public void multDoubleTest(double a, double b, double expected) {
        double result = calculator.mult(a, b);
        assertThat(result).as("Calculation was wrong").isEqualTo(expected);
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "correct data for multiply long",
            groups = {"multiply and divide group"})
    public void multLongTest(long a, long b, Object expected) {
        long result = calculator.mult(a, b);
        assertThat(result).as("Calculation was wrong").isEqualTo(expected);
    }
}
