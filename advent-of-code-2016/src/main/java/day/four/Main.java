package day.four;

/**
 * Created by Pawel on 2016-12-16.
 */
public class Main {


    public static void main(String[] args) {
        String input = "aaaaa-bbb-z-y-x-123[abxyz]";

        String roomName = input.substring(0, input.indexOf("[") - 3).replace("-","");
        String sectorID = input.replaceAll("\\D+", "");
        String checksum = input.substring(input.indexOf("[") + 1, input.length() - 1);

        System.out.println(String.format("Room name %s, sectorId %s, checksum %s", roomName, sectorID, checksum));

    }

}
