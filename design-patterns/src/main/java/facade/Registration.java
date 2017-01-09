package facade;

/**
 * Created by Pawel on 2017-01-09.
 */
public class Registration {

    private Vehicle vehicle;

    public Registration(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void allocateLicensePlate() {
        System.out.println("License plate allocated");
    }

    public void allocateVehicleNumber() {
        System.out.println("Vehicle number allocated");
    }
}
