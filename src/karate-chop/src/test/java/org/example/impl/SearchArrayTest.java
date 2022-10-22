package org.example.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SearchArrayTest {

    @Test
    void findIntegerTestWithEmptyArray() {
        int[] array = {};
        int value = SearchArray.of(array).find(2);
        Assertions.assertEquals(-1, value);
    }

    @Test
    void findIntegerTestWithUnevenArray() {
        int[] array = {1, 2, 3, 4, 5};
        int value = SearchArray.of(array).find(1);
        Assertions.assertEquals(0, value);
    }

    @Test
    void findIntegerTestWithUnevenArray2() {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        int value = SearchArray.of(array).find(5);
        Assertions.assertEquals(4, value);
    }

    @Test
    void findIntegerTestWithEvenArray() {
        int[] array = {1, 2, 3, 4, 5, 6};
        int value = SearchArray.of(array).find(5);
        Assertions.assertEquals(4, value);
    }

    @Test
    void findIntegerTestWithEvenArray2() {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int value = SearchArray.of(array).find(10);
        Assertions.assertEquals(9, value);
    }

    @Test
    void findIntegerTestWithEvenArray3() {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int value = SearchArray.of(array).find(6);
        Assertions.assertEquals(5, value);
    }

    @Test
    void findIntegerTestWithEvenArray4() {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int value = SearchArray.of(array).find(0);
        Assertions.assertEquals(-1, value);
    }
}