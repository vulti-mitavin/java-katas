package ch.grassl.sortingballs;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Rack {

    private static final int RACK_SIZE = 60;

    private final boolean[] balls = new boolean[RACK_SIZE];

    public void add(int ball) {
        if (ball >= 0 && ball < RACK_SIZE) {
            if (!balls[ball]) {
                balls[ball] = true;
            } else {
                throw new IllegalStateException("Ball was already drawn.");
            }
        } else {
            throw new IllegalArgumentException("Ball not in range 0-59.");
        }
    }

    public Collection<Integer> getBalls() {
        List<Integer> sortedBalls = new LinkedList<>();
        for (int i = 0; i < RACK_SIZE; i++) {
            if (balls[i]) {
                sortedBalls.add(i);
            }
        }
        return sortedBalls;
    }
}
