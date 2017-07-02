package business.entities.repositories;

import business.entities.Customer;
import business.util.CalendarUtil;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Winiar on 02.07.2017.
 */
public class FakeCustomerRepository implements CustomerRepository {

    private static final FakeCustomerRepository INSTANCE = new FakeCustomerRepository();
    private final Map<Integer, Customer> customersById;

    public static FakeCustomerRepository getInstance() {
        return INSTANCE;
    }

    private FakeCustomerRepository() {
        this.customersById = new LinkedHashMap<>();

        final Customer cust1 = new Customer();
        cust1.setId(1);
        cust1.setName("James Cucumber");
        cust1.setCustomerSince(CalendarUtil.calendarFor(2006, 4, 2, 13, 20));
        this.customersById.put(cust1.getId(), cust1);

        final Customer cust2 = new Customer();
        cust2.setId(2);
        cust2.setName("Anna Lettuce");
        cust2.setCustomerSince(CalendarUtil.calendarFor(2005, 1, 30, 17, 14));
        this.customersById.put(cust2.getId(), cust2);

        final Customer cust3 = new Customer();
        cust3.setId(3);
        cust3.setName("Boris Tomato");
        cust3.setCustomerSince(CalendarUtil.calendarFor(2008, 12, 2, 9, 53));
        this.customersById.put(cust3.getId(), cust3);

        final Customer cust4 = new Customer();
        cust4.setId(4);
        cust4.setName("Shannon Parsley");
        cust4.setCustomerSince(CalendarUtil.calendarFor(2009, 3, 24, 10, 45));
        this.customersById.put(cust4.getId(), cust4);

        final Customer cust5 = new Customer();
        cust5.setId(5);
        cust5.setName("Susan Cheddar");
        cust5.setCustomerSince(CalendarUtil.calendarFor(2007, 10, 1, 15, 02));
        this.customersById.put(cust5.getId(), cust5);

        final Customer cust6 = new Customer();
        cust6.setId(6);
        cust6.setName("George Garlic");
        cust6.setCustomerSince(CalendarUtil.calendarFor(2010, 5, 18, 20, 30));
        this.customersById.put(cust6.getId(), cust6);
    }

    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(this.customersById.values());
    }

    @Override
    public Customer findById(final Integer id) {
        return this.customersById.get(id);
    }
}
