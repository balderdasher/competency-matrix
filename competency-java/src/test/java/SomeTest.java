import base.BaseTest;
import org.junit.Test;

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
}
