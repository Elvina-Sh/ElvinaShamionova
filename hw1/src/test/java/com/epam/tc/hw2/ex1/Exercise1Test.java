package com.epam.tc.hw2.ex1;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.epam.tc.hw2.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class Exercise1Test extends BaseTest {
    private final String url = "https://jdi-testing.github.io/jdi-light/index.html";
    private List<String> leftMenuList = Arrays
            .asList("Home", "Contact form", "Service", "Metals & Colors", "Elements packs");
    private List<String> textUnderIcons = Arrays.asList(
            "To include good practices\nand ideas from successful\nEPAM project",
            "To be flexible and\ncustomizable",
            "To be multiplatform",
            "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…");

    @Test(groups = {"hw2"})
    public void ex1() {
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
        //5. Assert that there are 4 items on the header section are displayed and they have proper texts
        List<WebElement> headerMenuElements = webDriver.findElements(By.xpath("/html/body/header/div/nav/ul[1]/li"));
        for (int i = 0; i < headerMenuElements.size(); i++) {
            assertThat(headerMenuElements.get(i).isDisplayed()).isTrue();
            assertThat(headerMenuElements.get(i).getText()).isEqualToIgnoringCase(leftMenuList.get(i));
        }
        //6. Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> icons = webDriver.findElements(By.className("benefit-icon"));
        for (WebElement e : icons) {
            assertThat(e.isDisplayed()).isTrue();
        }
        //7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<WebElement> text = webDriver.findElements(By.className("benefit-txt"));
        for (int i = 0; i < text.size(); i++) {
            assertThat(text.get(i).isDisplayed()).isTrue();
            assertThat(text.get(i).getText()).isEqualTo(textUnderIcons.get(i));
        }
        //8. Assert that there is the iframe with “Frame Button” exist
        WebElement iframe = webDriver.findElement(By.xpath("//iframe[@id='frame']"));
        assertThat(webDriver.findElement(By.xpath("//iframe[@id='frame']")).isDisplayed()).isTrue();
        //9. Switch to the iframe and check that there is “Frame Button” in the iframe
        webDriver.switchTo().frame(iframe);
        assertThat(webDriver.findElement(By.xpath("//*[@id=\"frame-button\"]")).isDisplayed()).isTrue();
        //10. Switch to original window back
        webDriver.switchTo().defaultContent();
        //11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        List<WebElement> leftMenu = webDriver.findElements(By.xpath("//*[@id=\"mCSB_1_container\"]/ul/li/a"));
        for (int i = 0; i < leftMenu.size(); i++) {
            assertThat(leftMenu.get(i).getText()).isEqualTo(leftMenuList.get(i));
        }
    }
}
