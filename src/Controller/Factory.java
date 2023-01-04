/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import model.Clown;
import model.AddTime;
import model.Bomb;
import model.Bowl;
import model.ImageObject;
import model.Plates;
import model.ScoreMultiplier;

/**
 *
 * @author ADMIN
 */
public class Factory {

    static public ImageObject getInstanceof(String name) {
        int x = (int) (1 + Math.random() * 4);
        if (null != name) {
            switch (name) {
                case "clown" -> {
                    return Clown.getinstace();
                }              
                case "plate" -> {
                    return new Plates((int) (Math.random() * 900), -(int) (Math.random() * 675), "/Plate" + x + ".png", x);
                }               
                case "bowl" -> {
                    return new Bowl((int) (Math.random() * 900), -(int) (Math.random() * 675), "/Bowl" + x + ".png", x);
                }
                case "bomb" -> {
                    return new Bomb((int) (Math.random() * 900), -(int) (Math.random() * 675), "/bomb.png", 5);
                }
                case "addTime" -> {
                    return AddTime.getInstance();
                }
                case "scoreMultiplier" -> {
                    return ScoreMultiplier.getInstance();
                }
                default -> {
                }
            }
        }
        return null;
    }
}
