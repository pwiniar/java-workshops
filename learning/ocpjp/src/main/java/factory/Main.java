package factory;


import com.sun.prism.impl.BaseMesh;

/**
 * Created by pawelwiniarski on 24/06/2017.
 */

abstract class AbstractFactory {
    private static final EmberToolkit EMBER_TOOLKIT = new EmberToolkit();
    private static final EnginolaToolkit ENGINOLA_TOOLKIT = new EnginolaToolkit();

    // Returns a concrete factory object that is an instance of the
    // concrete factory class appropriate for the given architecture.
    static AbstractFactory getFactory(Architecture architecture) {
        AbstractFactory factory = null;
        switch (architecture) {
            case ENGINOLA:
                factory = ENGINOLA_TOOLKIT;
            case EMBER:
                factory = EMBER_TOOLKIT;
        }
        return factory;
    }

    public abstract Cpu createCPU();

    public abstract MMU createMMU();
}

class EnginolaToolkit extends AbstractFactory {
    @Override
    public Cpu createCPU() {
        return new EnginolaCPU();
    }

    @Override
    public MMU createMMU() {
        return new EnginolaMMU();
    }
}

enum Architecture {
    ENGINOLA, EMBER
}

abstract class Cpu{

}

class EmberCpu extends Cpu {}

class EnginolaCPU extends Cpu {}

abstract class MMU {}

class EmberMMU extends MMU {}

class EnginolaMMU extends MMU {}

class EmberToolkit extends AbstractFactory {

    @Override
    public Cpu createCPU() {
        return new EmberCpu();
    }

    @Override
    public MMU createMMU() {
        return new EmberMMU();
    }
}



public class Main {
    public static void main(String[] args) {
        AbstractFactory factory = AbstractFactory.getFactory(Architecture.EMBER);
        Cpu cpu = factory.createCPU();

        AbstractFactory abstractFactory = AbstractFactory.getFactory(Architecture.ENGINOLA);
        abstractFactory.createCPU();

    }
}
