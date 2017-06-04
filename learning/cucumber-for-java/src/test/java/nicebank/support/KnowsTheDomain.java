package nicebank.support;

import nicebank.account.Account;
import nicebank.account.Owner;
import nicebank.teller.AtmUserTeller;
import nicebank.teller.AutomatedTeller;
import nicebank.teller.CashSlot;
import nicebank.teller.Teller;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.Objects;

/**
 * Created by Winiar on 29.05.2017.
 */
public class KnowsTheDomain {

    private Account account;
    private CashSlot cashSlot;
    private Teller teller;
    private Owner owner;
    private EventFiringWebDriver webDriver;

    public Account getAccount(Owner owner) {
        if (Objects.isNull(account)) {
            this.account = new Account(owner);
        }
        return this.account;
    }

    public CashSlot getCashSlot() {
        if (Objects.isNull(cashSlot)) {
            this.cashSlot = new CashSlot();
        }
        return this.cashSlot;
    }

    public Teller getAutomatedTeller() {
        if (Objects.isNull(teller)) {
            this.teller = new AutomatedTeller(getCashSlot());
        }
        return this.teller;
    }

    public Teller getAtmUserInterfaceTeller() {
        if (Objects.isNull(teller)) {
            this.teller = new AtmUserTeller();
        }
        return this.teller;
    }

    public Owner getOwner() {
        if (Objects.isNull(owner)) {
            this.owner = new Owner("TestName", "TestSurName");
        }
        return this.owner;
    }

    public EventFiringWebDriver getWebDriver() {
        if (webDriver == null){
            webDriver = new EventFiringWebDriver(new ChromeDriver());
        }
        return webDriver;
    }
}
