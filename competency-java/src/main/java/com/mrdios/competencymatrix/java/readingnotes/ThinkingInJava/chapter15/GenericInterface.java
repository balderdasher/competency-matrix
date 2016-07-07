package com.mrdios.competencymatrix.java.readingnotes.ThinkingInJava.chapter15;

import java.util.Iterator;
import java.util.Random;

/**
 * @author huxiong
 * @date 2016/07/07 16:33
 */
public class GenericInterface {

}

/**
 * 生产接口
 *
 * @param <T>
 */
interface Builder<T> {
    T next();
}

/**
 * 玩具
 */
class Toy {
    private static long counter = 0;
    private final long id = counter++;

    @Override
    public String toString() {
        return getClass().getSimpleName() + id;
    }
}

/**
 * 玩具狗
 */
class DogToy extends Toy {
}

/**
 * 玩具猫
 */
class CatToy extends Toy {
}

/**
 * 玩具熊
 */
class BearToy extends Toy {
}

/**
 * 玩具制造器
 */
class ToyBuilder implements Builder<Toy>, Iterable<Toy> {
    private Class[] types = {DogToy.class, CatToy.class, BearToy.class};
    private int size = 0;//for iteration
    private final Random rand = new Random(47);

    public ToyBuilder() {
    }

    public ToyBuilder(int size) {
        this.size = size;
    }

    @Override
    public Toy next() {
        try {
            // make a toy randomly
            return (Toy) types[rand.nextInt(types.length)].newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 自定义迭代器
     */
    class ToyIterator implements Iterator<Toy> {
        int count = size;

        @Override
        public boolean hasNext() {
            return count > 0;
        }

        @Override
        public Toy next() {
            count--;
            return ToyBuilder.this.next();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public Iterator<Toy> iterator() {
        return new ToyIterator();
    }

    public static void main(String[] args) {
        ToyBuilder tb = new ToyBuilder();
        for (int i = 0; i < 3; i++) {
            System.out.println(tb.next());
        }
        System.out.println("------------------------");
        for (Toy t : new ToyBuilder(3)) {
            System.out.println(t);
        }
    }
}
