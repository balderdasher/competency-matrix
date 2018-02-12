package com.mrdios.competencymatrix.designpattern.patterns.behavioral.iterator;

/**
 * @author huxiong
 * @date 2017-02-17 15:59
 */
public class NameRepository<T> implements Container<T> {
    private Object[] datas;
    private int size;

    public NameRepository(int length) {
        datas = new Object[length];
    }

    public void add(T t) {
        if (size >= datas.length) {
            throw new IllegalStateException("The repository is already full.");
        }
        datas[size++] = t;
    }

    @Override
    public Iterator<T> getIterator() {
        return new NameIterator<>();
    }

    private class NameIterator<E> implements Iterator<E> {
        int index;

        @Override
        public boolean hasNext() {
            return index < datas.length;
        }

        @Override
        public E next() {
            if (this.hasNext()) {
                return (E) datas[index++];
            }
            return null;
        }
    }
}
