package com.tank;

import java.awt.Graphics;
import java.util.Random;

/**
 * @author qingn
 */
public class Tank {

    private Dir dir = Dir.DOWN;

    private int speed = 10;

    private int x = 200;
    private int y = 200;

    protected Group group = Group.BAD;

    private boolean living = true;

    protected Random random = new Random();

    public boolean isLiving() {
        return living;
    }

    public void setLiving(boolean living) {
        this.living = living;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    private boolean moving = false;

    private TankFrame tankFrame;

    public static int width = ResourceMgr.tankL.getWidth();
    public static int height = ResourceMgr.tankL.getHeight();


    public Tank() {
    }

    public Tank(int speed, int x, int y, TankFrame tankFrame) {
        this.speed = speed;
        this.x = x;
        this.y = y;
        this.tankFrame = tankFrame;
    }

    public Tank(Dir dir, int speed, int x, int y, Group group, boolean living, boolean moving, TankFrame tankFrame) {
        this.dir = dir;
        this.speed = speed;
        this.x = x;
        this.y = y;
        this.group = group;
        this.living = living;
        this.moving = moving;
        this.tankFrame = tankFrame;
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

        if (!living) {
            tankFrame.tanks.remove(this);
            return;
        }

        switch (dir) {
            case LEFT:
                g.drawImage(ResourceMgr.tankL, x, y, null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.tankR, x, y, null);
                break;
            case UP:
                g.drawImage(ResourceMgr.tankU, x, y, null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.tankD, x, y, null);
                break;
            default:
                break;
        }


        move(dir);

    }

    private void move(Dir dir) {
        if (!isMoving()) {
            return;
        }
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

        if (group.equals(Group.BAD)) {
            if (random.nextInt(10) > 8) {
                fire();
            }
        }

    }


    public void fire() {
        int bx = x + Tank.width / 2 - Bullet.width / 2;
        int by = y + Tank.height / 2 - Bullet.height / 2;
        tankFrame.bullets.add(new Bullet(this.dir, 10, bx, by, true, this.tankFrame, this.group));
    }
}
