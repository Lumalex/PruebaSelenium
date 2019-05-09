package pruebas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.*;
import java.util.regex.Pattern;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.Assert.fail;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.tools.ant.taskdefs.condition.Matches;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

public class Prueba {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	DesiredCapabilities cap = DesiredCapabilities.firefox();
	((DesiredCapabilities)cap).setBrowserName("firefox");
	//((DesiredCapabilities)cap).setPlatform(Platform.WINDOWS);
    driver = new RemoteWebDriver(new URL("http://192.168.95.68:4444/wd/hub"),cap);
    baseUrl = "https://www.katalon.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  /*@Test
  public void prueba1() throws Exception {
    driver.get("https://www.google.es/");
    TimeUnit.MILLISECONDS.sleep(300);
    driver.findElement(By.name("q")).click();
    driver.findElement(By.name("q")).clear();
    driver.findElement(By.name("q")).sendKeys("hola mundo");
    TimeUnit.MILLISECONDS.sleep(300);
    driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
    TimeUnit.MILLISECONDS.sleep(300);
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Colecciones'])[1]/following::div[9]")).click();
    TimeUnit.MILLISECONDS.sleep(300);
    driver.findElement(By.name("q")).clear();
    driver.findElement(By.name("q")).sendKeys("prueba");
    TimeUnit.MILLISECONDS.sleep(300);
    driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Resultados web'])[1]/following::h3[1]")).click();
    TimeUnit.SECONDS.sleep(10);
  }*/
  
  @Test
  public void prueba2() throws Exception {
    driver.get("https://www.google.es/");
    TimeUnit.MILLISECONDS.sleep(300);
    driver.findElement(By.name("q")).click();
    driver.findElement(By.name("q")).clear();
    driver.findElement(By.name("q")).sendKeys("hola mundo");
    TimeUnit.MILLISECONDS.sleep(300);
    driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Resultados web'])[1]/following::h3[1]")).click();
    TimeUnit.MILLISECONDS.sleep(300);
    driver.findElement(By.linkText("Русский")).click();
    TimeUnit.SECONDS.sleep(10);
  }
  
 /* @Test
  public void pruebaLogin() throws Exception {
    driver.get("https://www.aulavirtual.urjc.es/moodle/login/index.php");
    driver.findElement(By.id("username")).click();
    driver.findElement(By.id("username")).clear();
    driver.findElement(By.id("username")).sendKeys("a.sorokin");
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("Password");
    driver.findElement(By.id("login")).submit();
    driver.findElement(By.className("name")).click();
    driver.findElement(By.id("dropdown-1")).click();
    driver.findElement(By.linkText("Salir")).click();
  }*/

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}

