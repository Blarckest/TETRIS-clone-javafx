package model.entity.Tetrominos;

import model.entity.BlockAbs;
import model.entity.Entity;
import model.interfaces.IMovable;
import model.interfaces.IRotable;
import model.utils.Couple;
import model.utils.Mover;
import model.utils.Rotator;

public abstract class Tetrominos extends Entity implements IRotable, IMovable {
    private boolean blocked;
    private BlockAbs matrix[][];
    protected TetroType type=TetroType.NaT;
    public Tetrominos() {
        blocked = false;
    }
    public BlockAbs[][] getMatrix() {return matrix;}
    protected void setMatrix(BlockAbs[][] matrix) {this.matrix = matrix;}

    public void setBlocked(){blocked=true;}
    public boolean isBlocked(){return blocked;}

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

    public TetroType getType(){return type;}

    public BlockAbs[][] getBlocks(){
        return matrix;
    }
}
