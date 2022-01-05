package model.utils.collider;

import javafx.scene.effect.ColorInput;
import model.entity.block.BlockAbs;
import model.entity.Grid;
import model.entity.tetrominos.Tetrominos;
import model.utils.Couple;

public class GridCollider implements ICollider {
    public final Grid grid;
    public GridCollider(Grid grid){
        this.grid=grid;
    }
    public boolean canMoveLeft(Tetrominos t){
        var matTetro=t.getBlocks();
        var matGrid = grid.subMat(new Couple(t.getX(), t.getY()),matTetro[0].length,matTetro.length+1);
        for (int i = 0; i < matTetro.length; i++) {
            BlockAbs[] line = matTetro[i];
            for (int j=0; j< matTetro[0].length;j++){
            }
        }
        throw new UnsupportedOperationException(); //todo
    }

    public boolean canMoveRight(Tetrominos t){
        throw new UnsupportedOperationException(); //todo
    }

    public boolean canMoveDown(Tetrominos t){
        throw new UnsupportedOperationException(); //todo
    }

    public boolean canRotate(Tetrominos t){
        for(var blockLine:t.getBlocks()){
            for(var block:blockLine){
                if(grid.isEmptyBox(block.getBoundingRectangle())){
                    throw new UnsupportedOperationException();//todo
                }
            }
        }
        throw new UnsupportedOperationException();//todo
    }

}
