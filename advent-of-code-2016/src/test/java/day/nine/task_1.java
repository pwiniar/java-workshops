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
public class task_1 {

    private boolean partTwo = false;

    @Test
    public void testInput_1() throws Exception {
        File file = new File(getClass().getClassLoader().getResource("day.nine/test-input-1").getFile());
        List<String> lines = Files.readAllLines(Paths.get(file.getPath()));
        long decompressed = FileDecompressor.solution(lines, partTwo);

        Assert.assertEquals(7, decompressed);
    }

    @Test
    public void testInput_2() throws Exception {
        File file = new File(getClass().getClassLoader().getResource("day.nine/test-input-2").getFile());
        List<String> lines = Files.readAllLines(Paths.get(file.getPath()));
        long decompressed = FileDecompressor.solution(lines, partTwo);

        Assert.assertEquals(9, decompressed);
    }

    @Test
    public void testInput_3() throws Exception {
        File file = new File(getClass().getClassLoader().getResource("day.nine/test-input-3").getFile());
        List<String> lines = Files.readAllLines(Paths.get(file.getPath()));
        long decompressed = FileDecompressor.solution(lines, partTwo);

        Assert.assertEquals(6, decompressed);
    }

    @Test
    public void testInput_4() throws Exception {
        File file = new File(getClass().getClassLoader().getResource("day.nine/test-input-4").getFile());
        List<String> lines = Files.readAllLines(Paths.get(file.getPath()));
        long decompressed = FileDecompressor.solution(lines, partTwo);

        Assert.assertEquals(11, decompressed);
    }

    @Test
    public void testInput_5() throws Exception {
        File file = new File(getClass().getClassLoader().getResource("day.nine/test-input-5").getFile());
        List<String> lines = Files.readAllLines(Paths.get(file.getPath()));
        long decompressed = FileDecompressor.solution(lines, partTwo);

        Assert.assertEquals(6, decompressed);
    }

    @Test
    public void testInput_6() throws Exception {
        File file = new File(getClass().getClassLoader().getResource("day.nine/test-input-6").getFile());
        List<String> lines = Files.readAllLines(Paths.get(file.getPath()));
        long decompressed = FileDecompressor.solution(lines, partTwo);

        Assert.assertEquals(18, decompressed);
    }
}
