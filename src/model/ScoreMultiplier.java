/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ADMIN
 */
public class ScoreMultiplier extends ImageObject {
    static ScoreMultiplier scoreMultiplier=new ScoreMultiplier();
    
    private ScoreMultiplier(int posX, int posY, String path, int type) {
        super(posX, posY, path, type);
    }
        
    private ScoreMultiplier() {
        super(0,0,"",0);
    }
     public static ScoreMultiplier getInstance()
    {
        return scoreMultiplier;
    }
}
