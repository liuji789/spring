package com.tank;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Objects;

/**
 * @author qingn
 */
public class TankFrame extends Frame {


    private static int WIDTH = 800;
    private static int HEIGHT = 600;


    Tank tank = new Tank();
    Bullet bullet = new Bullet();


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
        System.out.println("paint.....");

        tank.paint(g);

        bullet.paint(g);

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
            System.out.println("keyPressed.......");

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
            System.out.println("keyReleased........");

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


