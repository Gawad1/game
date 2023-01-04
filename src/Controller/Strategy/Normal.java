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
public class Normal implements Mode {

    private final Iterator moving = new Repo().getIterator();
    private final Iterator control = new Repo().getIterator();
    private final Iterator constant = new Repo().getIterator();

    public Normal() {
    }

    @Override
    public int getGamespeed() {
        return 15;
    }

    @Override
    public int getControlSpeed() {
        return 20;
    }

    @Override
    public Iterator getConstant() {
        constant.Add(new ImageObject(0, 0, "/theme.png", 10));
        return constant;
    }

    @Override
    public Iterator getMoving() {
        for (int i = 0; i < 12; i++) {
            moving.Add(getInstanceof("plate"));
        }
        for (int i = 0; i < 12; i++) {
            moving.Add(getInstanceof("bowl"));
        }
        for (int i = 0; i < 7; i++) {
            moving.Add(getInstanceof("bomb"));
        }
        moving.Add(getInstanceof("addTime"));
        moving.Add(getInstanceof("scoreMultiplier"));

        return moving;
    }

    @Override
    public Iterator getControl() {
        control.Add(getInstanceof("clown"));
        return control;
    }

}
