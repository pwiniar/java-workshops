package nicebank.teller;

import nicebank.account.Account;

/**
 * Created by Winiar on 29.05.2017.
 */
public class AutomatedTeller implements Teller {

    private final CashSlot cashSlot;

    public AutomatedTeller(CashSlot cashSlot) {
        this.cashSlot = cashSlot;
    }

    public void withdrawFrom(Account account, int dollars){
        account.debit(dollars);
        cashSlot.dispense(dollars);
    }

}
