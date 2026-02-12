package leetcode;

import java.util.Iterator;

public class PeekingIterator implements Iterator<Integer> {
    private final int []values;
    private int idx = 0;
    private int total = 0;
    public PeekingIterator(Iterator<Integer> iterator) {
        values = new int[1000];
        iterator.forEachRemaining(v -> values[idx++] = v);
        total = idx;
        idx = 0;
        // initialize any member here.
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return idx>= total ? null : values[idx];
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        return idx >= total ? null : values[idx++];
    }

    @Override
    public boolean hasNext() {
        return idx < total;
    }
}
