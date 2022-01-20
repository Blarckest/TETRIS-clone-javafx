package model.utils;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;

import java.time.LocalDateTime;

/**
 * Classe contenant les informations concernant le score du joueur ainsi que la date a laquelle il l'a effectue
 * Cette classe contient aussi les methodes permettant d'avoir acces au score et d'agir dessus
 */
public class Score {
    //LES PROPERTY SONT PAS SERIALIZABLE DONC ON SERIALIZE A LA MAIN

    /**
     * propriete contenant le score
     */
    private final transient IntegerProperty scoreProperty;

    /**
     * retourne le score actuel
     *
     * @return score actuel
     */
    public int getScore() {
        return scoreProperty.getValue();
    }

    /**
     * retourne la propriete contenant le score
     *
     * @return propriete contenant le score
     */
    public IntegerProperty getScoreProperty() {
        return scoreProperty;
    }

    /**
     * propriete contenant la date a laquelle a ete effectuer le score
     */
    private final transient SimpleObjectProperty<LocalDateTime> dateProperty;

    /**
     * retourne la date associe au score
     *
     * @return date associe au score
     */
    public LocalDateTime getDate() {
        return dateProperty.getValue();
    }

    /**
     * retourne la propriete contenant le date associe au score
     *
     * @return propriete contenant le date associe au score
     */
    public ObjectProperty<LocalDateTime> getDateProperty() {
        return dateProperty;
    }

    /**
     * constructeur par defaut score=0 date=date actuelle
     */
    public Score() {
        this(0, LocalDateTime.now());
    }

    /**
     * constructeur permettant de specifier un score et une date
     *
     * @param value       score
     * @param timeOfScore date du score
     */
    public Score(int value, LocalDateTime timeOfScore) {
        scoreProperty = new SimpleIntegerProperty(value);
        dateProperty = new SimpleObjectProperty<>(timeOfScore);
    }

    /**
     * ajoute i au score
     *
     * @param i ajoute i au score actuel
     */
    public void add(int i) {
        scoreProperty.setValue(scoreProperty.getValue() + i);
    }

    /**
     * reset le score a 0
     */
    public void reset() {
        scoreProperty.setValue(0);
    }
}
