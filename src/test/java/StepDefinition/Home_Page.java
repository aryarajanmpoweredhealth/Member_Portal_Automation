package StepDefinition;

import Usable_Function.Generic_function;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.io.IOException;

public class Home_Page  extends Generic_function {

    @When("Click on login button")
    public void click_on_login_button() throws IOException, InterruptedException {
        browser_launch();
        driver.manage().window().maximize();
    }

    @And("Enter the valid credentials")
    public void enter_the_valid_credentials() throws IOException, InterruptedException {
            Thread.sleep(2000);
            driver.findElement(By.xpath(OR_reader( "email"))).sendKeys(td_reader("email"));
            driver.findElement(By.xpath(OR_reader("password"))).sendKeys(td_reader("password") );
            driver.findElement(By.xpath(OR_reader("login")));
            click("login");

    }

    @Then("Navigated to home page")
    public void navigated_to_home_page() throws IOException {
        boolean logo = driver.findElement(By.xpath(OR_reader("logo_home"))).isDisplayed();
        Assert.assertEquals(true,logo);
   }


}
