package facade;

/**
 * Created by Pawel on 2017-01-09.
 */
public class Vehicle extends AbstractVehicle {

    private final String carName;

    public Vehicle(String carName) {
        this.carName = carName;
    }

    public String getCarName() {
        return carName;
    }
}
