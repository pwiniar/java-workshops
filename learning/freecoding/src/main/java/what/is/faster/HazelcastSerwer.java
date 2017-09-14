package what.is.faster;

import com.hazelcast.config.Config;
import com.hazelcast.core.HazelcastInstance;

import java.util.Map;
import java.util.Queue;

/**
 * Created by Winiar on 12.09.2017.
 */
public class HazelcastSerwer {

    private HazelcastInstance instance;

    public void start() {
        Config config = new Config("Pawels Instance");
        instance = com.hazelcast.core.Hazelcast.newHazelcastInstance(config);
    }

    public void stop() {
        instance.shutdown();
    }

    public void createMap() {
        Map<Integer, String> mapCustomers = instance.getMap("customers");
        mapCustomers.put(1, "Joe");
        mapCustomers.put(2, "Ali");
        mapCustomers.put(3, "Avi");
        mapCustomers.put(4, "Jolek");
        System.out.println("Map Size:" + mapCustomers.size());
    }

    public void createQueue() {
        Queue<String> queueCustomers = instance.getQueue("customers");
        queueCustomers.offer("Tom");
        queueCustomers.offer("Mary");
        queueCustomers.offer("Jane");
        System.out.println("Queue size: " + queueCustomers.size());
    }
}
