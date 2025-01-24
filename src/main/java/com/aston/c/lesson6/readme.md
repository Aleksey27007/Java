----------------
### Исключения
### Иерархия исключений
### Способы обработки исключений
### try с ресурсами
### Ввод - вывод
### Какие основные классы используются для работы с потоками ввода - вывода
### Основные правила во время работы с потоками ввода - вывода.
### Сериализация

----------------

▎1. Исключения

Определение: Исключения — это события, которые происходят во время выполнения программы и нарушают нормальный поток выполнения. Они могут быть вызваны ошибками в коде или внешними факторами (например, отсутствием файла).

Типы исключений:

• Проверяемые исключения (Checked Exceptions): Исключения, которые должны быть обработаны или объявлены в сигнатуре метода (например, IOException, SQLException).

• Непроверяемые исключения (Unchecked Exceptions): Исключения, которые не требуют обязательной обработки (например, NullPointerException, ArrayIndexOutOfBoundsException).

▎2. Иерархия исключений

В Java все исключения наследуются от класса Throwable, который имеет два основных подкласса:

• Error: Ошибки, которые обычно не обрабатываются программой (например, OutOfMemoryError).

• Exception: Исключения, которые могут быть обработаны программой. Включает в себя проверяемые и непроверяемые исключения.

Пример иерархии:
![Exceptions](https://cdn.javarush.com/images/article/5c5a8939-dd12-4c70-aeda-00cb2909d340/1024.jpeg)


▎3. Способы обработки исключений

Обработка исключений в Java осуществляется с помощью блоков try, catch и finally.

Синтаксис:
>try {
> 
>// Код, который может вызвать исключение
> 
>} catch (ТипИсключения e) {
> 
>// Обработка исключения
> 
>} finally {
> 
>// Код, который выполняется всегда (опционально)
> 
>}


Пример:
>try {
> 
>int result = 10 / 0; // Генерирует ArithmeticException
> 
>} catch (ArithmeticException e) {
> 
>System.out.println("Деление на ноль!");
> 
>} finally {
> 
>System.out.println("Этот блок выполняется всегда.");
> 
>}


▎4. try с ресурсами

Определение: Блок try-with-resources позволяет автоматически закрывать ресурсы (например, потоки), которые реализуют интерфейс AutoCloseable.

Синтаксис:
>try (ResourceType resource = new ResourceType()) {
> 
>// Использование ресурса
> 
>} catch (Exception e) {
> 
>// Обработка исключений
> 
>}


Пример:
>try (BufferedReader br = new BufferedReader(new FileReader("file.txt"))) {
> 
>String line;
> 
>while ((line = br.readLine()) != null) {
> 
>System.out.println(line);
> 
>}
> 
>} catch (IOException e) {
> 
>System.out.println("Ошибка чтения файла.");
> 
>}


▎5. Ввод - вывод

Определение: Ввод-вывод (I/O) в Java — это процесс чтения данных из источников и записи данных в приемники.

▎6. Основные классы для работы с потоками ввода-вывода

• InputStream / OutputStream: Абстрактные классы для работы с байтовыми потоками.

• Reader / Writer: Абстрактные классы для работы с символьными потоками.

• FileInputStream / FileOutputStream: Чтение и запись данных из/в файл.

• BufferedReader / BufferedWriter: Буферизированный ввод/вывод для повышения производительности.

• PrintWriter: Удобный класс для записи текстовых данных.

▎7. Основные правила работы с потоками ввода-вывода

1. Закрывайте потоки: Всегда закрывайте потоки после использования, чтобы освободить ресурсы.

2. Используйте try-with-resources: Это упрощает управление ресурсами и предотвращает утечки.

3. Обрабатывайте исключения: Убедитесь, что вы обрабатываете возможные исключения при работе с I/O.

4. Используйте буферизацию: Для повышения производительности используйте буферизированные потоки.

▎8. Сериализация

Определение: Сериализация — это процесс преобразования объекта в последовательность байтов для сохранения его состояния или передачи по сети.

Классы и интерфейсы:

• Serializable: Маркерный интерфейс, который указывает, что объект может быть сериализован.

• ObjectOutputStream: Класс для записи объектов в поток.

• ObjectInputStream: Класс для чтения объектов из потока.

Пример сериализации:

    import java.io.*;
    
    class Person implements Serializable {
    private String name;
    
    private int age;
  
      public Person(String name, int age) {
          this.name = name;
          this.age = age;
      }
    }
  
    public class SerializationExample {
    public static void main(String[] args) {
    Person person = new Person("Alice", 30);
  
          // Сериализация
          try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("person.ser"))) {
              oos.writeObject(person);
          } catch (IOException e) {
              e.printStackTrace();
          }
  
          // Десериализация
          try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("person.ser"))) {
              Person deserializedPerson = (Person) ois.readObject();
              System.out.println("Объект десериализован.");
          } catch (IOException | ClassNotFoundException e) {
              e.printStackTrace();
          }
      }
    }


▎Заключение

Исключения и обработка ошибок являются важными аспектами разработки на Java. Понимание иерархии исключений, методов их обработки, а также основ ввода-вывода и сериализации поможет создавать более надежные и устойчивые приложения.