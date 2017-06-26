package game;

import java.util.Scanner;

/**
 * Created by pawelwiniarski on 31/05/2017.
 */
public class Player {

        public static void main(String args[]) {
            Scanner in = new Scanner(System.in);

            // game loop
            while (true) {
                int max = 0;
                int imax = 0;
                for (int i = 0; i < 8; i++) {
                    int mountainH = in.nextInt();
                    // represents the height of one mountain, from 9 to 0. Mountain heights are provided from left to right.
                    if (mountainH > max) {
                        max = mountainH;
                        imax = i;
                    }
                }

                System.out.println(imax);
            }
        }
}
