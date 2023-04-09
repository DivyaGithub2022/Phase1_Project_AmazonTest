package test;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

		String searchText = "samsung mobile";

		TakesScreenshot tsobj = (TakesScreenshot) driver;
		File fileObj = tsobj.getScreenshotAs(OutputType.FILE);

		File screenshotObject = new File("image.png");
		FileUtils.copyFile(fileObj, screenshotObject);

		WebElement searchBar = driver.findElement(By.id("twotabsearchtextbox"));
		searchBar.click();

		searchBar.sendKeys(searchText);

		WebElement search = driver.findElement(By.id("nav-search-submit-button"));
		search.click();

		List<WebElement> searchProduct = driver.findElements(By.xpath("//div[@class='a-section']//h2//span"));
		List<WebElement> searchPrice = driver
				.findElements(By.xpath("//div[@class='a-section']//span[@class='a-price-whole']"));
		List<WebElement> symbol = driver
				.findElements(By.xpath("//div[@class='sg-row']//span[@class='a-price-symbol']"));
		System.out.println("Product count: " + searchProduct.size());
		System.out.println("Price count: " + searchPrice.size());

		for (int i = 0; i < searchProduct.size(); i++) {
			System.out.println("The product : " + searchProduct.get(i).getText());
			System.out.println("Price: " + symbol.get(i).getText() + searchPrice.get(i).getText());

		}

		driver.close();

	}

}
