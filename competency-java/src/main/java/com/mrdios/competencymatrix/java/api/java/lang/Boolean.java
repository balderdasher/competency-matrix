package com.mrdios.competencymatrix.java.api.java.lang;

/**
 * @author huxiong
 * @date 2016-08-13 15:38
 */
public class Boolean {

    public static void main(String[] args) {
        Byte b = (byte) 120;
        System.out.println(Character.isLowerCase('b'));
        System.out.println((int) b);
        System.out.println(ByteCache.cache[120 + 128]);
        System.out.println(Byte.decode("-19"));
        System.out.println(java.lang.Boolean.class);
        ByteCache.print();
    }

    private static class ByteCache {
        private ByteCache() {
        }

        static final Byte cache[] = new Byte[-(-128) + 127 + 1];

        static {
            for (int i = 0; i < cache.length; i++)
                cache[i] = (byte) (i - 128);
        }

        static void print() {
            for (Byte aCache : cache) {
                System.out.println(aCache);
            }
        }
    }
}
