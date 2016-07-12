package com.mrdios.competencymatrix.java.readingnotes.ThinkingInJava.chapter17;

import java.util.*;

/**
 * 理解hashCode(),用一对ArrayList实现的Map
 * Created by balderdasher on 2016/7/12.
 */
public class SlowMap<K,V> extends AbstractMap<K,V> {
    private List<K> keys = new ArrayList<>();
    private List<V> values = new ArrayList<>();

    @Override
    public V put(K key, V value) {
        V oldValue = get(key);
        if (!keys.contains(key)){
            keys.add(key);
            values.add(value);
        }else{
            values.set(keys.indexOf(key),value);
        }
        return oldValue;
    }

    @Override
    public V get(Object key) {
        if (!keys.contains(key)){
            return null;
        }
        return values.get(keys.indexOf(key));
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K,V>> set = new HashSet<>();
        Iterator<K> ki = keys.iterator();
        Iterator<V> vi = values.iterator();
        while (ki.hasNext()){
            set.add(new MapEntry<K, V>(ki.next(),vi.next()));
        }
        return set;
    }

    class MapEntry<K,V> implements Map.Entry<K,V>{
        private K key;
        private V value;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V v) {
            V result = v;
            value = v;
            return result;
        }

        @Override
        public int hashCode() {
            return (key == null ? 0 : key.hashCode())^
                    (value == null ? 0 : value.hashCode());
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof MapEntry)){
                return false;
            }
            MapEntry me = (MapEntry) obj;
            return (key == null?me.getKey() == null:key.equals(me.getKey()))
                    && (value == null?me.getValue() == null:value.equals(me.getValue()));
        }

        @Override
        public String toString() {
            return key + "=" + value;
        }
    }

    public static void main(String[] args) {
        SlowMap<String,String> map = new SlowMap<>();
        map.put("a","a");
        map.put("b","b");
        System.out.println(map);
    }
}
