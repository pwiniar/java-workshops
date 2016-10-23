import java.util.Optional;

/**
 * Created by michal on 22.10.2016.
 */
public class OptionalFieldExample {

    private Optional<String> optionalValue = Optional.empty();

    public OptionalFieldExample(Optional<String> optionalValue) {
        this.optionalValue = optionalValue;
    }

    public Optional<String> getOptionalValue() {
        return optionalValue;
    }
}
