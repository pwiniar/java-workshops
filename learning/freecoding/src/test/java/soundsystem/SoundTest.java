package soundsystem;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Pawel on 2017-04-12.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CDPlayerConfig.class)
public class SoundTest {

    @Autowired
    private CompactDisk cd;

    @Test
    public void name() throws Exception {
        Assertions.assertThat(cd).isNotNull();
        System.out.println(cd);

    }

    @Test
    public void name2()throws Exception {
        ApplicationContext apx = new AnnotationConfigApplicationContext(CDPlayerConfig.class);
        CompactDisk bean = apx.getBean(CompactDisk.class);
        Assertions.assertThat(bean).isNotNull();
        System.out.println(bean);
    }
}
