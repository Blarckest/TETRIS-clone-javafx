package model.utils.looper;

import javafx.beans.property.BooleanProperty;

/**
 * implementation d'une boucle de 200ms
 */
public class Looper extends LooperAbs {

    /**
     * constructeur permettant la creation d'un looper s'arretant automatiquement en fonction de l'etat du jeu
     *
     * @param gamePausedProperty etat de pause du jeu
     * @param stopThreadProperty etat de marche du jeu
     */
    public Looper(BooleanProperty gamePausedProperty, BooleanProperty stopThreadProperty) {
        super(gamePausedProperty, stopThreadProperty);
    }

    @Override
    public void run() {
        while (!stopThread.getValue()) {
            try {
                Thread.sleep(200);
                if (!gamePaused.getValue())
                    for (IObserver o : listObserver)
                        o.doAction();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
