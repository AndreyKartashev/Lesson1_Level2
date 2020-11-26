package ru.geekbrains.lesson1_2.homework;

public class Human implements Members{
    private String name;
    private int age;
    private int maxRun;
    private double maxJump;

    public Human() {
        //
    }

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Human(String name, int age, int run, double jump) {
        this.name = name;
        this.age = age;
        this.maxRun = run;
        this.maxJump = jump;
    }

    @Override
    public boolean run(int runDistance) {
        System.out.println("\nЧеловек бежит.");
        if (getMaxRun() >= runDistance) {
            //System.out.println("Человек успешно пробежал дистанцию " + runDistance + " метров.");
            return true;
        } else {
            //System.out.println("Человек не пробежал заданную дистанцию в " + runDistance + " метров.");
            return false;
        }
    }

    @Override
    public boolean jump(double jumpHeight) {
        System.out.println("\nЧеловек прыгает.");
        if (getMaxJump() >= jumpHeight) {
            //System.out.println("Человек успешно перепрыгнул через стену высотой в " + jumpHeight + " метров.");
            return true;
        } else {
            //System.out.println("Человек не перепрыгнул через стену высотой в " + jumpHeight + " метров.");
            return false;
        }
    }

    public void setMaxRun(int maxRun) {
        this.maxRun = maxRun;
    }

    public void setMaxJump(double maxJump) {
        this.maxJump = maxJump;
    }

    public int getMaxRun() {
        return maxRun;
    }

    public double getMaxJump() {
        return maxJump;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}