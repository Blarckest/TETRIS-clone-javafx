package model.utils.rotate;

public interface IRotable {
    int getAngle();
    void rotateTo(int angle);
    void rotateBy(int angle);
    void rotateLeft();
    void rotateRight();
}
