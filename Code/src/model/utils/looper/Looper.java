package model.utils.looper;

import model.utils.looper.ILooper;

public class Looper extends ILooper {

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(200);
                for(IObserver o : listObserver){
                    o.doAction();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
