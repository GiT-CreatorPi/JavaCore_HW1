// Дисциплина: Java Core для тестировщиков
// Домашнее задание №1 "Класс Object"
// Студент: Алексей Пирогов
// Дата: 18.05.2021 18:45

public class Track {

    // Перечень атрибутов принадлежащих контексту класса:
    protected static int counterTrack;   // счётчик количества объектов

    private int numberTrack;             // номер сектора
    private int lengthTrack;             // длана сектора

    // инициализатор static отвечает за зануление счётчика количества препятствий (стен)
    // вызывается при первом обращении к конструктору, создании первого объекта класса
    static {
        counterTrack = 0;
    }

    // инициализатор отвечает за инкремент поля counterObject
    // вызывается при каждом образещении к конструктору, создании объекта класса
    {
        counterTrack++;   // инкремент количества объектов
    }

    // Непараметризированный конструктор класса Wall, используется по умолчанию
    public Track() {
        setNumberTrack(counterTrack);
        int length = (int)(Math.random() * 150 + 10);   // высота препятствия от 10 до 150 м.
        setLengthTrack(length);
        System.out.println("Создан объект класса Track: под номером " + getNumberTrack() + ", длина трека - " + getLengthTrack() + " м.");

    }

    // Параметризированный конструктор класса Wall
    public Track(int length) {
        if (length < 0) {
            System.out.println("Ошибка ввода данных, длина препятсвия не может быть отрицательной.");
        } else if (length == 0) {
            System.out.println("Ошибка ввода данных, длина препятсвия не может быть равна нулю.");
        } else {
            setNumberTrack(counterTrack); //
            setLengthTrack(length);
            System.out.println("Создан объект класса Track: под номером " + getNumberTrack() + ", длина трека - " + getLengthTrack() + " м.");
        }
    }

    // Набор методов для инициализации атрибута объектов класса
    // Метод для получения номера дорожки
    public int getNumberTrack() {
        return numberTrack;
    }

    // Метод для получения номера дорожки
    public void setNumberTrack(int numberTrack) {
        this.numberTrack = numberTrack;
    }

    // Метод для получения высоты препятствия
    public int getLengthTrack() {
        return lengthTrack;
    }

    // Метод для получения высоты препятствия
    public void setLengthTrack(int lengthTrack) {
        this.lengthTrack = lengthTrack;
    }
}
