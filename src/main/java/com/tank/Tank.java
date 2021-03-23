package com.tank;

import java.awt.Color;
import java.awt.Graphics;

/**
 * @author qingn
 */
public class Tank {

    private Dir dir = Dir.DOWN;

    private int speed = 10;

    private int x = 200;
    private int y = 200;

    private boolean moving = false;

    public Tank() {
    }

    public Tank(int speed, int x, int y) {
        this.speed = speed;
        this.x = x;
        this.y = y;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public void paint(Graphics g) {
        Color oldColor = g.getColor();
        g.setColor(Color.YELLOW);
        g.fillRect(x, y, 50, 50);
        g.setColor(oldColor);
        move(dir);

    }

    private void move(Dir dir) {
        if (isMoving()) {
            switch (dir) {
                case UP:
                    y -= speed;
                    break;
                case DOWN:
                    y += speed;
                    break;
                case LEFT:
                    x -= speed;
                    break;
                case RIGHT:
                    x += speed;
                    break;
                default:
                    break;
            }

        }
    }


}
