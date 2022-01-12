package model.utils.looper;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

import java.util.ArrayList;

public abstract class LooperAbs implements Runnable{
    protected BooleanProperty gamePaused = new SimpleBooleanProperty();
    protected BooleanProperty gameOver = new SimpleBooleanProperty();


    public LooperAbs(BooleanProperty gamePausedProperty, BooleanProperty gameOverProperty){gamePaused.bind(gamePausedProperty); gameOver.bind(gameOverProperty);}

    ArrayList<IObserver> listObserver = new ArrayList<>();

    public void subscribe(IObserver o){
        listObserver.add(o);
    }

    @Override
    public abstract void run();
}
