package facade;

/**
 * Created by Pawel on 2017-01-09.
 */
public class VehicleFacade {

    public void prepareForSale(Vehicle vehicle) {
        Registration registration = new Registration(vehicle);
        registration.allocateLicensePlate();
        registration.allocateVehicleNumber();

        Documentation.printBroschure(vehicle);

        vehicle.cleanExteriorBody();
        vehicle.cleanInterior();
        vehicle.polishWindows();
        vehicle.takeForTestDrive();
    }
}
