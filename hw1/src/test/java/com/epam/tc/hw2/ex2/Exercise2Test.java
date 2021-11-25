package com.epam.tc.hw2.ex2;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.epam.tc.hw2.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Exercise2Test extends BaseTest {
    private final String url = "https://jdi-testing.github.io/jdi-light/index.html";

    @Test(groups = {"hw2"})
    public void ex2() {
        //1. Open test site by URL
        webDriver.navigate().to(url);
        assertThat(webDriver.getCurrentUrl()).contains(url);
        //2. Assert Browser title
        assertThat(webDriver.getTitle()).isEqualTo("Home Page");
        //3. Perform login
        WebElement dropDown = webDriver.findElement(By.id("user-icon"));
        dropDown.click();
        WebElement login = webDriver.findElement(By.id("name"));
        login.sendKeys("Roman");
        WebElement password = webDriver.findElement(By.id("password"));
        password.sendKeys("Jdi1234");
        WebElement enter = webDriver.findElement(By.id("login-button"));
        enter.click();
        //4. Assert Username is loggined
        WebElement userName = webDriver.findElement(By.id("user-name"));
        assertThat(userName.isDisplayed()).isTrue();
        assertThat(userName.getText()).isEqualToIgnoringCase("Roman Iovlev");
        //5. Open through the header menu Service -> Different Elements Page
        WebElement serviceMenu = webDriver.findElement(By.xpath("//a[contains(text(),'Service')]"));
        serviceMenu.click();
        WebElement differentElements = webDriver.findElement(By.xpath("//a[contains(text(),'Different elements')]"));
        differentElements.click();
        //6. Select checkboxes
        webDriver.findElement(By.xpath("//label[text()[contains(.,'Water')]]")).click();
        webDriver.findElement(By.xpath("//label[text()[contains(.,'Wind')]]")).click();
        //7. Select radio
        webDriver.findElement(By.xpath("//label[text()[contains(.,'Selen')]]")).click();
        //8. Select in dropdown
        webDriver.findElement(By.xpath("//select")).click();
        webDriver.findElement(By.xpath("//option[text()='Yellow']")).click();
        /*9. Assert that:
        for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        for radio button there is a log row and value is corresponded to the status of radio button
        for dropdown there is a log row and value is corresponded to the selected value
         */
        assertThat(webDriver.findElement(By
                .xpath("//ul[@class='panel-body-list logs']/li[contains(text(),'Water: condition changed to true')]"))
                .isDisplayed()).isTrue();
        assertThat(webDriver.findElement(By
                .xpath("//ul[@class='panel-body-list logs']/li[contains(text(),'Wind: condition changed to true')]"))
                .isDisplayed()).isTrue();
        assertThat(webDriver.findElement(By
                .xpath("//ul[@class='panel-body-list logs']/li[contains(text(),'metal: value changed to  Selen')]"))
                .isDisplayed()).isTrue();
        assertThat(webDriver.findElement(By
                .xpath("//ul[@class='panel-body-list logs']/li[contains(text(),'Colors: value changed to Yellow')]"))
                .isDisplayed()).isTrue();
    }

}
