package day.three.bad;

import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by Pawel on 2016-12-06.
 */
public class MainPart2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        TriangleParser parser = new TriangleParser();
        int count =0 ;
        Queue<String> lines = new LinkedBlockingQueue<>();

        System.out.println("Insert your testInput here: (After pasting it press enter, any letter and enter again)");
        while (in.hasNext("\\d+")) {
            lines.add(in.nextLine());
        }

        List<Triangle> triangles = parser.parseAllTrianglesVertically(lines);
        for(Triangle triangle: triangles){
            if(triangle.isPossible())
                count++;
        }

        System.out.println("Triangulos posibles: "+count);
    }
}
