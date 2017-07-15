package watch;

import business.FakeProductRepository;

import java.io.IOException;
import java.nio.file.*;
import java.util.Properties;

/**
 * Created by Winiar on 02.07.2017.
 */
public class Spy {

    private static final String DIR = "C:\\Users\\Winiar\\Documents\\pawel\\workspace\\java-workshops\\learning\\freecoding\\src\\main\\java\\configuration\\";

    public void wathFile(){
        Properties properties = System.getProperties();
        properties.setProperty("json.con", DIR);

        Path path = FileSystems.getDefault().getPath(System.getProperty("json.con"));
        try (final WatchService watchService = FileSystems.getDefault().newWatchService()) {
            final WatchKey watchKey = path.register(watchService, StandardWatchEventKinds.ENTRY_MODIFY);
            while (true) {
                final WatchKey wk = watchService.take();
                for (WatchEvent<?> event : wk.pollEvents()) {
                    //we only register "ENTRY_MODIFY" so the context is always a Path.
                    final Path changed = (Path) event.context();
                    System.out.println(changed);
                    if (changed.endsWith("products.json")) {
                        FakeProductRepository.getInstance();
                        System.out.println("My file has changed");
                    }
                }
                // reset the key
                boolean valid = wk.reset();
                if (!valid) {
                    System.out.println("Key has been unregisterede");
                }
            }
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }

}
