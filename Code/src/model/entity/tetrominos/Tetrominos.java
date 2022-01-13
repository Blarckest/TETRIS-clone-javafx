package model.entity.tetrominos;

import javafx.scene.paint.Color;
import model.entity.block.BlockAbs;
import model.utils.CircularList;


public abstract class Tetrominos {
    private BlockAbs[][] matrix;
    private CircularList<BlockAbs[][]> shapeMatrix;

    protected TetroType type = TetroType.NaT;
    protected BlockAbs[] blocks;

    public TetroType getType() {
        return type;
    }

    public void changeColor(Color color) {
        for (var blockLine : matrix)
            for (var block:blockLine) block.setColor(color);
    }
    protected void setMatrix(BlockAbs[][] matrix) {
        this.matrix=matrix;
    }

    protected void setShapeMatrix(CircularList<BlockAbs[][]> shapeMatrix) {
        this.shapeMatrix=shapeMatrix;
    }

    public BlockAbs[][] getCurrentShape(){
        return matrix;
    }

    public BlockAbs[][] getNextShape(){
        return shapeMatrix.getNextShape();
    }

    public BlockAbs[][] getPrecedentShape(){
        return shapeMatrix.getPrecedentShape();
    }

    //todo pb? doit peutetre le mettre dans un rotator
    public void rotateLeft() {
        setMatrix(shapeMatrix.next());
    }

    //todo pb? doit peutetre le mettre dans un rotator
    public void rotateRight() {
        setMatrix(shapeMatrix.precedent());
    }
}
