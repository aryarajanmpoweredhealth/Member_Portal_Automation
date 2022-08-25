package StepDefinition;

import Usable_Function.Generic_function;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.xpath.operations.Or;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class Login_Forgot_Password_Positive_Scenario extends Generic_function {

    @When("Click on Forgot Button Link")
    public void click_on_forgot_button_link() throws IOException, InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath(OR_reader("forgots")));
        click("forgots");
    }
    @And("Enter Linked Phone number")
    public void enter_linked_phone_number() throws IOException, InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath(OR_reader("acc_link_phoneno"))).sendKeys(td_reader("phone_no"));

    }
    @And("Click on Send Otp Button")
    public void click_on_send_otp_button() throws IOException {
      WebElement sent = driver.findElement(By.xpath(OR_reader("send_otp")));
      sent.click();
    }

    @Then("Navigated to forgot password otp page")
    public void navigated_to_forgot_password_otp_page() throws IOException, InterruptedException {
        Thread.sleep(8000);
        str= driver.findElement(By.xpath(OR_reader("forgot_password_heading"))).getText();
        System.out.println(str);
        Assert.assertEquals(str,td_reader("forgot_password_heading"));
    }

    @And("Enter otp number")
    public void enter_otp_number() throws IOException, InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath(OR_reader("forgot_enter_otp"))).sendKeys(td_reader("forgot_enter_otp"));
    }

    @And("Click on Save Changes Button")
    public void click_on_save_changes_button() throws IOException {
        driver.findElement(By.xpath(OR_reader("sent_changes")));
        click("sent_changes");
    }

    @Then("Navigated to create new password page")
    public void navigated_to_create_new_password_page() throws InterruptedException, IOException {
        Thread.sleep(8000);
        str= driver.findElement(By.xpath(OR_reader("new_password_heading"))).getText();
        System.out.println(str);
        Assert.assertEquals(str,td_reader("new_password_heading"));
    }
    @And("Create new Password")
    public void create_new_password() throws IOException, InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath(OR_reader("new_password"))).sendKeys(td_reader("new_password"));
        driver.findElement(By.xpath(OR_reader("confirm_password"))).sendKeys(td_reader("confirm_password"));
    }

    @And("Click on Change Password Button")
    public void click_on_change_password_button() throws IOException {
        click("change_password");

    }



}
