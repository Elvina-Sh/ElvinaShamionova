package com.epam.tc.hw1;

import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(name = "correct data for add double")
    public static Object[][] correctDataForAddDouble() {
        return new Object[][]{{2.0, 0.0, 2.0}, {-2.0, 2.0, 0}, {0.0, 0.0, 0.0}};
    }

    @DataProvider (name = "correct data for add long")
    public static Object[][] correctDataForAddLong() {
        return new Object[][]{{2L, 3L, 5L}, {0L, 7L, 7L}, {7L, 0L, 7L}};
    }

    @DataProvider(name = "correct data for divide double")
    public static Object[][] correctDataForDivDouble() {
        return new Object[][]{{0.0, 1.0, 0.0}, {5.0, 2.0, 2.5}, {2.0, 2.0, 1.0}};
    }

    @DataProvider (name = "correct data for divide long")
    public static Object[][] correctDataForDivLong() {
        return new Object[][]{{1L, 5L, 0L}, {5L, 2L, 2L}, {7L, 1L, 7L}};
    }

    @DataProvider (name = "invalid data for divide long")
    public static Object[][] invalidDataForDivLong() {
        return new Object[][]{{1L, 0L, NumberFormatException.class}, {0L, 0L, NumberFormatException.class}};
    }

    @DataProvider(name = "correct data for multiply double")
    public static Object[][] correctDataForMultDouble() {
        return new Object[][]{{0.0, 1.0, 0.0}, {5.5, 2.0, 11.0}, {2.0, 2.0, 4.0}};
    }

    @DataProvider (name = "correct data for multiply long")
    public static Object[][] correctDataForMultLong() {
        return new Object[][]{{2L, 0L, 0L}, {0L, 0L, 0L}, {7L, 1L, 7L}};
    }

    @DataProvider(name = "correct data for subtract double")
    public static Object[][] correctDataForSubDouble() {
        return new Object[][]{{2.0, 0.0, 2.0}, {-2.0, 2.0, -4.0}, {0.0, 0.0, 0.0}, {0.0, 1.0, -1.0}};
    }

    @DataProvider (name = "correct data for subtract long")
    public static Object[][] correctDataForSubLong() {
        return new Object[][]{{2L, 0L, 2L}, {-2L, 3L, -5L}, {0L, 1L, -1L}};
    }

}
