package model.interfaces;

public interface IRotable {
    int getAngle();
    void rotateTo(int angle);
    void rotateBy(int angle);
}
