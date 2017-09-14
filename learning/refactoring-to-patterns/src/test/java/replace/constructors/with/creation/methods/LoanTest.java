package replace.constructors.with.creation.methods;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.Condition;
import org.assertj.core.description.TextDescription;
import org.junit.Test;

import java.time.Instant;
import java.util.Date;

/**
 * Created by Winiar on 27.08.2017.
 */
public class LoanTest {

    @Test
    public void createLoan1() throws Exception {
        Loan loan = new Loan(100, 1, Date.from(Instant.now()));

        Assertions.assertThat(loan)
                .as(new TextDescription("create loan 1"))
                .has(checkCommitment())
                .has(checkOutstanding())
        ;

    }

    private Condition<Loan> checkCommitment() {
        return new Condition<Loan>() {
            @Override
            public boolean matches(Loan loan) {
                return loan.getCommitment() != 0;
            }
        };
    }

    private Condition<Loan> checkOutstanding() {
        return new Condition<Loan>() {
            @Override
            public boolean matches(Loan loan) {
                return loan.getOutstanding() == 0.00;
            }
        };
    }

}
