package model.utils.looper;

public class Looper extends LooperAbs {

    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(200);
                for(IObserver o : listObserver){
                    // Peut être utiliser Platform.runLater ????
                    o.doAction();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
