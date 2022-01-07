package model.entity.tetrominos;

import javafx.scene.paint.Color;
import model.entity.block.BlockAbs;
import model.entity.Entity;
import model.utils.CircularList;
import model.utils.Couple;

import java.util.List;


public abstract class Tetrominos extends Entity{

    private boolean blocked;
    private BlockAbs[][] matrix;
    private CircularList<BlockAbs[][]> shapeMatrix;

    protected TetroType type=TetroType.NaT;
    protected BlockAbs[] blocks;

    public Tetrominos() {blocked = false;}

    public void setBlocked(){blocked=true;}

    public boolean isBlocked(){return blocked;}

    public TetroType getType(){return type;}

    @Override
    public void move(Couple couple) {
        super.move(couple);
        for (var blockLine:matrix)
            for (var block:blockLine) block.move(couple);
    }

    @Override
    public void moveTo(Couple couple) {
        super.move(couple);
        for (int ligne = 0, matrixLength = matrix.length; ligne < matrixLength; ligne++) {
            BlockAbs[] blockLine = matrix[ligne];
            for (int colonne = 0; colonne < blockLine.length; colonne++) {
                BlockAbs block = blockLine[colonne];
                block.moveTo(new Couple(couple.first+block.getSize().first*ligne, couple.second+block.getSize().second*colonne));
            }
        }
    }

    public void changeColor(Color color){
        for (var blockLine:matrix)
            for (var block:blockLine) block.setColor(color);
    }
    protected void setMatrix(BlockAbs[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            BlockAbs[] blockLine = matrix[i];
            for (int j = 0; j < blockLine.length; j++) {
                BlockAbs block = blockLine[j];
                block.moveTo(new Couple(getX()+block.getSize().first*i,getY()+block.getSize().second*j));
            }
        }
        this.matrix=matrix;
    }

    protected void setShapeMatrix(CircularList<BlockAbs[][]> shapeMatrix) {
        this.shapeMatrix=shapeMatrix;
    }

    public BlockAbs[][] getCurrentShape(){
        return matrix;
    }

    public BlockAbs[][] getNextShape(){
        var nextShape=(CircularList<BlockAbs[][]>)List.copyOf(shapeMatrix);
        return (BlockAbs[][]) nextShape.next();
    }

    public BlockAbs[][] getPrecedentShape(){
        var nextShape=(CircularList<BlockAbs[][]>)List.copyOf(shapeMatrix);
        return (BlockAbs[][]) nextShape.precedent();
    }

    //pb? doit peutetre le mettre dans un rotator
    public void rotateLeft() {
        setMatrix((BlockAbs[][]) shapeMatrix.precedent());
    }

    //pb? doit peutetre le mettre dans un rotator
    public void rotateRight() {
        setMatrix((BlockAbs[][]) shapeMatrix.next());
    }
}
