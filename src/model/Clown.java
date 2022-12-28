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

    private static Clown clown=null;

    private Clown(){
        super(300,(int)(675*0.65),"/clown.png",0);
    }
    public static Clown getinstace(){
        if (clown==null)
           clown=new Clown();
        return clown;
    }

    @Override
    public void setY(int mY) {
        
    }

}
