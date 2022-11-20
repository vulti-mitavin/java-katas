package ch.grassl.sortingballs;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class RackTest {

    @Test
    void testAddBall() {
        Rack rack = new Rack();
        rack.add(25);
        assertEquals(Collections.singletonList(25), rack.getBalls());
    }

    @Test
    void testAddBalls() {
        Rack rack = new Rack();
        rack.add(25);
        rack.add(1);
        rack.add(10);
        rack.add(5);
        rack.add(20);
        rack.add(59);
        rack.add(0);
        rack.add(2);
        assertEquals(Arrays.asList(0, 1, 2, 5, 10, 20, 25, 59), rack.getBalls());
    }

    @Test
    void testAddBallWhenIllegalRangeThenThrowExcetion() {
        Rack rack = new Rack();
        assertThrows(IllegalArgumentException.class, () -> rack.add(153));
    }

    @Test
    void testAddBallWhenBallAlreadyTakenThenThrowExcetion() {
        Rack rack = new Rack();
        rack.add(50);
        assertThrows(IllegalStateException.class, () -> rack.add(50));
    }
}