package model.utils.matrix;

import model.entity.grid.GridAbs;

public class MatrixMerger {
    public void merge(GridAbs grid1, GridAbs grid2, int xOffset, int yOffset) {
        for (int ligne = 0; ligne < grid2.colonnes; ligne++) {
            for (int colonne = 0; colonne < grid2.lignes; colonne++) {
                int targetX = xOffset + ligne;
                int targetY = yOffset + colonne;
                if (grid2.matrix[ligne][colonne] != null) {
                    grid1.setAt(targetY, targetX, grid2.at(ligne, colonne));
                }
            }
        }
    }
}
