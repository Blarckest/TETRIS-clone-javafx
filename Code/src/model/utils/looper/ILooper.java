package model.utils.looper;

import java.util.ArrayList;

public abstract class ILooper implements Runnable{
    ArrayList<IObserver> listObserver = new ArrayList<>();

    public void subscribe(IObserver o){
        listObserver.add(o);
    }

    @Override
    public abstract void run();
}
