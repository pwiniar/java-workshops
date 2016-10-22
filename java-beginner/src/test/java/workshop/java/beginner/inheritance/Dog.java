package workshop.java.beginner.inheritance;

/**
 * Created by michal on 14.06.2016.
 */
public class Dog extends Pet {

    public Dog(String name) {
        super(name);
    }

    @Override
    public String makeSound() {
        return "Woof Woof";
    }

    @Override // here we override behaviour from java.lang.Object
    public String toString() {
        return "Dog named " + getName();
    }

    // @Override
    // public boolean equals(Object obj) {
    //     if (obj instanceof Dog) {
    //         Dog asDog = (Dog) obj;
    //         return getName().equals(asDog.getName());
    //     } else {
    //         return false;
    //     }
    // }
}
