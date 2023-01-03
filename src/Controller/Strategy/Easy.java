/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.Strategy;

import static Controller.Factory.getInstanceof;
import Controller.Iterator.Iterator;
import Controller.Iterator.Repo;
import java.util.List;
import model.ImageObject;

/**
 *
 * @author pc
 */
public class Easy implements Mode {

    int width;
    int height;
    private final Iterator moving = new Repo().getIterator();
    private final Iterator control = new Repo().getIterator();
    private final Iterator constant = new Repo().getIterator();

    public Easy(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public int getGamespeed() {
        return 20;
    }

    @Override
    public int getControlSpeed() {
        return 20;
    }



    @Override
    public Iterator getMoving() {
        for (int i = 0; i < 10; i++) {
            int x = (int) (1 + Math.random() * 4);
            moving.Add(getInstanceof((int) (Math.random() * width), -(int) (Math.random() * height), "/Plate" + x + ".png", x));
        }
        for (int i = 0; i < 10; i++) {
            int x = (int) (1 + Math.random() * 4);
            moving.Add(getInstanceof((int) (Math.random() * width), -(int) (Math.random() * height), "/Bowl" + x + ".png", x));
        }
        for (int i = 0; i < 5; i++) {
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

    @Override
    public Iterator getConstant() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
