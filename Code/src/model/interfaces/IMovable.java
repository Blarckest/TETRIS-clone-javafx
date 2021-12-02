package model.interfaces;

import model.utils.Couple;

public interface IMovable {
    void move(Couple couple);
    Number getX();
    Number getY();
    Number setX(Number newX);
    Number setY(Number newY);
}
