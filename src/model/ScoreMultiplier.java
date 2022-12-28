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
    static ScoreMultiplier scoreMultiplier=null;
    
        
    private ScoreMultiplier() {
        super((int) (Math.random() * 300), -(int) (Math.random() * 675), "/ScoreMultiplier.png", 6);
    }
     public static ScoreMultiplier getInstance()
    {
        if(scoreMultiplier==null)
            scoreMultiplier=new ScoreMultiplier();
        return scoreMultiplier;
    }
}
