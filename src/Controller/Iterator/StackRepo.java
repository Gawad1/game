/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.Iterator;

import eg.edu.alexu.csd.oop.game.GameObject;
import java.util.ArrayList;

/**
 *
 
 */
public class StackRepo implements Container {

    private ArrayList<GameObject> stack = new ArrayList<GameObject>();

    public Iterator getIterator() {
        return new StackIterator();

    }

    private class StackIterator implements Iterator {

        private int position;

        @Override
        public boolean hasNext() {

            if (position < stack.size()) {
                return true;
            }
            return false;
        }

        @Override
        public GameObject next() {
            if (this.hasNext()) {
                position++;
                return stack.get(position);
            }
            return null;
        }
    }

}
