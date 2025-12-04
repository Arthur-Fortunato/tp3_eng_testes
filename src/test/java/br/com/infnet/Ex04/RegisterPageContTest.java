package br.com.infnet.Ex04;

import br.com.infnet.BaseTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class RegisterPageContTest extends BaseTest {
    @Test
    void deveRegistrarUsuarioValido() throws InterruptedException {
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

    @Test
    void deveTentarRegistrarUsuarioInvalido() throws InterruptedException {
        driver.navigate().to("https://practicetestautomation.com/practice-test-login/");
        WebElement inputUsername = driver.findElement(By.id("username"));
        WebElement inputPassword = driver.findElement(By.id("password"));
        WebElement buttonSubmit = driver.findElement(By.id("submit"));

        inputUsername.clear();
        inputUsername.sendKeys("incorrectUser");
        inputPassword.clear();
        inputPassword.sendKeys("Password123");
        buttonSubmit.click();

        WebElement errorMessage = driver.findElement(By.id("error"));
        Thread.sleep(2000);
        assertThat(errorMessage.getText(), containsString("invalid"));
    }

    @Test
    void deveTestarLogout() throws InterruptedException {
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

        WebElement buttonLogout = driver.findElement(By.linkText("Log out"));
        buttonLogout.click();
        assertThat(driver.getCurrentUrl(), containsString("practice-test-login"));

    }
}
