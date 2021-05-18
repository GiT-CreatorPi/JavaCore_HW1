// Дисциплина: Java Core для тестировщиков
// Домашнее задание №1 "Класс Object"
// Студент: Алексей Пирогов
// Дата: 18.05.2021

// Задание 1. Создайте три класса Человек, Кот, Робот, которые не наследуются от одного класса.
// Эти классы должны бегать и прыгать (методы просто ввыводят информациб о действии в консоль).

// Задание 2. Создайте два класса: беговая дорожка и стена, при прохождении через которые, участники
// доложны выполнять соответсвующие действия (бежать или прыгать), результат выполнения печатается в консоль
// (успешно пробежал, не смог пробежать и т.д.)

// Задание 3. Создайте два массива: с участниками и препятствиями, и заставьте всех участников пройти
// этот набор препятствий

// Задание 4. У препятствий есть длина (для дорожки) или высота (для стены), а участников огранич5ения на бег и прыжки

// Задание 5 (*). Если участник не миог пройти одно из препятствий, то дальше по списку он препятствий не идёт

public class JavaCore_HomeworkApp {

    public static void main(String[] arg) {

        System.out.println("Java Core. Lesson №1.");
        System.out.println("=====================\n\n");
        System.out.println("Формирование полосы препятствий: ");
        // Формирование массива с полосой препятствий: объекты типа Track чередуются с объектами типа Wall
        Object TrackWithWall[] = new Object[11];    // Размерность будущей полосы препятствий
        for (int i = 0; i < TrackWithWall.length; i = i + 2) {
            if (i < 10) {
                if (i == 0) {
                    TrackWithWall[i] = new Track(15);   // формирование начала полосы препятствий
                } else {
                    TrackWithWall[i] = new Track();     // формирование отрезков полосы препятствий с произвольной длиной
                }
                TrackWithWall[i + 1] = new Barrier();      // каждый нечётный элемент будет препятсвием с какой-то высотой, определяемой произвольным образом
            } else {
                TrackWithWall[TrackWithWall.length - 1] = new Track(20); // формирование окончания полосы препятствий
                break;
            }
        }
        System.out.println("... полоса препятствий сформирована.\n\n");

        System.out.println("Подбор учатников для забега: ");
        Object Participants[] = {new Cat("Kitty", 12, "рыжий", 60, 100),
                                 new Human("Homo", 120, 400, 120),
                                 new Robot("Robo", 1, 240000, 200)};

        System.out.println("... участники определены. ");
        System.out.println("\n\n\nСтарт соревнований: запуск цикла с иллюстрацией прохождения полосы препятствий участниками соревнований:\n");
        // Цикл для бега по полосе препятствий:
        int TrackWithWallPenultimateElement = TrackWithWall.length - 1;
        for (int i = 0; i < TrackWithWall.length; i += 2) {
            if (i < (TrackWithWallPenultimateElement)){
                for (int j = 0; j < Participants.length; j++) {
                    switch (j){
                        case 0:
                            ((Cat)Participants[j]).run((Track)TrackWithWall[i]);
                            break;
                        case 1:
                            ((Human)Participants[j]).run((Track)TrackWithWall[i]);
                            break;
                        case 2:
                            ((Robot)Participants[j]).run((Track)TrackWithWall[i]);
                            break;
                    }
                }

                for (int j = 0; j < Participants.length; j++) {
                    switch (j){
                        case 0:
                            ((Cat)Participants[j]).jump((Barrier)TrackWithWall[i+1]);
                            break;
                        case 1:
                            ((Human)Participants[j]).jump((Barrier)TrackWithWall[i+1]);
                            break;
                        case 2:
                            ((Robot)Participants[j]).jump((Barrier)TrackWithWall[i+1]);
                            break;
                    }
                }
            } else {
                System.out.println("\n\nФинишная прямая ...");
                int nobodyFinished = 1;
                for (int j = 0; j < Participants.length; j++) {
                    switch (j){
                        case 0:
                            if(((Cat)Participants[j]).getTakePart() == false) nobodyFinished *= 1;
                            else nobodyFinished *= 0;
                            break;
                        case 1:
                            if(((Human)Participants[j]).getTakePart() == false) nobodyFinished *= 1;
                            else nobodyFinished *= 0;
                            break;
                        case 2:
                            if(((Robot)Participants[j]).getTakePart() == false) nobodyFinished *= 1;
                            else nobodyFinished *= 0;
                            break;
                    }
                }

                if (nobodyFinished == 1) {
                    System.out.println("До финишной прямой никто не дошёл...");
                } else {
                    for (int j = 0; j < Participants.length; j++) {
                        switch (j) {
                            case 0:
                                ((Cat)Participants[j]).run((Track)TrackWithWall[TrackWithWall.length - 1]);
                                break;
                            case 1:
                                ((Human)Participants[j]).run((Track)TrackWithWall[TrackWithWall.length - 1]);
                                break;
                            case 2:
                                ((Robot)Participants[j]).run((Track)TrackWithWall[TrackWithWall.length - 1]);
                                break;
                        }
                    }
                }
            }
        }
    }
}