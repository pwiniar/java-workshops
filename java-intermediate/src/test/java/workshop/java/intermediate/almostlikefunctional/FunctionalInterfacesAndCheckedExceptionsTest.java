package workshop.java.intermediate.almostlikefunctional;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.function.Consumer;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

/**
 * Created by michal on 22.10.2016.
 */
public class FunctionalInterfacesAndCheckedExceptionsTest {

    @Test
    public void uncheckedException() throws Exception {
        Consumer<String> c = s -> {
            throw new RuntimeException("from lambda");
        };

        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() ->
                        c.accept("hi !")
                );
    }

    @FunctionalInterface
    public interface ThrowingConsumer<T> {
        void accept(T value) throws Throwable;
    }

    @Test
    public void checkedException() throws Throwable {
        ThrowingConsumer<String> c = s -> {
            throw new Exception("from lambda");
        };

        assertThatExceptionOfType(Exception.class)
                .isThrownBy(() ->
                        c.accept("hi !")
                );
    }
}
