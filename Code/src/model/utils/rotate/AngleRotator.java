package model.utils.rotate;

public class AngleRotator implements IAngleRotator {
    private final IRotable m_object;
    public AngleRotator(IRotable object){
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
}
