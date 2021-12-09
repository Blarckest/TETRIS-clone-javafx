package model.entity;

import model.utils.Couple;

public abstract class Entity {
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

    public int getX() {
        return location.first;
    }

    public int getY() {
        return location.second;
    }

    public int getAngle() { return angle; }

    public void setX(int x) { location.first = x; }

    public void setY(int y) {
        location.second = y;
    }

    public void setAngle(int angle) { this.angle = angle; }
}
