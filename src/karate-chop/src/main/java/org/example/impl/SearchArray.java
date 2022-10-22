package org.example.impl;

import java.util.Arrays;

public final class SearchArray {

    public static final int FIRST_INDEX = 0;

    private int[] array;
    private int middleIndex;
    private int middleValue;
    private int index = 0;

    private SearchArray(int[] array) {
        this.array = array;
    }

    public static SearchArray of(int[] array) {
        return new SearchArray(array);
    }

    public int find(int value) {
        if (array.length == 0) {
            return -1;
        }

        middleIndex = array.length / 2;
        middleValue = array[middleIndex];
        index += middleIndex;

        if (middleValue != value) {
            chopArray(value);
            index = find(value);
        }

        return index;
    }

    private void chopArray(int value) {
        if (middleValue < value) {
            array = getUpperHalfArray();
        } else {
            array = getLowerHalfArray();
            trackIndex();
        }
    }

    private void trackIndex() {
        index -= middleIndex;
    }

    private int[] getUpperHalfArray() {
        return Arrays.copyOfRange(this.array, middleIndex, array.length);
    }

    private int[] getLowerHalfArray() {
        return Arrays.copyOfRange(this.array, FIRST_INDEX, middleIndex);
    }
}
