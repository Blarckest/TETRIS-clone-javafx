package model.utils.rotate.move;

import model.utils.Couple;

public interface IMovable {
    void move(Couple couple);
    void moveTo(Couple couple);
    int getX();
    int getY();
    void setX(int newX);
    void setY(int newY);
}
