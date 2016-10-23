package workshop.java.intermediate.reflections;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.function.Consumer;

/**
 * <p>There are several restrictions on the parameters that may be
 * passed to {@code Proxy.getProxyClass}:
 * <p>
 * <ul>
 * <li>All of the {@code Class} objects in the
 * {@code interfaces} array must represent interfaces, not
 * classes or primitive types.
 * <p>
 * <li>No two elements in the {@code interfaces} array may
 * refer to identical {@code Class} objects.
 * <p>
 * <li>All of the interface types must be visible by name through the
 * specified class loader.  In other words, for class loader
 * {@code cl} and every interface {@code i}, the following
 * expression must be true:
 * <pre>
 *     Class.forName(i.getName(), false, cl) == i
 * </pre>
 * <p>
 * <li>All non-public interfaces must be in the same package;
 * otherwise, it would not be possible for the proxy class to
 * implement all of the interfaces, regardless of what package it is
 * defined in.
 * <p>
 * <li>For any set of member methods of the specified interfaces
 * that have the same signature:
 * <ul>
 * <li>If the return type of any of the methods is a primitive
 * type or void, then all of the methods must have that same
 * return type.
 * <li>Otherwise, one of the methods must have a return type that
 * is assignable to all of the return types of the rest of the
 * methods.
 * </ul>
 * <p>
 * <li>The resulting proxy class must not exceed any limits imposed
 * on classes by the virtual machine.  For example, the VM may limit
 * the number of interfaces that a class may implement to 65535; in
 * that case, the size of the {@code interfaces} array must not
 * exceed 65535.
 * </ul>
 */
public class ProxyTest {
    @Test
    public void testName() throws Exception {
        Consumer consumer = ProxyFactory.create(Consumer.class, (proxy, method, args) -> {
            System.out.println(Arrays.asList(args));
            return null;
        });

        consumer.accept("HI All");
    }
}


class ProxyFactory {

    public static <T> T create(Class<T> targetInterface, InvocationHandler invocationHandler) {
        if (targetInterface.isInterface()) {
            return targetInterface.cast(
                    Proxy.newProxyInstance(
                            Thread.currentThread().getContextClassLoader(),
                            new Class[]{targetInterface},
                            invocationHandler)
            );
        }
        throw new IllegalArgumentException("given class not an interface " + targetInterface.getName());
    }

    private ProxyFactory() {
    }
}
