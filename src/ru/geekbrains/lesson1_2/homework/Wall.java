package ru.geekbrains.lesson1_2.homework;

public class Wall implements Barriers {
    private double wallHeight;

    public Wall(double height) {
        this.wallHeight = height;
    }

    public void setWallHeight(double wallHeight) {
        this.wallHeight = wallHeight;
    }

    @Override

    public int getRoadLength() {
        return 0;
    }

    public double getWallHeight() {
        return wallHeight;
    }
}
