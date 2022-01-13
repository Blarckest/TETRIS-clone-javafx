package model.utils.looper;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

import java.util.ArrayList;

/**
 * classe abstraite definissant un thread de jeu
 */
public abstract class LooperAbs implements Runnable {
    /**
     * permet de savoir si le jeu est en pause ou pas
     */
    protected final BooleanProperty gamePaused = new SimpleBooleanProperty();
    /**
     * permet de savoir si le jeu est stop (quitter/game over ou autre)
     */
    protected final BooleanProperty stopThread = new SimpleBooleanProperty();

    /**
     * liste des observateur a notifier a chaque boucle
     */
    protected final ArrayList<IObserver> listObserver = new ArrayList<>();

    /**
     * constructeur permettant la creation d'un looper s'arretant automatiquement en fonction de l'etat du jeu
     *
     * @param gamePausedProperty etat de pause du jeu
     * @param stopThreadProperty etat de marche du jeu
     */
    public LooperAbs(BooleanProperty gamePausedProperty, BooleanProperty stopThreadProperty) {
        gamePaused.bind(gamePausedProperty);
        stopThread.bind(stopThreadProperty);
    }

    /**
     * inscrit un observateur aux notifications de bouclage
     *
     * @param o observateur a ajouter a la liste des observateur a notifier a chque boucle
     */
    public void subscribe(IObserver o) {
        listObserver.add(o);
    }

    @Override
    public abstract void run();
}
