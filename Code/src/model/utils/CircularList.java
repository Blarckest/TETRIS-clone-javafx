package model.utils;

import java.util.*;


/**
 * @param <E> type of item in the list
 * use next and precedent to move inside this circular list
 */
public class CircularList<E> extends LinkedList {
    private int current=0;
    public Object next(){
        if (current==size()){
            current=0;
            return getFirst();
        }
        current++;
        return get(current);
    }
    public Object precedent(){
        if (current==0){
            current=size();
            return getLast();
        }
        current--;
        return get(current);
    }
}
