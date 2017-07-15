package activeMq;

import com.jayway.awaitility.Awaitility;
import com.jayway.awaitility.Duration;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import javax.jms.TextMessage;
import java.util.List;

/**
 * Created by Winiar on 05.07.2017.
 */
public class ReceiverTest {

    @Test
    public void receiver() throws Exception {
        Sender sender = new Sender();
        sender.createTask();
        List<TextMessage> streamed = sender.getStreamed();

        Awaitility.waitAtMost(Duration.FIVE_SECONDS).until(
                () -> {
                    Assertions.assertThat(streamed.size()).isEqualTo(20);

                });
    }
}
