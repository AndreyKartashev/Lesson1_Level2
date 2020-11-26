//    Задания:
//    1. Создайте три класса Человек, Кот, Робот, которые не наследуются от одного класса.
//    Эти классы должны уметь бегать и прыгать (методы просто выводят информацию о действии в консоль).
//    2. Создайте два класса: беговая дорожка и стена, при прохождении через которые,
//    участники должны выполнять соответствующие действия (бежать или прыгать),
//    результат выполнения печатаем в консоль (успешно пробежал, не смог пробежать и т.д.).
//    3. Создайте два массива: с участниками и препятствиями, и заставьте всех участников
//    пройти этот набор препятствий.
//    4. * У препятствий есть длина (для дорожки) или высота (для стены),
//    а участников ограничения на бег и прыжки. Если участник не смог пройти одно из препятствий,
//    то дальше по списку препятствий он не идет.

package ru.geekbrains.lesson1_2.homework;

public class Main {
    public static final int sizeMembers = 10;
    public static final int sizeBarriers = 5;
    public static final int range1 = 3; // три типа объектов - участников движения
    public static final int range2 = 2; // два типа объектов - препятствий

    public static Members[] members = new Members[sizeMembers];
    public static Barriers[] barriers = new Barriers[sizeBarriers];

    public static void main(String[] args) {
        System.out.println("Задание к уроку 1, Java Уровень 2.");
        setArrays();
        System.out.println("Начало соревнований! У нас " + sizeMembers + " участников и " + sizeBarriers + " препятствий.");
        competitions();
        System.out.println("Конец соревнований!");
    } // метод main()

    // Участники проходят набор препятствий
    // run(getRoadLength()), если false (не пробежал), то выходим из
    // вложенного цикла по j - по препятствиям для данного участника.
    public static void competitions() {
        int distance;
        double height;
        for (int i = 0; i < sizeMembers; i++) {
            for (int j = 0; j < sizeBarriers; j++) {

                if ((members[i] instanceof Human) && (barriers[j] instanceof RunRoad)) {
                    distance = barriers[j].getRoadLength();
                    if (members[i].run(distance) == false) {
                        System.out.println("Человек " + ((Human) members[i]).getName() + " не пробежал дистанцию в " + distance + " метров.");
                        break;
                    } else {
                        System.out.println("Человек " + ((Human) members[i]).getName() + " пробежал дистанцию в " + distance + " метров.");
                    }

                } else if ((members[i] instanceof Human) && (barriers[j] instanceof Wall)) {
                    height = barriers[j].getWallHeight();
                    if (members[i].jump(height) == false) {
                        System.out.println("Человек " + ((Human) members[i]).getName() + " не перепрыгнул стену в " + height + " метра.");
                        break;
                    } else {
                        System.out.println("Человек " + ((Human) members[i]).getName() + " перепрыгнула стену в " + height + " метра.");
                    }
                } else if ((members[i] instanceof Cat) && (barriers[j] instanceof RunRoad)) {
                    distance = barriers[j].getRoadLength();
                    if (members[i].run(distance) == false) {
                        System.out.println("Кошка " + ((Cat) members[i]).getName() + " не пробежала дистанцию в " + distance + " метров.");
                        break;
                    } else {
                        System.out.println("Кошка " + ((Cat) members[i]).getName() + " пробежала дистанцию в " + distance + " метров.");
                    }
                } else if ((members[i] instanceof Cat) && (barriers[j] instanceof Wall)) {
                    height = barriers[j].getWallHeight();
                    if (members[i].jump(height) == false) {
                        System.out.println("Кошка " + ((Cat) members[i]).getName() + " не перепрыгнула стену в " + height + " метра.");
                        break;
                    } else {
                        System.out.println("Кошка " + ((Cat) members[i]).getName() + " перепрыгнула стену в " + height + " метра.");
                    }
                } else if ((members[i] instanceof Robot) && (barriers[j] instanceof RunRoad)) {
                    distance = barriers[j].getRoadLength();
                    if (members[i].run(distance) == false) {
                        System.out.println("Робот " + ((Robot) members[i]).getName() + " не пробежал дистанцию в " + distance + " метров.");
                        break;
                    } else {
                        System.out.println("Робот " + ((Robot) members[i]).getName() + " пробежал дистанцию в " + distance + " метров.");
                    }
                } else if ((members[i] instanceof Robot) && (barriers[j] instanceof Wall)) {
                    height = barriers[j].getWallHeight();
                    if (members[i].jump(height) == false) {
                        System.out.println("Робот " + ((Robot) members[i]).getName() + " не перепрыгнул стену в " + height + " метра.");
                        break;
                    } else {
                        System.out.println("Робот " + ((Robot) members[i]).getName() + " перепрыгнул стену в " + height + " метра.");
                    }
                }
            } // j по препятствиям
        } // i по участникам
    } // метод competitions()

    // Метод setArrays - заполнение 2-х массивов объектов типа Object различными
    // участниками и различными препятствиями, используя метод Math.Random()
    public static void setArrays() {
        int number;
        // Заполняем массив с участниками движения
        for (int i = 0; i < sizeMembers; i++) {
            number = (int) (Math.random() * range1);

            switch (number) {
                case 0: {
                    members[i] = new Human("Человек " + i, (int) (Math.random() * 80), (int) (Math.random() * 300), (double) (Math.random() * 3));
                    break;
                }
                case 1: {
                    members[i] = new Cat("Кошка " + i, (int) (Math.random() * 12), (int) (Math.random() * 100), (double) (Math.random() * 2));
                    break;
                }
                case 2: {
                    members[i] = new Robot("Робот  " + i, (int) (Math.random() * 100), (int) (Math.random() * 500), (double) (Math.random() * 3));
                    break;
                }
            }
        }

        // Заполняем массив с препятствиями
        for (int j = 0; j < sizeBarriers; j++) {
            number = (int) (Math.random() * range2);

            switch (number) {
                case 0: {
                    barriers[j] = new RunRoad((int) (Math.random() * 200));
                    break;
                }
                case 1: {
                    barriers[j] = new Wall((double) (Math.random() * 2.1));
                    break;
                }
            }
        }
    } // метод setArrays

} // класс