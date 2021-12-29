package model.entity.tetrominos;

import javafx.scene.paint.Color;
import model.entity.block.Block;
import model.entity.block.BlockAbs;
import model.entity.Entity;
import model.utils.Couple;


public abstract class Tetrominos extends Entity{

    private boolean blocked;
    private BlockAbs[][] matrix;
    protected TetroType type=TetroType.NaT;

    public Tetrominos() {blocked = false;}

    public BlockAbs[][] getBlocks(){
        return matrix;
    }


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
        for (int i = 0, matrixLength = matrix.length; i < matrixLength; i++) {
            BlockAbs[] blockLine = matrix[i];
            for (int j = 0; j < blockLine.length; j++) {
                BlockAbs block = blockLine[j];
                block.moveTo(new Couple(couple.first+block.getSize().first*i, couple.second+block.getSize().second*j));
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
}
