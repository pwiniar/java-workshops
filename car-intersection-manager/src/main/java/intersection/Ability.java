package intersection;

/**
 * Created by Pawel on 2016-12-04.
 */
public class Ability {

    private static final int DURATION = 5000;

    private long activatedAt = Long.MAX_VALUE;

    public void activate() {
        activatedAt = System.currentTimeMillis();
    }

    public boolean isActive() {
        long activeFor = System.currentTimeMillis() - activatedAt;

        return activeFor >= 0 && activeFor <= DURATION;
    }
}
