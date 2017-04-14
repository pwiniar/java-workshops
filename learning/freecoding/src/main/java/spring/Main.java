package spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Created by Pawel on 2017-04-12.
 */
@Component
public class Main {

    @Autowired
    private Knight knight;

    public static void main(String[] args) {
//        ClassPathXmlApplicationContext classPathXmlApplicationContext =
//                new ClassPathXmlApplicationContext("knights.xml");
        Main main = new Main();
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(KnightConfiguration.class
        );


        main.run();

//        Knight knight = classPathXmlApplicationContext.getBean(Knight.class);
//        knight.embarkOnQuest();
//
//        classPathXmlApplicationContext.close();
    }

    public void run(){
        knight.embarkOnQuest();
    }


}
