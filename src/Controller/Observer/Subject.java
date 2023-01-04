/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Controller.Observer;

/**
 *
 * @author ADMIN
 */
public interface Subject {
    void setVisualState(boolean state);
    void notifyAllObservers();
    void Attach (Observer observer );
   
}
