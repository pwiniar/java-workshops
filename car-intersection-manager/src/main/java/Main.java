import fill.intersection.FillIntersection;
import intersection.Intersection;
import manager.DefaultIntersectionManager;
import roads.CarLeftRoad;
import roads.CarRightRoad;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pawel on 2016-12-01.
 */
public class Main {

    public static void main(String[] args) {

        List<Integer> leftInt = new ArrayList<>();
        List<Integer> rightInt = new ArrayList<>();

        FillIntersection fillIntersectionLeft = new FillIntersection(leftInt);
        fillIntersectionLeft.start();

        FillIntersection fillIntersectionRight = new FillIntersection(rightInt);
        fillIntersectionRight.start();

sleeper(5000);

        CarLeftRoad carLeftRoad = new CarLeftRoad();
        carLeftRoad.setCars(leftInt);
        CarRightRoad carRightRoad = new CarRightRoad();
        carRightRoad.setCars(rightInt);

        DefaultIntersectionManager defaultIntersectionManager = new DefaultIntersectionManager();
        Intersection intersection = new Intersection(defaultIntersectionManager, carLeftRoad, carRightRoad);

        intersection.manage();
        intersection.changeLight();
    }

    private static void sleeper(int milis) {
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
