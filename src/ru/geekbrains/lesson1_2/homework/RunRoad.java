package ru.geekbrains.lesson1_2.homework;

public class RunRoad implements Barriers{
    private int roadLength;

    public RunRoad(int length) {
        this.roadLength = length;
    }


    public int getRoadLength() {
        return roadLength;
    }

    @Override
    public double getWallHeight() {
        return 0;
    }

    public void setRoadLength(int roadLength) {
        this.roadLength = roadLength;
    }
}
