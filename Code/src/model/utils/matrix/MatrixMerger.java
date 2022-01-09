package model.utils.matrix;

import model.entity.block.BlockAbs;
import model.entity.grid.GridAbs;

public class MatrixMerger {
    public void merge(GridAbs grid1, BlockAbs[][] grid2, int xOffset, int yOffset) {
        for (int ligne = 0; ligne < grid2.length; ligne++) {
            for (int colonne = 0; colonne < grid2[0].length; colonne++) {
                int targetX = xOffset + ligne;
                int targetY = yOffset + colonne;
                if (grid2[ligne][colonne] != null) {
                    grid1.setAt(targetY, targetX, grid2[ligne][colonne]);
                }
            }
        }
    }
}
