package model.utils;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;

import java.time.LocalDateTime;

/**
 * Classe contenant les informations concernant le score du joueur ainsi que la date à laquelle il l'a effectué
 * Cette classe contient aussi les méthodes permettant d'avoir accès au score et d'agir dessus
 */
public class Score {
    //LES PROPERTY SONT PAS SERIALIZABLE DONC ON SERIALIZE A LA MAIN

    private final transient IntegerProperty scoreProperty;

    public int getScore() {
        return scoreProperty.getValue();
    }

    public IntegerProperty scoreProperty() {
        return scoreProperty;
    }

    private final transient SimpleObjectProperty<LocalDateTime> dateProperty;

    public LocalDateTime getDate() {
        return dateProperty.getValue();
    }
    public ObjectProperty<LocalDateTime> dateProperty() {
        return dateProperty;
    }

    public Score(){
        this(0, LocalDateTime.now());
    }

    public Score(int value, LocalDateTime timeOfScore){
        scoreProperty = new SimpleIntegerProperty(value);
        dateProperty = new SimpleObjectProperty<>(timeOfScore);
    }

    public void add(int i){
        scoreProperty.setValue(scoreProperty.getValue() + i);
    }

    public void reset() {
        scoreProperty.setValue(0);
    }
}
