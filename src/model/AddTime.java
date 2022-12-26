/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ADMIN
 */
public class AddTime extends ImageObject {
    
       static AddTime addTime=new AddTime();
    
    private AddTime(int posX, int posY, String path, int type) {
        super(posX, posY, path, type);
    }
        
    private AddTime() {
        super(0,0,"",0);
    }
     public static AddTime getInstance()
    {
        return addTime;
    }
}
