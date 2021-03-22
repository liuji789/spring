package com.tank;

public class Main {

    public static void main(String[] args) throws Exception {
        TankFrame tankFrame = new TankFrame();


        while (true){

           Thread.sleep(50);

            if (tankFrame.lKey) {
                tankFrame.x -= 10;
            }
            if (tankFrame.rKey) {
                tankFrame.x += 10;
            }
            if (tankFrame.uKey) {
                tankFrame.y += 10;
            }
            if (tankFrame.dKey) {
                tankFrame.y -= 10;
            }

           tankFrame.repaint();
        }

    }

}
