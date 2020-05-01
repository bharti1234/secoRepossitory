package step_definition;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Test_step 
{
	public static WebDriver driver;
	@Given("^Megha has registered into TestmeApp$")
	public void megha_has_registered_into_TestmeApp() throws Throwable 
	{
	    System.setProperty("WebDriver.chrome.driver", "C:\\Users\\hp\\Desktop\\test\\chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.get("https://lkmdemoaut.accenture.com/TestMeApp/fetchcat.htm");
	}

	@When("^Megha enters username as \"([^\"]*)\" and password as \"([^\"]*)\"$")
	public void megha_enters_username_as_and_password_as(String username, String password) throws Throwable 
	{
	   driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div/div/div[2]/div/ul/li[1]/a")).click();
		driver.findElement(By.name("userName")).sendKeys(username);
	    driver.findElement(By.name("password")).sendKeys(password);
	    driver.findElement(By.name("Login")).click();
	}

	@When("^user search for a particular product and enter product as \"([^\"]*)\"$")
	public void user_search_for_a_particular_product_and_enter_product_as(String name) throws Throwable 
	{
	   WebElement search = driver.findElement(By.id("myInput"));
	   Thread.sleep(5000);
	   Actions a = new Actions(driver);
	   a.keyDown(search, Keys.SHIFT).sendKeys(name).keyUp(Keys.SHIFT).build().perform();
	   Thread.sleep(5000);
	   a.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
	}

	@When("^try to proceed to payment without adding product into cart$")
	public void try_to_proceed_to_payment_without_adding_product_into_cart() throws Throwable 
	{
	    driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div/div/div/div[2]/center/a")).click();
	    driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div/div/div[2]/div/a[2]")).click();
	    WebElement qnt = driver.findElement(By.xpath("//*[@id=\"quantity_1\"]"));
	    qnt.clear();
	    driver.switchTo().alert().accept();
	}

	@Then("^TestmeApp doesn't display the cart icon$")
	public void testmeapp_doesn_t_display_the_cart_icon() throws Throwable 
	{
	   System.out.println("TestmeApp doesn't display the cart icon");
	   driver.close();
	}

}
