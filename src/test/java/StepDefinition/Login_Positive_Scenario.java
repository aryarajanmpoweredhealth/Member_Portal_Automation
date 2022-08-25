package StepDefinition;

import Usable_Function.Generic_function;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategy;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Login_Positive_Scenario extends Generic_function {

    @Given("Launch the chrome browser and naviaged to login page")
    public void launch_the_chrome_browser_and_naviaged_to_login_page() throws IOException, InterruptedException {
        browser_launch();
        driver.manage().window().maximize();
        Thread.sleep(2000);



    }
    @When("user enter valid credentials")
    public void user_enter_valid_credentials() throws IOException, InterruptedException {

            driver.findElement(By.xpath(OR_reader( "email"))).sendKeys(td_reader("email",0));
            Thread.sleep(1000);
            driver.findElement(By.xpath(OR_reader("password"))).sendKeys(td_reader("password",0));
            Thread.sleep(1000);
            driver.findElement(By.xpath(OR_reader("login")));
            click("login");
            Thread.sleep(2000);
            takeScreenShot("login");
            driver.close();


        }


    }




