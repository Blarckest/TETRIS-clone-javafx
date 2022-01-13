package model.utils.lineCleaner;

import model.entity.grid.GridAbs;
import model.utils.MatrixMerger;

/**
 * implementation d'un nettoyeur de ligne agissant sur un grid
 */
public record LineCleaner(GridAbs grid) implements ILineCleaner {

    @Override
    public int removeLines() {
        var matrix = grid.matrix;
        int clearedRows = 0;
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
                new MatrixMerger().moveLineDown(grid, ligne);
                matrix = grid.matrix;
            }
        }
        return clearedRows;
    }
}
