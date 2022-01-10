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

    public void merge2(GridAbs grid, int ligne) {
        for (int i= grid.lignes; i >0; i--) {
            if(i<=ligne){
                for(int j=0; j< grid.colonnes;j++){
                    grid.matrix[i][j]=grid.matrix[i-1][j];
                }
            }
        }
    }

}
