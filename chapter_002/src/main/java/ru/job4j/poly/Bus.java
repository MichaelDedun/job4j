package ru.job4j.poly;

public class Bus implements Transport {

    @Override
    public void go() {
        System.out.println("Автобус начал движение");
    }

    @Override
    public void passengers(int quality) {
        System.out.println("Всего пассажиров " + quality);
    }

    @Override
    public int fillUp(int quality) {
        return quality * 46;
    }
    
}
