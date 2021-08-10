package com.epam.tc.hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    static Calculator calculator;

    @BeforeTest(alwaysRun = true)
    public void beforeTest() {
        calculator = new Calculator();
    }

}
