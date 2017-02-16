package rx;

import org.junit.Test;
import rx.observers.TestSubscriber;

import java.util.List;

import static java.util.Arrays.asList;

/**
 * Created by Pawel on 2017-02-09.
 */
public class AppTest {

    @Test
    public void name() throws Exception {
        List<App.Calc> calcs = asList(new App.Calc(10, 2), new App.Calc(11, 3), new App.Calc(100, 2));
        Observable<App.Calc> observable = Observable.from(calcs);
        TestSubscriber<App.Calc> testSubscriber = new TestSubscriber<>();

        observable.subscribe(testSubscriber);

        testSubscriber.assertValueCount(3);
        testSubscriber.assertCompleted();
        testSubscriber.assertReceivedOnNext(calcs);
        List<App.Calc> onNextEvents = testSubscriber.getOnNextEvents();
        onNextEvents.forEach(System.out::println);
    }
}
