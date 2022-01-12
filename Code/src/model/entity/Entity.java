package model.entity;

import model.utils.Couple;
import model.utils.rotate.move.IMovable;
import model.utils.rotate.move.Mover;
import model.utils.rotate.IRotable;
import model.utils.rotate.AngleRotator;

public abstract class Entity implements IMovable, IRotable {
    protected Couple location;
    protected int angle;

    public Entity(){
        this(0,0,0);
    }

    public Entity(Couple location, int angle){
        this.location=location;
        this.angle=angle;
    }

    public Entity(int x, int y , int angle){
        this(new Couple(x,y),angle);
    }

    @Override
    public int getX() {
        return location.first;
    }

    @Override
    public int getY() {
        return location.second;
    }

    @Override
    public int getAngle() { return angle; }

    @Override
    public void setX(int x) { location.first = x; }

    @Override
    public void setY(int y) {
        location.second = y;
    }

    @Override
    public void rotateTo(int angle) {
        new AngleRotator(this).rotateTo(angle);
    }

    @Override
    public void rotateBy(int angle) {
        new AngleRotator(this).rotateBy(angle);
    }

    @Override
    public void move(Couple couple) {
        new Mover(this).move(couple);
    }

    @Override
    public void moveTo(Couple couple) {
        new Mover(this).moveTo(couple);
    }
}
