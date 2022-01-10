package model.utils.looper;

import javafx.beans.property.BooleanProperty;

public class Looper extends LooperAbs {

    public Looper(BooleanProperty gamePausedProperty) {
        super(gamePausedProperty);
    }

    @Override
    public void run() {
        while(true){
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
