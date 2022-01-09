package model.utils;

import java.util.*;


/**
 * @param <E> type of item in the list
 * use next and precedent to move inside this circular list
 */
public class CircularList<E> extends LinkedList {
    private int current=0;
    public E next(){
        if (current==size()){
            current=0;
            return (E) getFirst();
        }
        current++;
        return (E) get(current);
    }
    public E precedent(){
        if (current==0){
            current=size();
            return (E) getLast();
        }
        current--;
        return (E) get(current);
    }
    public int getCurrentIndex(){
        return current;
    }

    public E getNextShape() {
        if (current==size()){
            return (E) getFirst();
        }
        return (E) get(current);
    }

    public E getPrecedentShape() {
        if (current==0){
            return (E) getLast();
        }
        return (E) get(current);
    }
}
