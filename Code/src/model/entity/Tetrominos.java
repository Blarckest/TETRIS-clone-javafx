package model.entity;

import model.interfaces.IMovable;
import model.interfaces.IRotable;
import model.utils.Couple;
import model.utils.Mover;
import model.utils.Rotator;

public class Tetrominos extends Entity implements IRotable, IMovable {
    @Override
    public void move(Couple couple) {
        new Mover(this).move(couple);
    }

    @Override
    public void moveTo(Couple couple) {
        new Mover(this).moveTo(couple);
    }

    @Override
    public void rotateTo(int angle) {
        new Rotator(this).rotateTo(angle);
    }

    @Override
    public void rotateBy(int angle) {
        new Rotator(this).rotateBy(angle);
    }
}
