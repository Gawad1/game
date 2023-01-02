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
import static Controller.Factory.getInstanceof;
import Controller.Iterator.Iterator;
import Controller.Iterator.Repo;
import Controller.Strategy.Mode;
import Controller.Strategy.GameMode;
import model.AddTime;
import model.ScoreMultiplier;

/**
 *
 */
public class Circus implements World {

    private static int MAX_TIME = 1 * 60 * 1000;
    private int score = 0;
    private long startTime = System.currentTimeMillis();
    private final int width;
    private final int height;
    int totalleft = 0;
    int totalright = 0;
    private Iterator moving;
    private Iterator control;
    private Iterator leftLeg = new Repo().getIterator();
    private Iterator RighttLeg = new Repo().getIterator();
    private Iterator constant;
    States states = new States();
    Mode mode;

    public Circus(int screenWidth, int screenHeight, String GameMode) {
        width = screenWidth;
        height = screenHeight;

        //Clown.getinstace().setX(screenWidth / 3);
        //Clown.getinstace().setY((screenHeight * 0.65));
        //Clown.getinstace().setType(0);
        //Clown clown =new  Clown(screenWidth / 3, (int) (screenHeight * 0.65), "/clown.png", 0);
        //control.Add(Clown.getinstace());
        //constant.Add(new ImageObject(0, 0, "/theme.png", 10));
        GameMode gameMode = new GameMode(screenWidth, screenHeight, GameMode);
        mode = gameMode.getMode();
        moving = mode.getMoving();
        control = mode.getControl();
        constant = mode.getConstant();
        /*for (int i = 0; i < 10; i++) {
            int x = (int) (1 + Math.random() * 4);
            moving.Add(getInstanceof((int) (Math.random() * width), -(int) (Math.random() * height), "/Plate" + x + ".png", x));
        }
        for (int i = 0; i < 10; i++) {
            int x = (int) (1 + Math.random() * 4);
            moving.Add(getInstanceof((int) (Math.random() * width), -(int) (Math.random() * height), "/Bowl" + x + ".png", x));
        }
        for (int i = 0; i < 10; i++) {
            moving.Add(getInstanceof((int) (Math.random() * width), -(int) (Math.random() * height), "/bomb.png", 5));
        }
        moving.Add(ScoreMultiplier.getInstance());
        moving.Add(AddTime.getInstance());
         */
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
        // for (ImageObject m = moving.get(0); moving.hasNext(); m = moving.next()) {
        ImageObject m;
        moving.pos();
        while (moving.hasNext()) {
            m = moving.next();
            switch (m.getType()) {
                case 1,2,3,4 -> {
                    if (intersectLeft(clown, m)) {
                        totalleft = totalleft + m.getHeight();
                        control.Add(m);
                        moving.Remove(m);
                        leftLeg.Add(m);
                        m.setX(clown.getX() + 30);
                        m.setY(clown.getY() + 15 - totalleft);
                        int x = leftLeg.List().size();
                        if (x >= 3 && leftLeg.get(x - 1).getType() == leftLeg.get(x - 2).getType() && leftLeg.get(x - 1).getType() == leftLeg.get(x - 3).getType()) {
                            for (int i = 1; i <= 3; i++) {
                                leftLeg.get(x - i).setY(-(int) (Math.random() * getHeight()));
                                leftLeg.get(x - i).setX((int) (Math.random() * getWidth()));
                                moving.Add(leftLeg.get(x - i));
                                control.Remove(leftLeg.get(x - i));
                                totalleft = totalleft - leftLeg.get(x - i).getHeight();
                                leftLeg.Remove(leftLeg.get(x - i));
                            }
                            score = score + 10;
                        }
                    }

                    if (intersectRight(clown, m)) {
                        totalright = totalright + m.getHeight();
                        control.Add(m);
                        moving.Remove(m);
                        RighttLeg.Add(m);
                        m.setX(clown.getX() + 150);
                        m.setY(clown.getY() + 15 - totalright);
                        int x = RighttLeg.List().size();
                        if (x >= 3 && RighttLeg.get(x - 1).getType() == RighttLeg.get(x - 2).getType() && RighttLeg.get(x - 1).getType() == RighttLeg.get(x - 3).getType()) {
                            for (int i = 1; i <= 3; i++) {
                                RighttLeg.get(x - i).setY(-(int) (Math.random() * getHeight()));
                                RighttLeg.get(x - i).setX((int) (Math.random() * getWidth()));
                                moving.Add(RighttLeg.get(x - i));
                                control.Remove(RighttLeg.get(x - i));
                                totalright = totalright - RighttLeg.get(x - i).getHeight();
                                RighttLeg.Remove(RighttLeg.get(x - i));
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
        return constant.List();
    }

    @Override
    public List<GameObject> getMovableObjects() {
        return moving.List();
    }

    @Override
    public List<GameObject> getControlableObjects() {
        return control.List();
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
        return "Score=" + score + "   |   Time=" + Math.max(0, (MAX_TIME - (System.currentTimeMillis() - startTime)) / 1000);
    }

    @Override
    public int getSpeed() {
        return mode.getGamespeed();
    }

    @Override
    public int getControlSpeed() {
        return mode.getControlSpeed();
    }
}
