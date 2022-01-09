package model.utils;

import java.util.*;


/**
 * @param <E> type of item in the list
 * use next and precedent to move inside this circular list
 */
public class CircularList<E> extends LinkedList {
    private int current=0;
    public E next(){
        current++;
        return (E) get(Math.abs(current%size()));
    }
    public E precedent(){
        current--;
        return (E) get(Math.abs(current%size()));
    }
    public int getCurrentIndex(){
        return Math.abs(current%size());
    }

    public E getNextShape() {
        return (E) get(Math.abs((current+1)%size()));
    }

    public E getPrecedentShape() {
        return (E) get(Math.abs((current-1)%size()));
    }
}
