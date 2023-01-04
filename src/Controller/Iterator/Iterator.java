/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Controller.Iterator;
import eg.edu.alexu.csd.oop.game.GameObject;
import java.util.List;
import model.ImageObject;

/**
 *
 * @author pc
 */
public interface Iterator {
    public boolean hasNext( );
    public ImageObject next( );
    public void Add(ImageObject o);
    public void Remove(ImageObject i);
    public List List();
    public ImageObject get(int i);
    
}
