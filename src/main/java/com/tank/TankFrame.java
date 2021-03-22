package com.tank;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {

    int x = 200;
    int y = 200;

    boolean lKey = false;
    boolean rKey = false;
    boolean uKey = false;
    boolean dKey = false;

    public TankFrame() {
        setSize(800, 600);
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
        g.fillRect(x, y, 50, 50);
//        x += 10;
//        y += 10;
    }



    /**
     * MykeyListener 类内部使用的类
     */
    class MykeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            System.out.println("keyPressed.......");
//            x += 200;
//            repaint();

            int keyCode = e.getKeyCode();
            switch (keyCode) {
                case KeyEvent.VK_LEFT:
//                    x -= 10;
                    lKey = true;
                    break;
                case KeyEvent.VK_RIGHT:
//                    x += 10;
                    rKey = true;
                    break;
                case KeyEvent.VK_UP:
//                    y -= 10;
                    uKey = true;
                    break;
                case KeyEvent.VK_DOWN:
//                    y += 10;
                    dKey = true;
                    break;
                default:
                    break;
            }


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
        }
    }
}


