package model.utils.matrix.matrixSlicer;

import model.entity.grid.Grid;
import model.entity.grid.GridAbs;
import model.utils.Couple;

public class MatrixSlicer {
    private final GridAbs grid;
    public MatrixSlicer(GridAbs grid){
        this.grid=grid;
    }
    public Grid subMat(Couple startPoint, int height, int width){
        var mat=new Object[height][width];
        for (int i = startPoint.first; i < width; i++) {
            var line = grid.matrix[i];
            for (int j = startPoint.second; j < height; j++) {
                mat[i][j] = line[j];
            }
        }
        return new Grid(mat);
    }
}
