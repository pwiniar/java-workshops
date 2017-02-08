package worker;

/**
 * Created by Pawel on 2017-02-05.
 */
public class Worker {
    private String name;

    public Worker(String name) {
        this.name = name;
    }

    public void pay() {
        System.out.println("Paying " + name);
    }
}


class Employee extends Worker {
    private Timesheet[] timesheetss;

    public Employee(String name) {
        super(name);
    }

    public void attachTimesheet(Timesheet i) {

    }
}


