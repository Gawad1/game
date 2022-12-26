/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ADMIN
 */
public class Bomb extends ImageObject{
    
    public Bomb(int posX, int posY, String path, int type) {
        super(posX, posY, path, type);
    }
    public Bomb()
    {
        super(0,0,"",0);
    }
    
}
