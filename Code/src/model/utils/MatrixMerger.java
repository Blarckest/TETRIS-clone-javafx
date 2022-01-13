package model.utils;

import model.entity.block.BlockAbs;
import model.entity.grid.GridAbs;

public class MatrixMerger {
    public void merge(GridAbs grid1, BlockAbs[][] grid2, int xOffset, int yOffset) {
        for (int ligne = 0; ligne < grid2.length; ligne++) {
            for (int colonne = 0; colonne < grid2[0].length; colonne++) {
                int line = xOffset + ligne;
                int column = yOffset + colonne;
                if (grid2[ligne][colonne] != null) {
                    grid1.setAt(column, line, grid2[ligne][colonne]);
                }
            }
        }
    }

    public void moveLineDown(GridAbs grid, int ligne) {
        for (int i = grid.lines; i > 0; i--) {
            if (i <= ligne) {
                if (grid.columns >= 0) System.arraycopy(grid.matrix[i - 1], 0, grid.matrix[i], 0, grid.columns);
            }
        }
    }

}
