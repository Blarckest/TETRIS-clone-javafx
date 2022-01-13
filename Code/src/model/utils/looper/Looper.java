package model.utils.looper;

import javafx.beans.property.BooleanProperty;

public class Looper extends LooperAbs {

    public Looper(BooleanProperty gamePausedProperty, BooleanProperty stopThreadProperty) {
        super(gamePausedProperty, stopThreadProperty);
    }

    @Override
    public void run() {
        while(!stopThread.getValue()){
            try {
                Thread.sleep(200);
                if (gamePaused.getValue()==false)
                    for(IObserver o : listObserver)
                        o.doAction();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
