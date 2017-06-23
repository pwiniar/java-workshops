package bike.construction;

import bike.construction.components.Break;
import bike.construction.components.Frame;

/**
 * Created by Winiar on 21.06.2017.
 */
public class Main {

    public static void main(String[] args) {

        Bike mountainBike = new MountainBike();
        mountainBike.addBreak(new Break(Break.BreakType.DISCK_BRAKES)).addFrame(new Frame("amelinium"));
        mountainBike.changeCadence(10);
        mountainBike.speedUp(1);
        Main.printComponents(mountainBike);

        Bike roadBike = new RoadBike();
        roadBike.addBreak(new Break(Break.BreakType.VBREAK)).addFrame(new Frame("carbon"));
        roadBike.changeCadence(200);
        roadBike.speedUp(100);
        Main.printComponents(roadBike);
    }

    public static void printComponents(Bike bike) {
        System.out.println(bike.getClass().getName() + "" + bike.getBrake() + " " + bike.getFrame() +
                " " + bike.getGear() + " " + bike.getCadecne() + " " + bike.getSpeed());
    }


}
