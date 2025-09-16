package utils;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import utils.ExcelUtility;

/**
 * Utility class for providing test data to TestNG test methods.
 * This class contains data provider methods that supply data from
 * Excel files for different home loan calculation scenarios.
 */
public class DataProviderUtility {

    /**
     * Provides test data for home loan EMI calculations with tenure specified in years.
     * The data is read from an Excel file located at
     * src/test/resources/testdata/HomeLoanDataInYears.xlsx, 
     * sheet named Sheet1
     *.
     * @return a 2D array of objects containing test data for home loan EMI calculations with tenure in years
     * @throws IOException if there is an error reading the Excel file
     */
    @DataProvider(name="CalcEmiWithTenureAsYears")
    public static Object[][] getEmiCalcWithYears() throws IOException {
        String filepath = System.getProperty("user.dir") + "/src/test/resources/testdata/HomeLoanDataInYears.xlsx";
        String sheetName = "Sheet1";
        return ExcelUtility.getDataArray(filepath, sheetName);
    }

    /**
     * Provides test data for home loan EMI calculations with tenure specified in months.
     * The data is read from an Excel file located at
     * src/test/resources/testdata/HomeLoanDataInMonths.xlsx, 
     * sheet named Sheet1.
     *
     * @return a 2D array of objects containing test data for home loan EMI calculations with tenure in months
     * @throws IOException if there is an error reading the Excel file
     */
    @DataProvider(name="CalcEmiWithTenureAsMonths")
    public static Object[][] getEmiCalcWithMonths() throws IOException {
        String filepath = System.getProperty("user.dir") + "/src/test/resources/testdata/HomeLoanDataInMonths.xlsx";
        String sheetName = "Sheet1";
        return ExcelUtility.getDataArray(filepath, sheetName);
    }

    /**
     * Provides test data for home loan EMI calculations with various interest rates.
     * The data is read from an Excel file located at
     * src/test/resources/testdata/HomeLoanDataWithInterestRates.xlsx, 
     * sheet named Sheet1.
     *
     * @return a 2D array of objects containing test data for home loan EMI calculations with interest rates
     * @throws IOException if there is an error reading the Excel file
     */
    @DataProvider(name="CalcEmiWithInterestRate")
    public static Object[][] getEmiCalcWithInvalidInterest() throws IOException {
        String filepath = System.getProperty("user.dir") + "/src/test/resources/testdata/HomeLoanDataWithInterestRates.xlsx";
        String sheetName = "Sheet1";
        return ExcelUtility.getDataArray(filepath, sheetName);
    }
}
