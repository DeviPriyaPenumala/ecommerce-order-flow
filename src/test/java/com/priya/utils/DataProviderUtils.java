package com.priya.utils;

import org.testng.annotations.DataProvider;

public class DataProviderUtils {

    @DataProvider(name = "loginData")
    public static Object[][] loginDataProvider() throws Exception {
        return ExcelUtils.getExcelData(
            System.getProperty("user.dir") + "/testData/LoginData.xlsx", 
            "Sheet1"
        );
    }
}

