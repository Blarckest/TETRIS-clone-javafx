package model.utils;

import java.util.LinkedList;


/**
 * implementation d'une liste circulaire
 *
 * @param <E> type of item in the list
 */
public class CircularList<E> extends LinkedList {
    private int current = 0;

    /**
     * permet d'aller au prochain objet de la liste
     *
     * @return le prochain objet de la liste
     */
    public E next() {
        current++;
        return (E) get(Math.abs(current % size()));
    }

    /**
     * permet d'aller au precdent objet de la liste
     *
     * @return le precedent objet de la liste
     */
    public E precedent() {
        current--;
        return (E) get(Math.abs(current % size()));
    }

    /**
     * permet de savoir l'indice actuel
     *
     * @return index courant de la liste
     */
    public int getCurrentIndex() {
        return Math.abs(current % size());
    }

    /**
     * permet de regarder le prochain objet de la liste
     *
     * @return le prochain objet de la liste
     */
    public E getNextShape() {
        return (E) get(Math.abs((current + 1) % size()));
    }

    /**
     * permet de regarder le prochain objet de la liste
     *
     * @return le precedent objet de la liste
     */
    public E getPrecedentShape() {
        return (E) get(Math.abs((current - 1) % size()));
    }
}
