package nicebank.teller;

import nicebank.account.Account;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.io.File;

/**
 * Created by Winiar on 04.06.2017.
 */
public class AtmUserTeller implements Teller {

    private final EventFiringWebDriver webDriver;

    public AtmUserTeller() {
        File file = new File("C:\\Users\\Winiar\\Documents\\pawel\\workspace\\chromedriver_win32\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        this.webDriver = new EventFiringWebDriver(
                new ChromeDriver());
    }

    @Override
    public void withdrawFrom(Account account, int dollars) {
        try {
            webDriver.get("http://localhost:8887");
            webDriver.findElement(By.id("Amount")).sendKeys(String.valueOf(dollars));
            webDriver.findElement(By.id("Withdraw")).click();
        } finally {
            webDriver.close();
        }
    }
}
