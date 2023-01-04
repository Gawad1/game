/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Controller.Iterator.Iterator;
import Controller.Iterator.Repo;
import Controller.Strategy.GameMode;
import Controller.Strategy.Mode;
import circus.Circus;
import eg.edu.alexu.csd.oop.game.GameObject;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.ImageObject;

/**
 *
 * @author pc
 */
public class MainController {

    private int score = 0;
    private int totalleft = 0;
    private int totalright = 0;
    private final int width;
    private final int height;
    private Iterator moving;
    private Iterator control;
    private Iterator leftLeg = new Repo().getIterator();
    private Iterator RighttLeg = new Repo().getIterator();
    private Iterator constant;
    private int speed;
    private int controlSpeed = 20;
    private long startTime;
    Mode mode;
    JFrame f;
    String gameMode;
    States states = new States();
    private static int MAX_TIME = 1 * 60 * 1000;

    public MainController(int screenWidth, int screenHeight, String GameMode, long startTime) {

        width = screenWidth;
        height = screenHeight;
        this.startTime = startTime;
        this.gameMode=GameMode;
        GameMode gameMode = new GameMode(screenWidth, screenHeight, GameMode);
        mode = gameMode.getMode();
        speed = mode.getGamespeed();
        moving = mode.getMoving();
        control = mode.getControl();
        constant = mode.getConstant();
    }

    private boolean intersectLeft(GameObject clown, GameObject object) {
        return (Math.abs((clown.getX() + 30) - (object.getX() + object.getWidth() / 10)) <= object.getWidth()) && (Math.abs((clown.getY()) - (object.getY()) - totalleft) == 0);
    }

    private boolean intersectRight(GameObject clown, GameObject object) {
        return (Math.abs((clown.getX() + 150) - (object.getX() + object.getWidth() / 10)) <= object.getWidth()) && (Math.abs((clown.getY()) - (object.getY()) - totalright) == 0);
    }

    public void doRefresh() {
        ImageObject clown = control.get(0);
        ImageObject m;
        while (moving.hasNext()) {
            m = moving.next();
            switch (m.getType()) {
                case 1,2,3,4 -> {
                    if (intersectRight(clown, m)) {
                        totalright = totalright + m.getHeight();
                        control.Add(m);
                        moving.Remove(m);
                        RighttLeg.Add(m);
                        m.setX(clown.getX() + 150);
                        m.setY(clown.getY() + 15 - totalright);
                        m.setKey(1);
                        int x = RighttLeg.List().size();
                        if (x >= 3 && RighttLeg.get(x - 1).getType() == RighttLeg.get(x - 2).getType() && RighttLeg.get(x - 1).getType() == RighttLeg.get(x - 3).getType()) {
                            for (int i = 1; i <= 3; i++) {
                                RighttLeg.get(x - i).setKey(0);
                                control.Remove(RighttLeg.get(x - i));
                                RighttLeg.get(x - i).setX((int) (Math.random() * width));
                                totalright = totalright - RighttLeg.get(x - i).getHeight();
                                moving.Add(RighttLeg.get(x - i));
                                RighttLeg.get(x - i).setY(-(int) (Math.random() * height));
                                RighttLeg.Remove(RighttLeg.get(x - i));
                            }
                            score = score + 10;
                        }
                    }
                    if (intersectLeft(clown, m)) {
                        totalleft = totalleft + m.getHeight();
                        control.Add(m);
                        moving.Remove(m);
                        leftLeg.Add(m);
                        m.setX(clown.getX() + 30);
                        m.setY(clown.getY() + 15 - totalleft);
                        m.setKey(1);
                        int x = leftLeg.List().size();
                        if (x >= 3 && leftLeg.get(x - 1).getType() == leftLeg.get(x - 2).getType() && leftLeg.get(x - 1).getType() == leftLeg.get(x - 3).getType()) {
                            for (int i = 1; i <= 3; i++) {
                                leftLeg.get(x - i).setKey(0);
                                control.Remove(leftLeg.get(x - i));
                                leftLeg.get(x - i).setX((int) (Math.random() * width));
                                totalleft = totalleft - leftLeg.get(x - i).getHeight();
                                moving.Add(leftLeg.get(x - i));
                                leftLeg.get(x - i).setY(-(int) (Math.random() * height));
                                leftLeg.Remove(leftLeg.get(x - i));
                            }
                            score = score + 10;
                        }
                    }

                    m.setY((m.getY() + 1));
                    if (m.getY() == height) {
                        m.setY(-(int) (Math.random() * height));
                        m.setX((int) (Math.random() * width));
                    }
                }

                case 5 -> {
                    if (intersectLeft(clown, m) || intersectRight(clown, m)) {
                        m.setY(-(int) (Math.random() * height));
                        m.setX((int) (Math.random() * width));
                        score = Math.max(0, score - 10);
                    }
                    m.setY((m.getY() + 1));
                    if (m.getY() == height) {
                        m.setY(-(int) (Math.random() * height));
                        m.setX((int) (Math.random() * width));

                    }
                }
                case 6 -> {
                    if (intersectLeft(clown, m) || intersectRight(clown, m)) {
                        m.setY(-500);
                        m.setX((int) (Math.random() * width));
                        score = score * 2;
                    }
                    m.setY((m.getY() + 1));
                    if (m.getY() == height) {
                        m.setY(-500);
                        m.setX((int) (Math.random() * width));

                    }
                }
                case 7 -> {
                    if (intersectLeft(clown, m) || intersectRight(clown, m)) {
                        m.setY(-500);
                        m.setX((int) (Math.random() * width));
                        startTime = startTime + 10 * 1000;
                    }
                    m.setY((m.getY() + 1));
                    if (m.getY() == height) {
                        m.setY(-500);
                        m.setX((int) (Math.random() * width));

                    }
                }
            }
            while (RighttLeg.hasNext()) {
                m = RighttLeg.next();
                m.setX(clown.getX() + 150);
            }
            while (leftLeg.hasNext()) {
                m = leftLeg.next();
                m.setX(clown.getX() + 30);
            }
        }

    }
        public void updateScore(int score, long time) {
        f = new JFrame();
        try {
            if (states.getStates(score, time, gameMode).equals("HighScore")) {
                
                
                states.updateScore();
                JOptionPane.showMessageDialog(f, "New High Score!!!!");
            } else if (states.getStates(score, time, gameMode).equals("GameOver")) {
                 
            }
        } catch (IOException ex) {
            Logger.getLogger(Circus.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getstate() {
        try {
            return states.getStates(score, Math.max(0, (MAX_TIME - (System.currentTimeMillis() - startTime)) / 1000), gameMode);
        } 
        catch (IOException ex) {
            Logger.getLogger(Circus.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public long getStartTime() {
        return startTime;
    }

    public Iterator getMoving() {
        return moving;
    }

    public Iterator getControl() {
        return control;
    }

    public Iterator getConstant() {
        return constant;
    }

    public int getScore() {
        return score;
    }

    public int getSpeed() {
        return speed;
    }

    public int getControlSpeed() {
        return controlSpeed;
    }

}
