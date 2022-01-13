package model.utils.looper;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

import java.util.ArrayList;

public abstract class LooperAbs implements Runnable {
    protected final BooleanProperty gamePaused = new SimpleBooleanProperty();
    protected final BooleanProperty stopThread = new SimpleBooleanProperty();


    public LooperAbs(BooleanProperty gamePausedProperty, BooleanProperty stopThreadProperty) {
        gamePaused.bind(gamePausedProperty);
        stopThread.bind(stopThreadProperty);
    }

    final ArrayList<IObserver> listObserver = new ArrayList<>();

    public void subscribe(IObserver o) {
        listObserver.add(o);
    }

    @Override
    public abstract void run();
}
