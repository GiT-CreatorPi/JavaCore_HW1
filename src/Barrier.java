// Дисциплина: Java Core для тестировщиков
// Домашнее задание №1 "Класс Object"
// Студент: Алексей Пирогов
// Дата: 18.05.2021 18:45

public class Barrier {

    // Перечень атрибутов принадлежащих контексту класса:
    protected static int counterWall;   // счётчик количества объектов

    // Перечень атрибутов объекта:
    protected int numberWall;           // номер препятствия
    private int height;                 // высота препятствия

    // инициализатор static отвечает за зануление счётчика количества препятствий (стен)
    // вызывается при первом обращении к конструктору, создании первого объекта класса
    static {
        counterWall = 0;
    }

    // инициализатор отвечает за инкремент поля counterWall
    // вызывается при каждом образещении к конструктору, создании объекта класса
    {
        counterWall++;   // инкремент количества объектов
    }

    // Непараметризированный конструктор класса Wall, используется по умолчанию
    public Barrier() {
        setNumberWall(counterWall);
        int height = (int)(Math.random() * 100 + 30);   // высота препятствия от 30 до 150
        setHeight(height);
        System.out.println("Создан объект класса Wall: под номером " + getNumberWall() + " и высотой " + getHeight() + " см.");
    }

    // Параметризированный конструктор класса Wall
    public Barrier(int height) {
        if (height < 0) {
            System.out.println("Ошибка ввода данных, высота препятсвия не может быть отрицательной.");
        } else if (height == 0) {
            System.out.println("Ошибка ввода данных, высота препятсвия не может быть равна нулю.");
        } else {
            setNumberWall(counterWall); //
            setHeight(height);
            System.out.println("Создан объект класса Wall: под номером " + getNumberWall() + " и высотой " + getHeight() + " см.");
        }
    }

    // Набор методов для инициализации атрибута объектов класса
    // Метод для получения номера препятствия
    public int getNumberWall() {
        return numberWall;
    }

    // Метод для установки номера препятствия
    public void setNumberWall(int numberWall) {
        this.numberWall = numberWall;
    }

    // Метод для получения высоты препятствия
    public int getHeight() {
        return height;
    }

    // Метод для установки высоты препятствия
    public void setHeight(int height) {
        this.height = height;
    }
}

