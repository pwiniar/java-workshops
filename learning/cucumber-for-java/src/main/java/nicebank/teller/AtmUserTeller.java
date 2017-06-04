package nicebank.teller;

import nicebank.account.Account;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

/**
 * Created by Winiar on 04.06.2017.
 */
public class AtmUserTeller implements Teller {

    private final EventFiringWebDriver webDriver;

    public AtmUserTeller() {
        this.webDriver = new EventFiringWebDriver(
                new ChromeDriver());
    }

    @Override
    public void withdrawFrom(int dollars, Account account) {
        try {
            webDriver.get("http://localhost:9988");
            webDriver.findElement(By.id("Amount")).sendKeys(String.valueOf(dollars));
            webDriver.findElement(By.id("Withdraw")).click();
        } finally {
            webDriver.close();
        }
    }
}
