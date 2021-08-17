package com.epam.tc.hw1;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.testng.annotations.Test;

public class CalculatorDivideTest extends BaseTest {

    @Test(dataProviderClass = DataProviders.class, dataProvider = "correct data for divide double",
            groups = {"multiply and divide group"})
    public void divDoubleTest(double a, double b, double expected) {
        double result = calculator.div(a, b);
        assertThat(result).as("Calculation was wrong").isEqualTo(expected);
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "correct data for divide long",
            groups = {"multiply and divide group"})
    public void divLongTest(long a, long b, long expected) {
        long result = calculator.div(a, b);
        assertThat(result).as("Calculation was wrong").isEqualTo(expected);
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "invalid data for divide long",
            groups = {"multiply and divide group"})
    public void divLongTest(long a, long b, Class<? extends Exception> expected) {
        assertThatThrownBy(() -> calculator.div(a, b)).isInstanceOf(expected)
                .hasMessageContaining("Attempt to divide by zero");
    }
}
