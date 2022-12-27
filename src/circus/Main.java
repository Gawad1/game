/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package circus;

import eg.edu.alexu.csd.oop.game.GameEngine;
import eg.edu.alexu.csd.oop.game.GameEngine.GameController;
import java.awt.Color;

/**
 *
 * @author pc
 */
public class Main {

    public static void main(String[] args) {
        final GameController gameController = GameEngine.start("Circus Game", new circus.Circus(700, 400), Color.YELLOW);
    }
}
