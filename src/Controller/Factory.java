/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import model.AddTime;
import model.Bomb;
import model.Bowl;
import model.ImageObject;
import model.Plates;
import model.ScoreMultiplier;

/**
 *
 * @author ADMIN
 */
public class Factory {
     static public ImageObject getInstanceof(int x,int y, String path,int type)
    {
     if (type ==1)
     {
       if(path=="bowl1.png")
           return new Bowl(x,y,path,type);
       return new Plates(x,y,path,type);
     }
     else if (type==2)
     {
         if(path=="bowl2.png")
           return new Bowl(x,y,path,type);
       return new Plates(x,y,path,type);
     }
     else if (type ==3)
     {
         if(path=="bowl3.png")
           return new Bowl(x,y,path,type);
       return new Plates(x,y,path,type);
     }
     else if(type==4){
         if(path=="bowl4.png")
           return new Bowl(x,y,path,type);
       return new Plates(x,y,path,type);
     }
     else if(type==5){
         return new Bomb(x,y,path,type);
     }
     else if(type==6){
         return ScoreMultiplier.getInstance();
     }
     else if(type==7){
         return ScoreMultiplier.getInstance();
     }
     else
         return null;
    }}
