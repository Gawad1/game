/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Controller.Strategy;

import Controller.Iterator.Iterator;
/**
 *
 * @author pc
 */
public interface Mode {

    public int getGamespeed();

    public int getControlSpeed();

    public Iterator getConstant();

    public Iterator getMoving();

    public Iterator getControl();

}
