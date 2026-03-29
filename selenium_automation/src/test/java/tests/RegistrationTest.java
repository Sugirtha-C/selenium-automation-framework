package tests;

import org.json.JSONObject;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.ExtentReports;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.DriverFactory;
import config.ConfigReader;
import pages.HomePage;
import pages.RegistrationPage;
import utils.JsonUtil;
import utils.ScreenshotUtil;
import utils.ExtentManager;

/*
 * RegistrationTest is a TestNG-based test class that validates user registration functionality.
 *
 * It demonstrates:
 * - Data-driven testing using JSON (via JsonUtil)
 * - Use of TestNG DataProvider for parameterization
 * - Browser configuration using ConfigReader
 * - Page Object Model (POM) usage for UI interactions
 * - Handling dropdowns (Date of Birth) using Select class
 * - Assertion for successful account creation
 * - Integration with Extent Reports for reporting
 * - Screenshot capture on test failure
 *
 * This class complements the BDD framework by showcasing TestNG-based execution.
 */

public class RegistrationTest {

    ExtentReports extent = ExtentManager.getInstance();
    ExtentTest test;

    @Test(dataProvider = "registrationData")
    public void registerUser(String name, String email, String password) {

        test = extent.createTest("Registration Test");

        DriverFactory.initDriver(ConfigReader.get("browser"));
        DriverFactory.getDriver().get(ConfigReader.get("url"));

        try {

            HomePage homePage = new HomePage();
            RegistrationPage regPage = new RegistrationPage();

            // 🔥 Get full JSON user (for remaining fields)
            JsonUtil json = new JsonUtil("src/test/resources/testdata/registration.json");
            JSONObject user = json.getUserByType("valid");

            // Page 1
            homePage.clickSignupLogin();
            regPage.enterName(name);
            regPage.enterEmail(email);
            regPage.clickSignupButton();

            // Page 2
            regPage.enterPassword(password);
            regPage.selectDOB("10", "5", "1995");

            regPage.enterfirstName(user.getString("firstName"));
            regPage.enterLastName(user.getString("lastName"));
            regPage.enteraddr1(user.getString("address"));
            regPage.enterCity(user.getString("city"));
            regPage.enterState(user.getString("state"));
            regPage.enterZipCode(user.getString("zip"));
            regPage.enterMobileNumber(user.getString("mobile"));

            regPage.clickCreateAccountBtn();

            // ✅ Assertion
            Assert.assertTrue(regPage.isAccountCreated(), "Registration failed");

            test.pass("Registration successful");

        } catch (Exception e) {

            String path = ScreenshotUtil.captureScreenshot("registration_failure");

            test.fail("Test Failed",
                    MediaEntityBuilder.createScreenCaptureFromPath(path).build());

            throw e;

        } finally {

            DriverFactory.quitDriver();
            extent.flush();
        }
    }

    @DataProvider(name = "registrationData")
    public Object[][] getData() {

        JsonUtil json = new JsonUtil("src/test/resources/testdata/registration.json");
        JSONObject user = json.getUserByType("valid");

        return new Object[][] {
                {
                        user.getString("name"),
                        "test" + System.currentTimeMillis() + "@mail.com", // dynamic email
                        user.getString("password")
                }
        };
    }
}