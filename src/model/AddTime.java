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
    
       static AddTime addTime=null;
    
    
        
    private AddTime() {
        super((int)(Math.random() * 900), -(int) (Math.random() * 675), "/Clock.png", 7);
    }
     public static AddTime getInstance()
    {
        if(addTime==null)
            addTime=new AddTime();
        return addTime;
    }
}
