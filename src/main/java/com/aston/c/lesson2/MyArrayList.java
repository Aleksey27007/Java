package com.aston.c.lesson2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
/**
 * trimToSize() для удаления лишних пустых ячеек
 */

/**
 * Реализуем интерфейс MyList для нашего MyArrayList, чтобы реализовать методы,
 * находящиеся в MyList.
 */
public class MyArrayList<T> implements MyList<T> {
    /**
     * DEFAULT_CAPACITY стандартная ёмкость для созданного нами объекта MyArrayList - 10
     */
    private static final int DEFAULT_CAPACITY = 10;
    /**
     * Object[] elements массив элемментов, нужен для складывания в него элементы, тип Object т.к.
     * все типы наследуются от него и мы в таком случаем можем запихнуть сюда любой элемент с любым типом данных
     */
    private Object[] elements;
    /**
     * size количество элементов списка
     */
    private int size;

    /**
     * Первый конструктор класса, ничего не принимает,
     * создает новый массив со стандартной емкостью DEFAULT_CAPACITY ,
     * инициализирует size = 0
     */
    public MyArrayList() {
        this.elements = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    /**
     * Второй конструктор класса, принимает значение ёмкости списка,
     * 1 условие если ёмкость > 0, то создаёт новый список типа Object, с размером = capacity;
     * 2 условие если ёмкость == 0, то список остаётся не инициализорованным
     * 3 в остальных случаях недопстимое значение capacity
     * это нужно для проверки на не допустимые значения на вход, т.к. в таком случае могут быть ошибки с недопустимым
     * параметром
     */
    public MyArrayList(int capacity) {
        if (capacity > 0) {
            this.elements = new Object[capacity];
        } else if (capacity == 0) {
            this.elements = null;
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " +
                    capacity);
        }
    }

    /**
     * Третий конструктор класса, нужен в случаях, если у нас есть колекция и нам нужно копировать элементы из
     * сторонней коллекции в нашу MyArrayList, в таком случае создастся наша коллекция с данными из другой
     * Запись вида "? extends ..." или "? super ..." — называется wildcard или символом подстановки, с верхней границей
     * (extends) или с нижней границей (super). Collection<? extends T> может содержать объекты, класс которых является
     * Collection или наследуется от Collection
     */
    public MyArrayList(Collection<? extends T> collection) {
        /** Конвертируем коллецию из параметра в массив*/
        Object[] array = collection.toArray();
        /** Если массив получлся не пустой */
        if ((size = array.length) != 0) {
            /** Если классы и размер совпадают, то можно просто копировать таким образом элементы */
            if (collection.getClass() == ArrayList.class) {
                elements = array;
            } else {
                /** В противном случае инициализируется новый массив типа Object с нужным нам размером size */
                elements = Arrays.copyOf(array, size, Object[].class);
            }
            /** Если пустой, то и значений в нём не должно быть */
        } else {
            elements = null;
        }
    }

    /**
     * Обработка исключения при переполнении массива или index < 0 при отрицательных значениях
     */
    private void rangeCheckForAdd(int index) {
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException("Index " + index + "Out of size + " + size());
    }

    /**
     * Проверка ёмкости и обеспечение расширения массива на 50 (0.5) проц за каждый вызов метода
     * при условии заполненности массива
     */
    private void ensureCapacity() {
        if (size == elements.length) {
            int newCapacity = elements.length + (int) (elements.length * 0.5);
            elements = Arrays.copyOf(elements, newCapacity);
        }
    }

    /**
     * ensureCapacity() для добавления элемента в нашу коллекцию сперва нужно проверить сможет ли влезть
     * наш элемент в коллекцию, далее в нашем массиве берем последний элемент size и добавляем к нему ++
     * для указания на следующий элемент и замещаем его на element из параметра (T element)
     */
    @Override
    public boolean add(T element) {
        ensureCapacity();
        elements[size++] = element;
        return true;
    }

    /**
     * При добавлении элемента в определенное место, нужно проверить сперва на корректность index, поэтому
     * вызываем rangeCheckForAdd() и проверить заполненность ensureCapacity()
     * <p>
     * System.arraycopy(elements, index, elements, index + 1, size - index)
     * <p>
     * from - массив, который копируем
     * to - массив в которой копируем
     * fromIndex - индекс в массиве from начиная с которого берем элементы для копирования
     * toIndex - индекс в массиве to начиная с которого вставляем элементы
     * count - количество элементов которые берем из массива from и вставляем в массив to
     * Массив to должен иметь достаточный размер, чтобы в нем уместились все копируемые элементы.
     * <p>
     * Таким образом сделать легче, чем в ручную создавать 2 массива - 1 начало до index и второй от index и до конца
     * после чего их нужно будет в правильном порядке вставить в нужный нам массив
     */
    @Override
    public boolean add(int index, T element) {
        rangeCheckForAdd(index);
        ensureCapacity();

        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = element;
        return true;
    }

    /**
     * Получение по индексу, сперва проверяем на корректность значения index rangeCheckForAdd(index)
     * после возвращаем нужный элемент по индексу
     */
    @Override
    public T get(int index) {
        rangeCheckForAdd(index);
        return (T) elements[index];
    }

    /**
     * Удаление по индексу, сперва проверяем на корректность значения index rangeCheckForAdd(index)
     * <p>
     * numMoved - здесь вычисляется количество элементов, которые нужно переместить после удаляемого элемента,
     * это делается путем вычитания из общего размера (размер списка) индекса удаляемого элемента и 1
     * (так как мы считаем элементы с нуля)
     * <p>
     * Если numMoved больше нуля, это означает, что есть элементы, которые нужно переместить для заполнения
     * "дыры", образовашейся после удаления элемента, тут нам и понадобиться numMoved мы это количество элементов
     * копируем в наш массив.
     * <p>
     * После перемещения элементов размер списка уменьшается на 1 (--size), и последний элемент
     * устанавливается в null. Это делается для того, чтобы избежать утечки памяти - если ссылка на объект
     * не обнуляется, он будет оставаться в памяти
     */
    @Override
    public boolean remove(int index) {
        rangeCheckForAdd(index);
        int numMoved = size - index - 1;

        if (numMoved > 0) {
            System.arraycopy(elements, index + 1, elements, index, numMoved);
        }
        elements[--size] = null;
        return true;
    }

    /**
     * Очищает массив через цикл и перебор всех элементов с присваиванием значения - null.
     */
    @Override
    public boolean clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        return true;
    }

    /**
     * Метод является публичным интерфейсом для запуска сортировки, он принимает компаратор,
     * который определяет порядок сортировки.
     * Метод вызывает приватный метод quickSort, передавая ему начальный индекс (0) и
     * конечный индекс (size - 1) массива, а также компаратор
     */
    @Override
    public void sort(Comparator<T> comparator) {
        quickSort(0, size - 1, comparator);
    }

    /**
     * Этот метод реализует сам алгоритм быстрой сортировки. Разделяет массив на подмассивы и
     * сортирует их эелементы.
     * <p>
     * Если low меньше high, это означает, что в подмассие есть более одного элемента.
     * <p>
     * Метод вызывает partition, чтобы разделить массив на две части - элементы меньше или равные опорному
     * элементу (pivot) и элементы больше опорного.
     * <p>
     * Затем рекурсивно вызывает сам себя для двух полученных подмассивов -
     * от low до pivotIndex - 1 и от pivotIndex + 1 до high.
     */
    private void quickSort(int low, int high, Comparator<T> comparator) {
        if (low < high) {
            int pivotIndex = partition(low, high, comparator);
            quickSort(low, pivotIndex - 1, comparator);
            quickSort(pivotIndex + 1, high, comparator);
        }
    }

    /**
     * Метод разделяет массив на две части и возвращает индекс опорного элемента (pivotIndex)
     * после его размещения на правильной позиции.
     * <p>
     * Опорный элемент выбирается как последний элемент в текущем подмассиве (get(high))
     * <p>
     * Переменная i инициализируется как low - 1. Она будет использоваться для отслеживания позиции для
     * размещения элементов, меньших или равных опорному элементу.
     * <p>
     * Цикл проходит через все элементы от low до high - 1.
     * Если элемент меньше или равен опорному (comparator.compare(get(j), pivot) <= 0), то:
     * <p>
     * Элементы по индексам i и j меняются местами с помощью метода swap
     * <p>
     * После завершения цикла опорный элемент помещается на праильную позицию - он меняется местами с
     * элементом по индексу i + 1
     */
    private int partition(int low, int high, Comparator<T> comparator) {
        T pivot = get(high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (comparator.compare(get(j), pivot) <= 0) {
                i++;
                swap(i, j);
            }
        }
        swap(i + 1, high);
        return i + 1;
    }

    /**
     * Этот метод меняет местами два элемента в массиве.
     */
    private void swap(int i, int j) {
        Object temp = elements[i];
        elements[i] = elements[j];
        elements[j] = temp;
    }

    /**
     * Возвращает количество текущих элементов массива
     */
    public int size() {
        return size;
    }
}
