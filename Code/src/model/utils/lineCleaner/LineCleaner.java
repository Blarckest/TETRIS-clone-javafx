package model.utils.lineCleaner;

import model.entity.grid.GridAbs;
import model.utils.matrix.MatrixMerger;

public class LineCleaner implements ILineCleaner {
    private final GridAbs grid;
    public LineCleaner(GridAbs grid){
        this.grid=grid;
    }

    @Override
    public int removeLines() {
        var matrix=grid.matrix;
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
                for(int i=0;i<grid.lignes;i++){
                    for (int j=0;j<grid.colonnes;j++) {
                        System.out.println(grid.matrix[i][j]);

                    }
                }
                new MatrixMerger().moveLineDown(grid,ligne);
                matrix=grid.matrix;
            }
        }
        return clearedRows;
    }
}
