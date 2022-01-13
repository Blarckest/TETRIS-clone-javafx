package model.utils;

import model.entity.block.BlockAbs;
import model.entity.grid.GridAbs;

/**
 * Classe permettant d'actualiser la matrice contenant les blocks quand cela est nécessaire
 */
public class MatrixMerger {
    /**
     * Méthode permettant de mettre à jour la grille du jeu quadn des blocks ont changé de place ou ont été créés
     * @param grid1 grille du jeu contenant les blocks
     * @param grid2 matrice contenant la forme du tetrominos
     * @param xOffset coordonnée X du tetrominos
     * @param yOffset coordonnée Y du tetrominos
     */
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

    /**
     * Méthode permettant de supprimer une ligne quand elle a été complétée et de faire descendre les blocks au dessus
     * @param grid Grille du jeu contenant les différents blocks
     * @param ligne numéro de la ligne à supprimer
     */
    public void moveLineDown(GridAbs grid, int ligne) {
        for (int i = grid.lines; i > 0; i--) {
            if (i <= ligne) {
                if (grid.columns >= 0) System.arraycopy(grid.matrix[i - 1], 0, grid.matrix[i], 0, grid.columns);
            }
        }
    }

}
