/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package circus;

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

        Circus circus=new circus.Circus(900, 675,"normal");        
        GameController gameController = new GameController(() -> circus);
        gameController.start();
        

       

        

    }
}
