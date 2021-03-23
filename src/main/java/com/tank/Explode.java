package com.tank;

import java.awt.Graphics;

/**
 * @author qingn
 */
public class Explode {


    public static int width = ResourceMgr.bulletL.getWidth();
    public static int height = ResourceMgr.bulletL.getHeight();

    private boolean live = true;
    TankFrame tankFrame;

    private int x = 200;
    private int y = 200;

    private int step = 0;

    public Explode(TankFrame tankFrame, int x, int y) {
        this.tankFrame = tankFrame;
        this.x = x;
        this.y = y;
    }

    public void paint(Graphics g) {

        g.drawImage(ResourceMgr.explodes[step++], x, y, null);

        if (step >= ResourceMgr.explodes.length) {
            step = 0;
        }

    }
}
