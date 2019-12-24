import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Company {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/home/slavik/chromedriver");

        for (int w=0; w<=4; w++) {
            //String company_name = "Test Company " + getRandomNumberInRange(100,100000);
            String company_name = "Test wsswwqeez " + w;
            String state = "Louisiana";
            String city = "zzzzz" + w;

            WebDriver driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            driver.get("http://localhost:5000/join");

            driver.findElement(By.xpath("//div[@class='form-group radio_buttons required company_forms_company_info_create_form_hire_drivers as-radio-inline']//label[@class='collection_radio_buttons'][contains(text(),'No')]")).click();
            driver.findElement(By.xpath("//input[@id='company_forms_company_info_create_form_name']")).sendKeys(company_name);
            driver.findElement(By.xpath("//input[@id='company_forms_company_info_create_form_address_1']")).sendKeys("Address_1");
            driver.findElement(By.xpath("//input[@id='company_forms_company_info_create_form_city']")).sendKeys(city);

            driver.findElement(By.xpath("//input[@id='company_forms_company_info_create_form_zip_code']")).sendKeys("91234");

            driver.findElement(By.xpath("//span[contains(text(),'Please select...')]")).click();
            if (driver.findElement(By.xpath("//ul[@class='chosen-results']/li")).isDisplayed()) {
            } else {
                driver.findElement(By.xpath("//span[contains(text(),'Please select...')]")).click();
            }
            List<WebElement> options = driver.findElements(By.xpath("//ul[@class='chosen-results']/li"));
            for (WebElement opt : options) {
                if (opt.getText().equals(state)) {
                    opt.click();
                }
            }

            driver.findElement(By.xpath("//div[@class='col-xs-12 col-sm-12 col-md-12 actions']//input[@name='commit']")).click();

            ///////////

            Faker f = new Faker();
            String name = f.name().username();

            driver.findElement(By.xpath("//input[@id='company_forms_user_info_create_form_first_name']")).sendKeys("FirstName");
            driver.findElement(By.xpath("//input[@id='company_forms_user_info_create_form_last_name']")).sendKeys("LastName");
            driver.findElement(By.xpath("//input[@id='company_forms_user_info_create_form_email']")).sendKeys(name + "@gmail.com");
            driver.findElement(By.xpath("//input[@id='company_forms_user_info_create_form_email_confirmation']")).sendKeys(name + "@gmail.com");
            driver.findElement(By.xpath("//input[@id='company_forms_user_info_create_form_phone_number']")).sendKeys("9123123123");
            driver.findElement(By.xpath("//input[@id='company_forms_user_info_create_form_password']")).sendKeys("!123456");
            driver.findElement(By.xpath("//input[@id='company_forms_user_info_create_form_password_confirmation']")).sendKeys("!123456");

            driver.findElement(By.xpath("//input[@name='commit']")).click();

            ////

            driver.findElement(By.xpath("//input[@name='commit']")).click();

            ////

            driver.findElement(By.xpath("//li[4]//a[1]//div[1]")).click();

            ////////

            driver.findElement(By.xpath("//a[@class='btn start-trial btn-success']")).click();

            ////////
            WebDriverWait wait = new WebDriverWait(driver, 15);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-active mx-auto mt-4 mb-5']")));

            driver.findElement(By.xpath("//button[@class='btn btn-active mx-auto mt-4 mb-5']")).click();

            driver.quit();
        }

    }
}
