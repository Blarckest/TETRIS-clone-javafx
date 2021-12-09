package model.utils;

import model.interfaces.IMovable;
import model.interfaces.IMover;

public class Mover implements IMover {
    private IMovable m_object;
    public Mover(IMovable object){
        m_object=object;
    }

    @Override
    public void move(Couple couple) {

    }

    @Override
    public void moveTo(Couple couple){
        m_object.setX(couple.first);
        m_object.setY(couple.second);
    }
}
