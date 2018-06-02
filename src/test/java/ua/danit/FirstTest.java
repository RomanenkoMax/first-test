package ua.danit;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class FirstTest {

    private static WebDriver driver;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "D:\\Install\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://mail.i.ua");
    }

    @Test
    public void userLogin(){
        WebElement loginField = driver.findElement(By.name("login"));
        loginField.sendKeys("kiev33");
        WebElement passwordField = driver.findElement(By.name("pass"));
        passwordField.sendKeys("max300879");
        WebElement loginButton = driver.findElement(By.xpath("/html/body/div[1]/div[5]/div[1]/div/div[3]/form/ul/li[2]/input"));
        loginButton.click();
        WebElement profileUser = driver.findElement(By.className("sn_menu_title"));
        String mailUser = profileUser.getText();
        Assert.assertEquals("kiev33@i.ua", mailUser);
        WebElement newLetter = driver.findElement(By.linkText("Создать письмо"));
        newLetter.click();
        WebElement toField = driver.findElement(By.id("to"));
        toField.sendKeys("romanenkomax.ua@gmail.com");
        WebElement subjectField = driver.findElement(By.xpath("/html/body/div[4]/div[5]/div[1]/div[1]/div[1]/div/form/div[5]/div[2]/span/input[1]"));
        subjectField.sendKeys("Test e-mail!");
        WebElement textField = driver.findElement(By.id("text"));
        textField.sendKeys("This is the text e-mail!!!");
        WebElement sendButton = driver.findElement(By.xpath("/html/body/div[4]/div[5]/div[1]/div[1]/p[3]/input[1]"));
        sendButton.click();

    }

    @AfterClass
    public static void tearDown() {
        WebElement menuUser = driver.findElement(By.className("ho_logo"));
        menuUser.click();
        WebElement logoutButton = driver.findElement(By.linkText("Выход"));
        logoutButton.click();
        driver.quit();
    }

}
