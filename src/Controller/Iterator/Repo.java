/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.Iterator;

import eg.edu.alexu.csd.oop.game.GameObject;
import java.util.ArrayList;
import java.util.List;
import model.ImageObject;

/**
 *
 *
 */
public class Repo implements Container {

    public Iterator getIterator() {
        return new StackIterator();

    }

    private class StackIterator implements Iterator {

        private int position = 0;
        private ArrayList<ImageObject> stack = new ArrayList<ImageObject>();

        @Override
        public boolean hasNext() {

            if (position < stack.size()) {
                return true;
            }
            position=0;
            return false;
        }

        @Override
        public ImageObject next() {
            if (this.hasNext()) {
                return stack.get(position++);
            }
            return null;
        }

        @Override
        public void Add(ImageObject o) {
            stack.add(o);
        }

        @Override
        public void Remove(ImageObject i) {
            stack.remove(i);
        }

        @Override
        public List List() {
            return stack;
        }

        @Override
        public ImageObject get(int i) {
            return stack.get(i);
        }

        @Override
        public void pos() {
            position = 0;
        }

    }

}
