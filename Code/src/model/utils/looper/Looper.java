package model.utils.looper;

import javafx.beans.property.BooleanProperty;

public class Looper extends LooperAbs {

    public Looper(BooleanProperty gamePausedProperty, BooleanProperty gameOverProperty) {
        super(gamePausedProperty, gameOverProperty);
    }

    @Override
    public void run() {
        while(!gameOver.getValue()){
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
