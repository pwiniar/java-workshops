package chain.of.responsibility.one.main;

import chain.of.responsibility.one.request.PurchaseRequest;
import chain.of.responsibility.one.roles.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by Winiar on 27.08.2017.
 */
public class CheckAuthority {

    public static void main(String[] args) {
        PurchasePower manager = new ManagerPPower();
        PurchasePower director = new DirectorPPower();
        PurchasePower vp = new VicePresidentPPower();
        PurchasePower president = new PresidentPPower();

        manager.setSuccessor(director);
        director.setSuccessor(vp);
        vp.setSuccessor(president);

        // Press Ctrl+C to end.
        try {
            while (true) {
                System.out.println("Enter the amount to check who should approve your expenditure.");
                System.out.print(">");
                double d = Double.parseDouble(
                        new BufferedReader(new InputStreamReader(System.in)).readLine());
                manager.processRequest(new PurchaseRequest(d, "General"));
            }
        } catch (Exception exc) {
            System.exit(1);
        }
    }

}
