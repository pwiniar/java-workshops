package workshop.java.intermediate.concurrency;

import org.junit.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by michal on 21.10.2016.
 */
public class WrapperCollectionsTest {

    @Test // don't use that, go for java.util.concurrent.*
    public void synchronizedCollections() throws Exception {
        Collection<String> sourceCollection = new ArrayList<>();
        Set<String> sourceSet = new HashSet<>();
        List<String> sourceList = new ArrayList<>();
        Map<String, String> sourceMap = new HashMap<>();
        SortedSet<String> sourceSortedSet = new TreeSet<>();
        SortedMap<String,String> sourceSortedMap = new TreeMap<>();

        Collection<String> collection = Collections.synchronizedCollection(sourceCollection);
        Set<String> set = Collections.synchronizedSet(sourceSet);
        List<String> list = Collections.synchronizedList(sourceList);
        Map<String, String> map = Collections.synchronizedMap(sourceMap);
        SortedSet<String> sortedSet = Collections.synchronizedSortedSet(sourceSortedSet);
        SortedMap<String, String> sortedMap = Collections.synchronizedSortedMap(sourceSortedMap);
    }
}
