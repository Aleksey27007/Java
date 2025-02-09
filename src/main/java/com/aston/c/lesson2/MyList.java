package com.aston.c.lesson2;

import java.util.Comparator;

public interface MyList<T> {
    /** Это интерфейс, который мы реализуем в MyArrayList, нужен для поддержания удобной расширяймости */
    boolean add(T element);
    boolean add(int index, T element);
    T get(int index);
    boolean remove(int index);
    boolean clear();
    void sort(Comparator<T> comparator);
}
