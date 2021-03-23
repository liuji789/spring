package com.tank;


import java.awt.Color;
import java.awt.Graphics;

/**
 * @author qingn
 */
public class Bullet {

    private Dir dir = Dir.DOWN;

    private int speed = 2;

    private int x = 200;
    private int y = 200;


    public Bullet() {
    }

    public Bullet(int speed, int x, int y) {
        this.speed = speed;
        this.x = x;
        this.y = y;
    }

    public Bullet(Dir dir, int x, int y) {
        this.dir = dir;
        this.x = x;
        this.y = y;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public void paint(Graphics g) {
        Color color = g.getColor();
        g.setColor(Color.red);
        g.fillOval(x, y, 10, 10);
        g.setColor(color);
        move(dir);

    }

    private void move(Dir dir) {
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
