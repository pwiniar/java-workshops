package facade;

/**
 * Created by Pawel on 2017-01-09.
 */
public class Run {

    public static void main(String[] args) {

        VehicleFacade vehicleFacade = new VehicleFacade();
        vehicleFacade.prepareForSale(new Vehicle("Astra"));


    }

}
