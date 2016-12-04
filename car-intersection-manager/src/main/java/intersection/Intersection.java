package intersection;

import manager.IntersectionManager;
import roads.CarLeftRoad;
import roads.CarRightRoad;
import roads.Road;

/**
 * Created by Pawel on 2016-12-01.
 */
public class Intersection {

    private CarLeftRoad carLeftRoad;
    private CarRightRoad carRightRoad;
    private IntersectionManager intersectionManager;

    public Intersection(IntersectionManager intersectionManager, Road... roads) {
        for (Road road : roads) {
            if (road instanceof CarLeftRoad) {
                this.carLeftRoad = (CarLeftRoad) road;
            }
            if (road instanceof CarRightRoad) {
                this.carRightRoad = (CarRightRoad) road;
            }
        }

        this.intersectionManager = intersectionManager;
    }

    public IntersectionManager getIntersectionManager() {
        return intersectionManager;
    }

    public CarLeftRoad getCarLeftRoad() {
        return carLeftRoad;
    }

    public void setCarLeftRoad(CarLeftRoad carLeftRoad) {
        this.carLeftRoad = carLeftRoad;
    }

    public CarRightRoad getCarRightRoad() {
        return carRightRoad;
    }

    public void setCarRightRoad(CarRightRoad carRightRoad) {
        this.carRightRoad = carRightRoad;
    }

    public void manage() {
        intersectionManager.manage(this);
    }

    public void changeLight() {
        intersectionManager.changeLight();
    }
}
