package com.tank;


import java.awt.Graphics;
import java.awt.Rectangle;

/**
 * @author qingn
 */
public class Bullet {

    private Dir dir = Dir.DOWN;

    private int speed = 10;

    private int x = 200;
    private int y = 200;

    public static int width = ResourceMgr.bulletL.getWidth();
    public static int height = ResourceMgr.bulletL.getHeight();

    private boolean living = true;
    TankFrame tankFrame;

    private Group group = Group.BAD;

    public Bullet(Dir dir, int speed, int x, int y, boolean living, TankFrame tankFrame, Group group) {
        this.dir = dir;
        this.speed = speed;
        this.x = x;
        this.y = y;
        this.living = living;
        this.tankFrame = tankFrame;
        this.group = group;
    }

    public Bullet() {
    }

    public Bullet(int speed, int x, int y) {
        this.speed = speed;
        this.x = x;
        this.y = y;
    }

    public Bullet(Dir dir, int x, int y, TankFrame tankFrame) {
        this.dir = dir;
        this.x = x;
        this.y = y;
        this.tankFrame = tankFrame;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public void paint(Graphics g) {
        if (!living) {
            tankFrame.bullets.remove(this);
            return;
        }

        switch (dir) {
            case LEFT:
                g.drawImage(ResourceMgr.bulletL, x, y, null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.bulletR, x, y, null);
                break;
            case UP:
                g.drawImage(ResourceMgr.bulletU, x, y, null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.bulletD, x, y, null);
                break;
            default:
                break;
        }

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

        if (x < 0 || x > tankFrame.getWidth() || y < 0 || y > tankFrame.getHeight()) {
            living = false;
        }

    }

    public void collideWith(Tank tank) {
        if (this.group.equals(tank.group)) {
            return;
        }

        Rectangle bulletRectangle = new Rectangle(x, y, width, height);

        Rectangle tankRectangle = new Rectangle(tank.getX(), tank.getY(), Tank.width, Tank.height);

        if (tankRectangle.intersects(bulletRectangle)) {
            living = false;
            tank.setLiving(false);
        }
    }
}
