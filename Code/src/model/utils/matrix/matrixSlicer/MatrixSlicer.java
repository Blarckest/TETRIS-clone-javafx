package model.utils.matrix.matrixSlicer;

import model.entity.block.BlockAbs;
import model.entity.grid.Grid;
import model.entity.grid.GridAbs;
import model.utils.Couple;

public class MatrixSlicer {
    private final GridAbs grid;
    public MatrixSlicer(GridAbs grid){
        this.grid=grid;
    }
    public Grid subMat(Couple startPoint, int height, int width){
        var mat=new BlockAbs[height][width];
        for (int i = startPoint.first; i < height; i++) {
            var line = grid.matrix[grid.lignes-i-1];
            for (int j = startPoint.second; j < width; j++) {
                mat[i][j] = line[j];
            }
        }
        return new Grid(mat);
    }
}
