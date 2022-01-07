package model.utils.collider;

import model.entity.grid.GridAbs;
import model.entity.tetrominos.Tetrominos;

public class GridCollider implements ICollider {
    public final GridAbs grid;
    public GridCollider(GridAbs grid){
        this.grid=grid;
    }
    public boolean canMoveLeft(Tetrominos t, int xOffset, int yOffSet){
        var matTetro=t.getCurrentShape();
        for (int i = 0; i < matTetro.length; i++) {
            for (int j=0; j< matTetro[i].length;j++){
                int targetX = xOffset + i;
                int targetY = yOffSet + j;
                if (matTetro[i][j] != null && (checkOutOfBound(targetX, targetY) || grid.at(targetX,targetY) !=  null)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkOutOfBound(int targetX, int targetY) {
        if (targetX >= 0 && targetY < grid.lignes && targetX < grid.colonnes) {
            return false;
        }
        return true;
    }
}
