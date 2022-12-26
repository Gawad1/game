/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import model.Bomb;
import model.Bowl;
import model.ImageObject;
import model.Plates;

/**
 *
 * @author ADMIN
 */
public class Factory {
     static public ImageObject getInstanceof(int x,int y, String path,int type)
    {
     if (type ==1)
        {
           
            return new Plates(x,y,path,type);
        }
     else if (type==2)
     {
         return new Bowl(x,y,path,type);
     }
     else if (type ==3)
     {
         return new Bomb(x,y,path,type);
     }
     else 
         return null;
    }}
