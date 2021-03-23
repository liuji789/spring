package com.tank;

public class Main {

    public static void main(String[] args) throws Exception {
        TankFrame tankFrame = new TankFrame();

        for (int i = 0; i < 5; i++) {
            Tank tank = new Tank(Dir.DOWN, 2, 100 + i * 100, 200, Group.BAD, true, true, tankFrame);
            tankFrame.tanks.add(tank);
        }

        while (true) {

            Thread.sleep(25);

            tankFrame.repaint();
        }

    }

}
