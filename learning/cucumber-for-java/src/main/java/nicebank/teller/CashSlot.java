package nicebank.teller;

/**
 * Created by Winiar on 29.05.2017.
 */
public class CashSlot {

    private int contents;

    public int getContents() {
        return contents;
    }

    public void dispense(int dollars) {
        contents = dollars;
    }
}
