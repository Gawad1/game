/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ADMIN
 */
public class Clown extends ImageObject {

    static Clown clown= new Clown();
    public Clown(int posX, int posY, String path, int type) {
        super(posX, posY, path, type);
    }
    public Clown(){
        super(0,0,"",0);
    }
    public static Clown getinstace(){
        return clown;
    }

    @Override
    public void setY(int mY) {
        
    }

}
