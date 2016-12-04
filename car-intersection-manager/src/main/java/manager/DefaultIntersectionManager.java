package manager;

import intersection.Intersection;
import roads.Road;

/**
 * Created by Pawel on 2016-12-01.
 */
public class DefaultIntersectionManager implements IntersectionManager {

    Road.Light light = Road.Light.GREEN;

    @Override
    public void manage(Intersection intersection) {
        while (true) {
            if (Road.Light.GREEN.equals(light)) {
                System.out.println("Green light for left road, number of cars waiting: " + intersection.getCarLeftRoad().carsWaitingSize());
                for (int i = 0; i < intersection.getCarLeftRoad().carsWaitingSize(); i++) {
                    System.out.println("Going car:" + i);
                    intersection.getCarLeftRoad().getCars().remove(i);
                    getSleep();
                }
                System.out.println(intersection.getCarLeftRoad().getCars().size());
            } else {
                System.out.println("Green light for right road, number of cars waiting: " + intersection.getCarRightRoad().carsWaitingSize());
                for (int i = 0; i < intersection.getCarRightRoad().carsWaitingSize(); i++) {
                    System.out.println("Going car:" + i);
                    intersection.getCarRightRoad().getCars().remove(i);
                    getSleep();
                }
                System.out.println(intersection.getCarRightRoad().getCars().size());
            }
        }
    }

    private void getSleep() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void changeLight() {
        Road.Light temp = this.light;
        if (Road.Light.RED.equals(light)) {
            light = Road.Light.GREEN;
        } else if (Road.Light.GREEN.equals(light)) {
            light = Road.Light.RED;
        }
        System.out.println("Changing light was: " + temp + "is: " + light);
    }
}
