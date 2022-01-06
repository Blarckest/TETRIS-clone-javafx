package model.utils.rotate;

public class Rotator implements IRotator {
    private final IRotable m_object;
    public Rotator(IRotable object){
        m_object=object;
    }
    @Override
    public void rotateBy(int angle) {
        m_object.rotateTo(m_object.getAngle()+angle);
    }

    @Override
    public void rotateTo(int angle) {
        m_object.rotateTo(angle);
    }

    @Override
    public void rotateLeft(IRotable rotable) {
        rotable.rotateLeft();
    }

    @Override
    public void rotateRight(IRotable rotable) {
        rotable.rotateRight();
    }
}
