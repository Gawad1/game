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
        States states = new States();
        int score;
        Circus circus=new circus.Circus(900, 675,"normal");
       // final GameController gameController = GameEngine.start("Circus Game", new circus.Circus(900, 675, "hard"), Color.YELLOW);
        
        GameController gameController = new GameController(() -> circus);
        
        gameController.start();
       /* score=circus.Score();
        try {
            System.out.println(states.getStates(score, 0));
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
           if(states.getStates(score, 0).equals("HighScore"))
           {
               System.out.println("entered high score");
               states.updateScore(score);
           }
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }*/
       
        

    }
}
