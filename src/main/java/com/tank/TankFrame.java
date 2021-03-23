package com.tank;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author qingn
 */
public class TankFrame extends Frame {


    private static int WIDTH = 1024;
    private static int HEIGHT = 726;


    Tank tank = new Tank(Dir.UP,2,200,600,Group.GOOD,true,false,this);


    List<Bullet> bullets = new ArrayList<>();

    List<Tank> tanks = new ArrayList<>();

    Explode explode = new Explode(this,200,200);



    public TankFrame() {
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setTitle("tank war");
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });


        addKeyListener(new MykeyListener());

    }

    @Override
    public void paint(Graphics g) {

        Color c = g.getColor();
        g.setColor(Color.WHITE);
        g.drawString("子弹的数量:" + bullets.size(), 10, 60);
        g.drawString("敌人的数量:" + tanks.size(), 10, 80);
        g.setColor(c);

        tank.paint(g);

        for (int i = 0; i < tanks.size(); i++) {
            Tank tank = tanks.get(i);
            tank.paint(g);

        }

        for (int i = 0; i < bullets.size(); i++) {

            Bullet bullet = bullets.get(i);

            bullet.paint(g);
        }

        for (int i = 0; i < bullets.size(); i++) {
            for (int j = 0; j < tanks.size(); j++) {
                bullets.get(i).collideWith(tanks.get(j));
            }
        }

        explode.paint(g);

    }

    Image offScreeImage = null;

    @Override
    public void update(Graphics g) {
        if (Objects.isNull(offScreeImage)) {
            offScreeImage = createImage(WIDTH, HEIGHT);
        }
        //图片
        Graphics graphics = offScreeImage.getGraphics();

        Color color = graphics.getColor();

        graphics.setColor(Color.BLACK);
        graphics.fillRect(0, 0, WIDTH, HEIGHT);

        graphics.setColor(color);

        paint(graphics);

        g.drawImage(offScreeImage, 0, 0, null);
    }

    /**
     * MykeyListener 类内部使用的类
     */
    class MykeyListener extends KeyAdapter {

        boolean lKey = false;
        boolean rKey = false;
        boolean uKey = false;
        boolean dKey = false;

        @Override
        public void keyPressed(KeyEvent e) {

            int keyCode = e.getKeyCode();
            switch (keyCode) {
                case KeyEvent.VK_LEFT:
                    lKey = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    rKey = true;
                    break;
                case KeyEvent.VK_UP:
                    uKey = true;
                    break;
                case KeyEvent.VK_DOWN:
                    dKey = true;
                    break;
                default:
                    break;
            }

            setMainTankDir();

        }

        @Override
        public void keyReleased(KeyEvent e) {

            int keyCode = e.getKeyCode();
            switch (keyCode) {
                case KeyEvent.VK_LEFT:
                    lKey = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    rKey = false;
                    break;
                case KeyEvent.VK_UP:
                    uKey = false;
                    break;
                case KeyEvent.VK_DOWN:
                    dKey = false;
                    break;
                case KeyEvent.VK_CONTROL:
                    tank.fire();
                    break;
                default:
                    break;
            }

            setMainTankDir();
        }

        private void setMainTankDir() {

            if (lKey || rKey || uKey || dKey) {
                tank.setMoving(true);
                if (lKey) {
                    tank.setDir(Dir.LEFT);
                }
                if (rKey) {
                    tank.setDir(Dir.RIGHT);
                }
                if (uKey) {
                    tank.setDir(Dir.UP);
                }
                if (dKey) {
                    tank.setDir(Dir.DOWN);
                }
            } else {
                tank.setMoving(false);
            }


        }
    }
}


