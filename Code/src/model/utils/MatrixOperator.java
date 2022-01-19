package model.utils;

import model.entity.block.BlockAbs;
import model.entity.grid.GridAbs;

/**
 * classe capable d'effectuer des actions sur une grid et une matrice
 */
public class MatrixOperator {
    /**
     * permet de merger une matrice dans la grid les objet de la grid ne sont pas modifier seul des ajout sont possible aucune suppression n'est effectuer
     *
     * @param grid1        grid sur laquel on merge
     * @param grid2        matrice a merger
     * @param columnOffset ligne a laquel on merge
     * @param ligneOffset  colonne a laquel on merge
     */
    public void merge(GridAbs grid1, BlockAbs[][] grid2, int columnOffset, int ligneOffset) {
        for (int ligne = 0; ligne < grid2.length; ligne++) {
            for (int colonne = 0; colonne < grid2[0].length; colonne++) {
                int line = ligneOffset + ligne;
                int column = columnOffset + colonne;
                if (grid2[ligne][colonne] != null) {
                    grid1.setAt(line, column, grid2[ligne][colonne]);
                }
            }
        }
    }

    /**
     * Méthode permettant de supprimer une ligne quand elle a été complétée et de faire descendre les blocks au dessus     *
     * @param grid  grid sur laquelle effectuer l'action
     * @param ligne ligne a descendre ou supprimer
     */
    public void moveLineDown(GridAbs grid, int ligne) {
        for (int i = grid.lines; i > 0; i--) {
            if (i <= ligne) {
                if (grid.columns >= 0) System.arraycopy(grid.matrix[i - 1], 0, grid.matrix[i], 0, grid.columns);
            }
        }
    }

}
