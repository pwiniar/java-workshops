package roads;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Pawel on 2016-12-01.
 */
public class CarRightRoad implements Road {

    private List<Integer> cars = new LinkedList<>();

    public int carsWaitingSize() {
        return cars.size();
    }

    public List<Integer> getCars() {
        return cars;
    }

    public void setCars(List<Integer> cars) {
        this.cars = cars;
    }
}
