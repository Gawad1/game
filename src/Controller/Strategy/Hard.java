/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.Strategy;

import static Controller.Factory.getInstanceof;
import Controller.Iterator.Iterator;
import Controller.Iterator.Repo;
import model.ImageObject;

/**
 *
 * @author pc
 */
public class Hard implements Mode {

    int width;
    int height;
    private final Iterator moving = new Repo().getIterator();
    private final Iterator control = new Repo().getIterator();
    private final Iterator constant = new Repo().getIterator();

    public Hard(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public int getGamespeed() {
        return 150;
    }

    @Override
    public int getControlSpeed() {
        return 150;
    }

    @Override
    public Iterator getConstant() {
        constant.Add(new ImageObject(0, 0, "/theme.png", 10));
        return constant;
    }

    @Override
    public Iterator getMoving() {
        for (int i = 0; i < 17; i++) {
            int x = (int) (1 + Math.random() * 4);
            moving.Add(getInstanceof((int) (Math.random() * width), -(int) (Math.random() * height), "/Plate" + x + ".png", x));
        }
        for (int i = 0; i < 17; i++) {
            int x = (int) (1 + Math.random() * 4);
            moving.Add(getInstanceof((int) (Math.random() * width), -(int) (Math.random() * height), "/Bowl" + x + ".png", x));
        }
        for (int i = 0; i < 17; i++) {
            moving.Add(getInstanceof((int) (Math.random() * width), -(int) (Math.random() * height), "/bomb.png", 5));
        }
        moving.Add(getInstanceof(6));
        moving.Add(getInstanceof(7));
        return moving;
    }

    @Override
    public Iterator getControl() {
        control.Add(getInstanceof(0));
        return control;
    }

}
