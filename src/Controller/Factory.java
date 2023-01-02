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

    static public ImageObject getInstanceof(int x, int y, String path, int type) {
        switch (type) {
            case 0:
                return Clown.getinstace();
            case 1:
                if ("bowl1.png".equals(path)) {
                    return new Bowl(x, y, path, type);
                }
                return new Plates(x, y, path, type);
            case 2:
                if ("bowl2.png".equals(path)) {
                    return new Bowl(x, y, path, type);
                }
                return new Plates(x, y, path, type);
            case 3:
                if ("bowl3.png".equals(path)) {
                    return new Bowl(x, y, path, type);
                }
                return new Plates(x, y, path, type);
            case 4:
                if ("bowl4.png".equals(path)) {
                    return new Bowl(x, y, path, type);
                }
                return new Plates(x, y, path, type);
            case 5:
                return new Bomb(x, y, path, type);
            case 6:
                return ScoreMultiplier.getInstance();
            case 7:
                return AddTime.getInstance();
            default:
                return null;
        }
    }

    static public ImageObject getInstanceof(int type) {
        switch (type) {
            case 0:
                return Clown.getinstace();
            case 6:
                return ScoreMultiplier.getInstance();
            case 7:
                return AddTime.getInstance();
            default:
                return null;
        }
    }
}
