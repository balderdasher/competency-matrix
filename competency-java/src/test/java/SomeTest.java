import base.BaseTest;
import org.junit.Test;
import sun.misc.VM;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author huxiong
 * @date 2017-03-28 9:56
 */
public class SomeTest extends BaseTest {

    @Test
    public void testMyList() {
        MyArrayList<Integer> myList = new MyArrayList<>(6);
        for (int i = 0; i < 5; i++) {
            myList.add(i + 1);
        }
        myList.add(6);
        myList.delete(2);
        myList.delete(2);
        myList.add(2, 3);
        myList.add(3, 4);
        System.out.println(myList);
    }

    public static class MyArrayList<E> {
        private Object[] elementData;
        private int size;
        private int len;

        public MyArrayList(int len) {
            this.elementData = new Object[len];
            this.len = len;
        }

        public boolean add(E e) {
            if (isFull()) {
                throw new IllegalStateException("the list if already full.");
            }
            elementData[size++] = e;
            return true;
        }

        public boolean isFull() {
            return size >= len;
        }

        public boolean add(int index, E e) {
            if (isFull()) {
                throw new IllegalStateException("the list if already full.");
            }
            for (int i = size; i >= index; i--) {
                elementData[i] = elementData[i - 1];
            }
            elementData[index] = e;
            size++;
            return true;
        }

        public boolean delete(int index) {
            for (int i = index; i < size - 1; i++) {
                elementData[i] = elementData[i + 1];
            }
            elementData[size - 1] = null;
            size--;
            return true;
        }

        public E get(int index) {
            return (E) elementData[index];
        }

        public int size() {
            return this.size;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder("mylist(" + this.size + "):: ");
            for (int i = 0; i < elementData.length; i++) {
                if (elementData[i] != null) {
                    if (i > 0) {
                        sb.append(",");
                    }
                    sb.append(elementData[i]);
                }
            }
            return sb.toString();
        }
    }

    public <T> T[] reverseArray(T[] t) {
        int lo = 0, hi = t.length - 1;
        int mid = lo + (hi - lo) / 2;
        for (int i = 0; i < mid; i++) {
            T temp = t[i];
            t[i] = t[hi - i];
            t[hi - i] = temp;

        }
        return t;
    }

    @Test
    public void testReverseArray() {
        Integer[] a = {1, 2, 3, 4, 5};
        a = reverseArray(a);
        System.out.println(Arrays.toString(a));
    }

    @Test
    public void testPrintArray() {
        int[][] a = {{1, 2}, {3, 4, 5}};
        for (int i = 0; i < a.length; i++) {
            int[] item = a[i];
            for (int j = 0; j < item.length; j++) {
                System.out.print(item[j] + "\t");
            }
            System.out.println();
        }
    }

    @Test
    public void testF() {
        List<String> strs = new ArrayList<>();
        strs.addAll(Arrays.asList("1", "2", "3"));
        List<String> temp = strs;
        strs = null;
        System.out.println(temp);
    }

    public static void main(String[] args) {
        System.out.println(VM.isBooted());
        String str = "hello world";
        System.out.println(str.hashCode());
    }
}
