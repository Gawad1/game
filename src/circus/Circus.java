/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package circus;

import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.World;
import java.util.LinkedList;
import java.util.List;
import model.Clown;
import model.ImageObject;
import Controller.States;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**

 */
public class Circus extends States implements World {

    private static int MAX_TIME = 1 * 60 * 1000;
    private int score = 0;
    private long startTime = System.currentTimeMillis();
    private final int width;
    private final int height;
    int totalleft = 0;
    int totalright = 0;
    private final List<GameObject> constant = new LinkedList<GameObject>();
    private final List<GameObject> moving = new LinkedList<GameObject>();
    private final List<GameObject> control = new LinkedList<GameObject>();
    private final List<ImageObject> leftLeg = new LinkedList<ImageObject>();
    private final List<ImageObject> RighttLeg = new LinkedList<ImageObject>();

    public Circus(int screenWidth, int screenHeight) {
        width = screenWidth;
        height = screenHeight;
        Clown clown = new Clown(screenWidth / 3, (int) (screenHeight * 0.65), "/clown.png", 0);
        control.add(clown);
        constant.add(new ImageObject(0, 0, "/theme.png", 10));
        for (int i = 0; i < 10; i++) {
            int x = (int) (1 + Math.random() * 4);
            moving.add(new ImageObject((int) (Math.random() * width), -(int) (Math.random() * height), "/Plate" + x + ".png", x));
        }
        for (int i = 0; i < 10; i++) {
            int x = (int) (1 + Math.random() * 4);
            moving.add(new ImageObject((int) (Math.random() * width), -(int) (Math.random() * height), "/Bowl" + x + ".png", x));
        }
        for (int i = 0; i < 10; i++) {
            moving.add(new ImageObject((int) (Math.random() * width), -(int) (Math.random() * height), "/bomb.png", 5));
        }
        moving.add(new ImageObject((int) (Math.random() * width), -(int) (Math.random() * height), "/ScoreMultiplier.png", 6));
        moving.add(new ImageObject((int) (Math.random() * width), -(int) (Math.random() * height), "/Clock.png", 7));

    }

    private boolean intersectLeft(GameObject clown, GameObject object) {
        return (Math.abs((clown.getX() + 30) - (object.getX() + object.getWidth() / 10)) <= object.getWidth()) && (Math.abs((clown.getY()) - (object.getY()) - totalleft) == 0);
    }

    private boolean intersectRight(GameObject clown, GameObject object) {
        return (Math.abs((clown.getX() + 150) - (object.getX() + object.getWidth() / 10)) <= object.getWidth()) && (Math.abs((clown.getY()) - (object.getY()) - totalright) == 0);
    }

    @Override
    public boolean refresh() {
        boolean timeout = System.currentTimeMillis() - startTime > MAX_TIME;
        Clown clown = (Clown) control.get(0);
        for (ImageObject m : moving.toArray(new ImageObject[moving.size()])) {
            switch (m.getType()) {
                case 1,2,3,4 -> {
                    if (intersectLeft(clown, m)) {
                        totalleft = totalleft + m.getHeight();
                        control.add(m);
                        moving.remove(m);
                        leftLeg.add(m);
                        m.setX(clown.getX() + 30);
                        m.setY(clown.getY() + 15 - totalleft);
                        int x = leftLeg.size();
                        if (x >= 3 && leftLeg.get(x - 1).getType() == leftLeg.get(x - 2).getType() && leftLeg.get(x - 1).getType() == leftLeg.get(x - 3).getType()) {
                            for (int i = 1; i <= 3; i++) {
                                leftLeg.get(x - i).setY(-(int) (Math.random() * getHeight()));
                                leftLeg.get(x - i).setX((int) (Math.random() * getWidth()));
                                moving.add(leftLeg.get(x - i));
                                control.remove(leftLeg.get(x - i));
                                totalleft = totalleft - leftLeg.get(x - i).getHeight();
                                leftLeg.remove(leftLeg.get(x - i));
                            }
                            score = score + 10;
                        }
                    }

                    if (intersectRight(clown, m)) {
                        totalright = totalright + m.getHeight();
                        control.add(m);
                        moving.remove(m);
                        RighttLeg.add(m);
                        m.setX(clown.getX() + 150);
                        m.setY(clown.getY() + 15 - totalright);
                        int x = RighttLeg.size();
                        if (x >= 3 && RighttLeg.get(x - 1).getType() == RighttLeg.get(x - 2).getType() && RighttLeg.get(x - 1).getType() == RighttLeg.get(x - 3).getType()) {
                            for (int i = 1; i <= 3; i++) {
                                RighttLeg.get(x - i).setY(-(int) (Math.random() * getHeight()));
                                RighttLeg.get(x - i).setX((int) (Math.random() * getWidth()));
                                moving.add(RighttLeg.get(x - i));
                                control.remove(RighttLeg.get(x - i));
                                totalright = totalright - RighttLeg.get(x - i).getHeight();
                                RighttLeg.remove(RighttLeg.get(x - i));
                            }
                            score = score + 10;
                        }
                    }
                    m.setY((m.getY() + 1));
                    if (m.getY() == height) {
                        m.setY(-(int) (Math.random() * getHeight()));
                        m.setX((int) (Math.random() * getWidth()));
                    }
                }

                case 5 -> {
                    if (intersectLeft(clown, m) || intersectRight(clown, m)) {
                        m.setY(-(int) (Math.random() * getHeight()));
                        m.setX((int) (Math.random() * getWidth()));
                        score = Math.max(0, score - 10);
                    }
                    m.setY((m.getY() + 1));
                    if (m.getY() == height) {
                        m.setY(-(int) (Math.random() * getHeight()));
                        m.setX((int) (Math.random() * getWidth()));

                    }
                }
                case 6 -> {
                    if (intersectLeft(clown, m) || intersectRight(clown, m)) {
                        m.setY(-500);
                        m.setX((int) (Math.random() * getWidth()));
                        score = score * 2;
                    }
                    m.setY((m.getY() + 1));
                    if (m.getY() == height) {
                        m.setY(-500);
                        m.setX((int) (Math.random() * getWidth()));

                    }
                }
                case 7 -> {
                    if (intersectLeft(clown, m) || intersectRight(clown, m)) {
                        m.setY(-500);
                        m.setX((int) (Math.random() * getWidth()));
                        startTime = startTime + 10 * 1000;
                    }
                    m.setY((m.getY() + 1));
                    if (m.getY() == height) {
                        m.setY(-500);
                        m.setX((int) (Math.random() * getWidth()));

                    }
                }
            }
        }

        return !timeout;
    }

    @Override
    public List<GameObject> getConstantObjects() {
        return constant;
    }

    @Override
    public List<GameObject> getMovableObjects() {
        return moving;
    }

    @Override
    public List<GameObject> getControlableObjects() {
        return control;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public String getStatus() {
        long time = Math.max(0, (MAX_TIME - (System.currentTimeMillis() - startTime)) / 1000);
        try {
            String state = getStates(score,time);
        } catch (IOException ex) {
            Logger.getLogger(Circus.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "Score=" + score + "   |   Time=" + time + "   |   State=" + state;
    }

    @Override
    public int getSpeed() {
        return 10;
    }

    @Override
    public int getControlSpeed() {
        return 20;
    }
}
