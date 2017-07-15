package business;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.FileSystems;
import java.nio.file.WatchService;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Winiar on 02.07.2017.
 */
public class FakeProductRepository implements ProductRepository {

    private static final FakeProductRepository INSTANCE = new FakeProductRepository();
    private final Map<Integer, Product> productsById;
    private final JSONParser parser;
    private static final String PATH = "C:\\Users\\Winiar\\Documents\\pawel\\workspace\\java-workshops\\learning\\freecoding\\src\\main\\java\\configuration\\products.json";
    private WatchService watcher;

    private FakeProductRepository() {
        this.productsById = new LinkedHashMap<>();
        this.parser = new JSONParser();

        try {
            this.watcher = FileSystems.getDefault().newWatchService();
            Object parse = parser.parse(new FileReader(PATH));
            JSONArray json = (JSONArray) parse;

            for (Object aJson : json) {
                JSONObject element = (JSONObject) aJson;
                Product product = new Product(
                        ((Long) element.get("id")).intValue(),
                        (String) element.get("name"),
                        (boolean) element.get("availability"),
                        BigDecimal.valueOf((double) element.get("price")));
                productsById.put(product.getId(), product);
            }

        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
    }

    public static FakeProductRepository getInstance() {
        return INSTANCE;
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(this.productsById.values());
    }

    @Override
    public Product findById(final int id) {
        return this.productsById.get(id);
    }

    @Override
    public Product findByName(String name) {
        for (Product product : this.productsById.values()) {
            if (product.getName().equals(name)) {
                return product;
            }
        }

        return null;
    }

    @Override
    public Product findByPrice(double price) {
        for (Product product : this.productsById.values()) {
            if (product.getPrice().equals(BigDecimal.valueOf(price))) {
                return product;
            }
        }
        return null;
    }
}
