
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.Select;
import com.gargoylesoftware.htmlunit.javascript.host.file.File;

public class WebTest {
	 public static WebDriver driver;
	  public static  WebElement h1element;
	  public static   String url ;
	  public static String helloWorldTxt;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();
  
  
    @Before
   public void setUp() throws Exception {
    driver = new HtmlUnitDriver(true);
    url = "http://apps.qa2qe.cognizant.e-box.co.in/WelcomeMessage/";
    driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
   }


  @Test
  public void testWeb() throws Exception {
	 
    driver.get(url);  
      h1element=driver.findElement(By.tagName("h1"));
      helloWorldTxt=h1element.getText();
    
  }
  

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
