package nicebank.teller;

import nicebank.account.Account;

/**
 * Created by Winiar on 04.06.2017.
 */
public interface Teller {
    void withdrawFrom(Account account, int dollars);

}
