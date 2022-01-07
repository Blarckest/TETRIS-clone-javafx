package model.utils.lineCleaner;

import model.entity.grid.GridAbs;
import model.utils.Couple;
import model.utils.matrix.MatrixMerger;
import model.utils.matrix.matrixSlicer.MatrixSlicer;

public class LineCLeaner implements ILineCleaner {
    private final GridAbs grid;
    public LineCLeaner(GridAbs grid){
        this.grid=grid;
    }

    @Override
    public int removeLines(GridAbs grid) {
        var matrix=grid.matrix;
        int width = matrix.length;
        int lineWidth;
        int clearedRows=0;
        for (int ligne = 0; ligne < matrix.length; ligne++) {
            var rowToClear = true;
            for (int colonne = 0; colonne < matrix[0].length; colonne++) {
                if (matrix[ligne][colonne] == null) {
                    rowToClear = false;
                    break;
                }
            }
            if (rowToClear) {
                clearedRows++;
                new MatrixMerger().merge(new MatrixSlicer(grid).subMat(new Couple(ligne-1,0),ligne-grid.lignes, grid.colonnes), (new MatrixSlicer(grid).subMat(new Couple(0,0),grid.lignes-ligne, grid.colonnes)),-1,0);
                matrix=grid.matrix;
            }
        }
        return clearedRows;
    }
}
