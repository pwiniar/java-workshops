package day.ten;

import utils.Tools;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by Pawel on 2016-12-11.
 */
public class Main {


    public static void main(String[] args) throws IOException {
        String path = "advent-of-code-2016/src/main/java/day/ten/data/input";
        run(path);

    }

//    bot 119 gives low to bot 18 and high to bot 3

    public static void run(String path) throws IOException {

        BufferedReader br = Tools.readFileAsBuffer(path);
        String line;
        String a = "";
        try {
            while ((line = br.readLine()) != null) {
                String[] split = line.split(" ");
                if (line.contains("value")) {
//                    instructions.add(new Instruction(getValue(split, 5), getValue(split, 1)));
                } else {
                    int botId = Integer.parseInt(split[1]);
//                    Bot bot = bots.get(botId);
//                    if (bot == null) {
//                        bot = new Bot(botId);
//                    }
                    System.out.println(String.format("bot id: %s, low: %s, high: %s", botId, Integer.parseInt(split[6]),
                            Integer.parseInt(split[11])));
//
//                    bot.setAction(getValue(split, 6), getValue(split, 11));
//                    bots.put(botId, bot);
                }
            }


        } catch (
                IOException e)

        {
            e.printStackTrace();
        }
    }
}