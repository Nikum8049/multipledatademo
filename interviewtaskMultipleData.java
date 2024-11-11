package com;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import util.DriverConnectJunit;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(Parameterized.class)
public class interviewtaskMultipleData {
    String cname;
    String cemail;
    String cmono;
    String cmessage;

    public interviewtaskMultipleData(String cname, String cemail, String cmono, String cmessage)
    {
        this.cname = cname;
        this.cemail = cemail;
        this.cmono = cmono;
        this.cmessage = cmessage;
    }
        static WebDriver driver;

    @BeforeClass
    public static void setup()
    {
        driver= DriverConnectJunit.connect("https://aviraltrendzpvtltd.com/it-company-in-surat/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
    }

    @Test
    public void contactdata()
    {
        WebElement name = driver.findElement(By.name("your-name"));
        WebElement email = driver.findElement(By.name("your-email"));
        WebElement mono = driver.findElement(By.name("your-number"));
        WebElement message = driver.findElement(By.name("your-message"));
        name.clear();
        name.sendKeys(cname);
        email.clear();
        email.sendKeys(cemail);
        mono.clear();
        mono.sendKeys(cmono);
        message.clear();
        message.sendKeys(cmessage);

        driver.findElement(By.xpath("//input[@type='submit' and @value='SUBMIT MESSAGE']")).click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.navigate().forward();

    }

    @Parameterized.Parameters
    public static List<Object[]> setData()
    {
        Object obj[][] =new Object[4][4];

        obj[0][0] = "Kamlesh";
        obj[0][1] = "kamlesh@gmail.com";
        obj[0][2] = "7865956324";
        obj[0][3] = "my name is KAMLESH";

        obj[1][0] = "rakesh";
        obj[1][1] = "rakesh@gmail.com";
        obj[1][2] = "4568942356";
        obj[1][3] = "my name is RAKESH";

        obj[2][0] = "amitabh";
        obj[2][1] = "amitabh@gmail.com";
        obj[2][2] = "9865751236";
        obj[2][3] = "my name is AMITABH";

        obj[3][0] = "sushant";
        obj[3][1] = "sushant@gmail.com";
        obj[3][2] = "6547896345";
        obj[3][3] = "my name is SUSHANT";

        return Arrays.asList(obj);
    }

}
