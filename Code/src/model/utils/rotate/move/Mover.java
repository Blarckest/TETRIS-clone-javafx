package model.utils.rotate.move;

import model.utils.Couple;

public class Mover implements IMover {
    private final IMovable m_object;
    public Mover(IMovable object){
        m_object=object;
    }

    @Override
    public void move(Couple couple) {
        m_object.setX(m_object.getX()+couple.first);
        m_object.setY(m_object.getY()+couple.second);
    }

    @Override
    public void moveTo(Couple couple){
        m_object.setX(couple.first);
        m_object.setY(couple.second);
    }

}
