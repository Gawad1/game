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

/**
 *
 * @author ADMIN
 */
public class Circus implements World {

    private static int MAX_TIME = 1 * 60 * 1000;
    private int score = 0;
    private long startTime = System.currentTimeMillis();
    private final int width;
    private final int height;
    private final List<GameObject> constant = new LinkedList<GameObject>();
    private final List<GameObject> moving = new LinkedList<GameObject>();
    private final List<GameObject> control = new LinkedList<GameObject>();

    public Circus(int screenWidth, int screenHeight) {
        width = screenWidth;
        height = screenHeight;
        Clown clown = new Clown(screenWidth / 3, (int) (screenHeight * 0.65), "/clown.png", 0);
        control.add(clown);
        constant.add(new ImageObject(0, 0, "/theme.png", 10));
        for (int i = 0; i < 10; i++) {
            moving.add(new ImageObject((int) (Math.random() * width), (int) (Math.random() * height / 2), "/Plate" + (int) (1 + Math.random() * 4) + ".png", 1));
        }
        for (int i = 0; i < 10; i++) {
            moving.add(new ImageObject((int) (Math.random() * width), (int) (Math.random() * height / 2), "/Bowl" + (int) (1 + Math.random() * 4) + ".png", 2));
        }
    }

    private boolean intersectLeft(GameObject clown, GameObject object) {
        return (Math.abs((clown.getX() + 30) - (object.getX() + object.getWidth() / 6)) <= object.getWidth()) && (Math.abs((clown.getY()) - (object.getY())) == 0);
    }

    private boolean intersectRight(GameObject clown, GameObject object) {
        return (Math.abs((clown.getX() + 150) - (object.getX() + object.getWidth() / 6)) <= object.getWidth()) && (Math.abs((clown.getY()) - (object.getY())) == 0);
    }

    @Override
    public boolean refresh() {
        GameObject clown = control.get(0);
        for (GameObject m : moving.toArray(new GameObject[moving.size()])) {
            if (intersectLeft(clown, m)) {
                m.setX(clown.getX() + 30);
                m.setY(clown.getY() + 20);
                control.add(m);
                moving.remove(m);
            }
            if (intersectRight(clown, m)) {
                m.setX(clown.getX() + 150);
                m.setY(clown.getY() + 20);
                control.add(m);
                moving.remove(m);
            }
            m.setY((m.getY() + 1));
            if (m.getY() == height) {
                m.setY(0);
                m.setX((int) (Math.random() * getWidth()));
            }

        }
        return true;
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
        return "lesa 7aba 3l 7eta dy";
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
