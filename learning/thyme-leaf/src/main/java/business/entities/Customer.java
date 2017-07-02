package business.entities;

import java.util.Calendar;

/**
 * Created by Winiar on 02.07.2017.
 */
public class Customer {

    private int id;
    private String name;
    private Calendar customerSince;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Calendar getCustomerSince() {
        return customerSince;
    }

    public void setCustomerSince(Calendar customerSince) {
        this.customerSince = customerSince;
    }
}
