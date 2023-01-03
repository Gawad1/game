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
            mode = new Easy(width, height);
        } else if (gameMode.equals("normal")) {
            mode = new Normal(width, height);
        } else // (gameMode.equals("hard")) {
            
        {
           // System.out.println("hard game is created");
            mode = new Hard(width, height);
           
 System.out.println(getMode().getGamespeed());


            
            
                  
            
           // System.out.println(mode.getGamespeed());
        }
    }

    public Mode getMode() {
        return mode;
    }
}
