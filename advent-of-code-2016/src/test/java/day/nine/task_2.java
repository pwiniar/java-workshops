package day.nine;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by Pawel on 2016-12-11.
 */
public class task_2 {

    private boolean partTwo = true;

    @Test
    public void testInput_1() throws Exception {
        File file = new File(getClass().getClassLoader().getResource("day.nine/test-input-7").getFile());
        List<String> lines = Files.readAllLines(Paths.get(file.getPath()));
        long decompressed = FileDecompressor.solution(lines, partTwo);

        Assert.assertEquals(9, decompressed);
    }

    @Test
    public void testInput_2() throws Exception {
        File file = new File(getClass().getClassLoader().getResource("day.nine/test-input-8").getFile());
        List<String> lines = Files.readAllLines(Paths.get(file.getPath()));
        long decompressed = FileDecompressor.solution(lines, partTwo);

        Assert.assertEquals(20, decompressed);
    }

    @Test
    public void testInput_3() throws Exception {
        File file = new File(getClass().getClassLoader().getResource("day.nine/test-input-9").getFile());
        List<String> lines = Files.readAllLines(Paths.get(file.getPath()));
        long decompressed = FileDecompressor.solution(lines, partTwo);

        Assert.assertEquals(241920, decompressed);
    }

    @Test
    public void testInput_4() throws Exception {
        File file = new File(getClass().getClassLoader().getResource("day.nine/test-input-10").getFile());
        List<String> lines = Files.readAllLines(Paths.get(file.getPath()));
        long decompressed = FileDecompressor.solution(lines, partTwo);

        Assert.assertEquals(445, decompressed);
    }
}
