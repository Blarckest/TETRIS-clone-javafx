package model.utils.collider;

import model.entity.grid.Grid;
import model.entity.grid.IGrid;
import model.entity.tetrominos.Tetrominos;

public class GridCollider implements ICollider {
    public final IGrid grid;
    public GridCollider(IGrid grid){
        this.grid=grid;
    }
    public boolean canMoveLeft(Tetrominos t, int xOffset, int yOffSet){
        var matTetro=t.getCurrentShape();
        for (int i = 0; i < matTetro.length; i++) {
            for (int j=0; j< matTetro[i].length;j++){
                int targetX = xOffset + i;
                int targetY = yOffSet + j;
                if (matTetro[j][i] != null && (checkOutOfBound(targetX, targetY) || grid.at(targetY,targetX) != )) {
                    return true;
                }
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
