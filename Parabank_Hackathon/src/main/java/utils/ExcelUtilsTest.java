package utils;

import java.io.IOException;
import java.util.Arrays;

public class ExcelUtilsTest {

    public static void main(String[] args) {
        // Define the path to your Excel file and the sheet name
        String filepath = "src/main/resources/Transferfunds.xlsx"; // Adjust the path as necessary
        String sheetName = "Sheet2";

        try {
            // Call the getDataArray method to retrieve data from the Excel file
            Object[][] data = ExcelUtils.getDataArray(filepath, sheetName);

            // Print the retrieved data to the console
            System.out.println("Retrieved Data from Excel:");
            for (Object[] row : data) {
                System.out.println(Arrays.toString(row));
            }
        } catch (IOException e) {
            System.err.println("Error reading the Excel file: " + e.getMessage());
        }
    }
}