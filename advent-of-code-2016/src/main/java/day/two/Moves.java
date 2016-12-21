package day.two;

/**
 * Created by Pawel on 2016-12-16.
 */
public enum Moves {
    U('U'), D('D'), L('L'), R('R');

    private char s;

    Moves(char s) {
        this.s = s;
    }

    public char getS() {
        return s;
    }
}
