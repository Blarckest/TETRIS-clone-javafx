package model.utils;

import model.interfaces.IMovable;

public class Mover {
    private IMovable m_object;
    public Mover(IMovable object){
        m_object=object;
    }
    public void moveTo(Couple couple){
        m_object.setX(couple.first);
        m_object.setY(couple.second);
    }
}
