package br.com.infnet.Ex03;

import br.com.infnet.BaseTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ContactUsFormTest extends BaseTest {

    @Test
    public void deveTestarContactUsForm() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        driver.navigate().to("https://demo.prestashop.com/#/en/front");

        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("framelive")));

        WebElement contactUs = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Contact us")));
        contactUs.click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loadingMessageWrapper")));

        WebElement selectForm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("id_contact")));
        Select select = new Select(selectForm);
        select.selectByVisibleText("Webmaster");

        WebElement emailForm = driver.findElement(By.id("email"));
        emailForm.clear();
        emailForm.sendKeys("teste@gmail.com");

        WebElement messageForm = driver.findElement(By.id("contactform-message"));
        messageForm.clear();
        messageForm.sendKeys("Actually not");

        WebElement btnSend = driver.findElement(By.cssSelector("input.btn.btn-primary"));
        btnSend.click();

        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.alert.alert-success li")));
        Thread.sleep(1000);
        assertThat(successMessage.getText(), containsString("successfully sent"));
    }
}
