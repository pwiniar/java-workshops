package mocking;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InOrder;
import org.mockito.Mockito;

/**
 * Created by Pawel on 2017-02-07.
 */
public class Empl {

    private Employee spyEmp;
    private Employee employee;

    private enum Dev {
        DEVELOPER
    }

    public class Employee {
        private String firstName;
        private String lastName;
        private int age;
        private Dev engineerAware;

        public Employee(String firstName, String lastName, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.engineerAware = Dev.DEVELOPER;
        }

        public int getAge() {
            return age;
        }

        public String getFullName() {
            return getFirstName() + " " + getLastName();
        }

        public String getLastName() {
            return lastName;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }

    @Before
    public void buildSpy(){
        employee = new Employee("Joe", "Dupa", 12);
        spyEmp = Mockito.spy(employee);
    }

    @Test
    public void verifySpyEffectOnRealInstance() throws Exception {
        spyEmp.setAge(20);
        Assert.assertFalse(employee.getAge() == spyEmp.getAge());
    }

    @Test
    public void verifyEmployeeDetails() throws Exception {
        System.out.println("Full name:" + spyEmp.getFullName());
        System.out.println("Age:" + spyEmp.getAge());

        InOrder inOrder = Mockito.inOrder(spyEmp);
        System.out.println("Verify emp.getFullName() calls getFirstName() and then getLastName()");
        inOrder.verify(spyEmp).getFirstName();
        inOrder.verify(spyEmp).getLastName();

        System.out.println("Verify emp.getAge() is called");
        Mockito.verify(spyEmp).getAge();



    }

    @Test
    public void verifyWithoutSpyEffectOnRealInstance() throws Exception {
        Employee employeeMock = Mockito.mock(Employee.class);
        Mockito.when(employeeMock.getAge()).thenReturn(20);
        System.out.println(employeeMock.getAge());

        ArgumentCaptor<Integer> ageCaptor = ArgumentCaptor.forClass(Integer.class);

        Mockito.verify(employeeMock).getAge();
    }
}
