//Дисциплина: Java Core
//Домашнее задание №1 "nameNameNameName"
//Студент: Алексей Пирогов
//Дата: 18.05.2021

public class Robot {

    // Перечень атрибутов принадлежащих контексту класса:
    protected static int counterObject;    // счётчик количества объектов

    // Перечень атрибутов объекта:
    private String name;                   // название
    private int age;                       // возраст в месяцах
    private int maxDistance;               // максимальная дистанция для бега
    private int remainsDistance;           // оставший запас сил для бега, потенциально возможное для бега расстояние
    private int maxHeight;                 // максимальная высота для прыжка
    private boolean takePart;              // статус принятия участи в забеге
    private int currentPalace;             // текущее место или место где остановился участник данного типа

    // инициализатор static отвечает за зануление счётчика количества домашних животных
    // вызывается при первом обращении к конструктору, создании первого объекта класса
    static {
        counterObject = 0;
    }

    // инициализатор отвечает за инкремент поля counterObject
    // вызывается при каждом образещении к конструктору, создании объекта класса
    {
        counterObject++;   // инкремент количества объектов
    }

    // Параметризированнй конструктор класса Cat
    Robot(String name, int age, int maxDistanceRun, int maxHeightJump) {
        // инициализация полей объекта
        this.name = name;
        this.age = age;
        this.maxDistance = maxDistanceRun;
        this.remainsDistance = maxDistanceRun;
        this.maxHeight = maxHeightJump;
        this.takePart = true;
        // вывод информации об объекте, а также инкремент количества объектов класса
        if (showObject()) {
            counterObject++;
        }
    }

    // Функция для вывода информации о созданном объекте в форматированном виде
    final public boolean showObject() {
        boolean result = false;
        System.out.println("Создан объект класса \"Robot\"... ");
        System.out.println("Характеристики объекта:" +
                "\n- кличка: " + getName() +
                "\n- возраст: " + getAge() + " мес., в годах - " + (getAge() / 12) +
                "\n- максимальное расстояние для бега: " + getMaxDistance() + " м." +
                "\n- максимальная высота для прыжка: " + getMaxHeight() + " см.\n");
        return true;
    }

    // Набор геттеров и сеттеров для ввода данных в поля соответсвующие атрибутам объекта
    // набор методов для работы с полем "name":
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age <= 0) {
            System.out.println("Введено некорректное значение возраста!");
        } else {
            this.age = age;
        }
    }

    // набор методов для работы с полем "maxDistance":
    public int getMaxDistance() {
        return maxDistance;
    }

    public void setMaxDistance(int maxDistance) {
        if (maxDistance <= 0) {
            System.out.println("Введено некорректное значение для максимальной дистации для бега!");
        } else {
            this.maxDistance = maxDistance;
        }
    }

    // набор методов для работы с полем "remainsDistance":
    public int getRemainsDistance() {
        return remainsDistance;
    }

    public void setRemainsDistance(int remainsDistance) {
        this.remainsDistance = remainsDistance;
    }

    // набор методов для работы с полем "maxHeight":
    public int getMaxHeight() {
        return maxHeight;
    }

    public void setMaxHeight(int maxHeight) {
        if (maxDistance <= 0) {
            System.out.println("Введено некорректное значение для максимальной высоты прыжка!");
        } else {
            this.maxHeight = maxHeight;
        }
    }

    // набор методов для работы с полем "takePart":
    public boolean getTakePart() {
        return takePart;
    }

    public void setTakePart(boolean takePart) {
        this.takePart = takePart;
    }

    // набор методов для работы с полем "currentPlace":
    public int getCurrentPalace() {
        return currentPalace;
    }

    public void setCurrentPalace(int currentPalace) {
        this.currentPalace = currentPalace;
    }

    // Набор методов для преодоления препятствий
    // метод для прыжка:
    final public void run(Track track) {
        if (this.getTakePart() == true) {
            if (track.getLengthTrack() > this.getMaxDistance()) {
                System.out.print("Участник \"" + this.getName() + "\" не может пробежать сектор № " + track.getNumberTrack() + ", длина сектора для бега "
                        + track.getLengthTrack() +  " м., что больше максимальной длины бега (" + this.getMaxDistance() + " м.). ");
                this.setTakePart(false);
                this.setCurrentPalace(track.getNumberTrack());
                System.out.println("Участник \"" + this.getName() + "\" выбыл из соревнований, остановился на отрезке № " + this.getCurrentPalace() + "...");
            } else {
                if ((this.getRemainsDistance() - track.getLengthTrack()) <= 0) {
                    System.out.println("Участник \"" + this.getName() + "\" выбыл из соревнований, остановился на отрезке № " + this.getCurrentPalace() + "...");
                    this.setTakePart(false);
                } else {
                    this.setRemainsDistance(this.getRemainsDistance() - track.getLengthTrack());
                    System.out.println("Участник \"" + this.getName() + "\" пробежал сектор № " + track.getNumberTrack() + " с длиной " + track.getLengthTrack() +
                            " м. Максимальная длина бега " + this.getMaxDistance() + " м., выносливости хватит чтобы пробежать ещё " + this.getRemainsDistance() + " м.");
                }
            }
        }
    }

    // метод для бега:
    final public void jump(Barrier barrier) {
        if (this.getTakePart() == true) {
            if (barrier.getHeight() > this.getMaxHeight()) {
                this.setTakePart(false);
                this.setCurrentPalace(barrier.getNumberWall());
                System.out.println("Участник \"" + this.getName() + "\" не может перепрыгнуть. Высота препятствия " + barrier.getHeight() + " см., а максимальная высота прыжка - " + this.getMaxHeight() + " см.");
                System.out.println("Участник \"" + this.getName() + "\" участник выбыл из соревнований... Остановился на отрезке №" + this.getCurrentPalace() + " где-то перед препятствием.");
            } else {
                System.out.println("Участник \"" + this.getName() + "\" перепрыгнул ... препятсвие высотой " + barrier.getHeight() +
                        " см., максимальная высота прыжка - " + this.getMaxHeight() + " см.");
                this.setCurrentPalace(barrier.getNumberWall() + 1);
            }
        }
    }

    // Метод класса для получения информации о всех созданных объектах класса
    public static int getCounterObject() {
        return counterObject;
    }
}
