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
import Controller.MainController;
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
    private Iterator moving;
    private Iterator control;
    private Iterator constant;
    States states = new States();
    MainController mainController;

    public Circus(int screenWidth, int screenHeight, String GameMode) {
        width = screenWidth;
        height = screenHeight;
        mainController = new MainController(screenWidth, screenHeight, GameMode, startTime);
        moving = mainController.getMoving();
        control = mainController.getControl();
        constant = mainController.getConstant();
    }

    @Override
    public boolean refresh() {
        boolean timeout = System.currentTimeMillis() - startTime > MAX_TIME;
        mainController.doRefresh();
        moving = mainController.getMoving();
        control = mainController.getControl();
        score = mainController.getScore();
        startTime = mainController.getStartTime();
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
        return mainController.getSpeed();
    }

    @Override
    public int getControlSpeed() {
        return mainController.getControlSpeed();
    }
}
