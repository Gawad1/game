/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Controller.GameController;
import Controller.States;
import eg.edu.alexu.csd.oop.game.GameEngine;
//import eg.edu.alexu.csd.oop.game.GameEngine.GameController;
import java.awt.Color;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pc
 */
public class Main {

    public static void main(String[] args) {

        Circus circus=new View.Circus(900, 675,"easy");        
        GameController gameController = new GameController(() -> circus);
        gameController.start();      

    }
}
