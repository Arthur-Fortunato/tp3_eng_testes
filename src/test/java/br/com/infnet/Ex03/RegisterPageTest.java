package br.com.infnet.Ex03;

import br.com.infnet.BaseTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class RegisterPageTest extends BaseTest {
    @Test
    void deveRegistrarUsuario() throws InterruptedException {
        driver.navigate().to("https://practicetestautomation.com/practice-test-login/");
        WebElement inputUsername = driver.findElement(By.id("username"));
        WebElement inputPassword = driver.findElement(By.id("password"));
        WebElement buttonSubmit = driver.findElement(By.id("submit"));

        inputUsername.clear();
        inputUsername.sendKeys("student");
        inputPassword.clear();
        inputPassword.sendKeys("Password123");
        buttonSubmit.click();
        Thread.sleep(2000);
        assertThat(driver.getCurrentUrl(), containsString("logged-in-successfully"));
    }
}
