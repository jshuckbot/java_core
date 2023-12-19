package ru.gb;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Corporation<Human> implements Iterable<Human> {
    Human[] workers;
    private final int n;
    
    public Corporation(Human[] workers) {
        this.workers = workers;
        this.n = workers.length;
    }

    @Override
    public Iterator iterator() {
        return new Iterator();
    }
    
    class Iterator implements java.util.Iterator<Human> {
        private int i = 0;
        

        @Override
        public boolean hasNext() {
            return (i < n && workers[i] != null); 
        }

        @Override
        public Human next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return workers[i++];
        }
    }
    
}
