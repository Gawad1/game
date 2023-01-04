/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.Strategy;

/**
 *
 * @author pc
 */
public class GameMode {

    Mode mode;

    public GameMode(int width, int height, String gameMode) {
        if (gameMode.equals("easy")) {
            mode = new Easy();
        } else if (gameMode.equals("normal")) {
            mode = new Normal();
        } else {
            mode = new Hard();
        }
    }

    public Mode getMode() {
        return mode;
    }
}
