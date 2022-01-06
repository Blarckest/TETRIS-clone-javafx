package model.utils.matrixSlicer;

import model.entity.grid.Grid;
import model.entity.grid.IGrid;
import model.utils.Couple;

public class MatrixSlicer {
    private final IGrid grid;
    public MatrixSlicer(IGrid grid){
        this.grid=grid;
    }
    public Grid subMat(Couple startPoint, int height, int width){
        var mat=new int[height][width];
        for (int i = startPoint.first; i < width; i++) {
            int[] line = grid.matrix[i];
            for (int j = startPoint.second; j < height; j++) {
                mat[i][j] = line[j];
            }
        }
        return new Grid(mat);
    }
}
