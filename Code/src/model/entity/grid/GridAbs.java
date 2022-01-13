package model.entity.grid;

import model.entity.block.BlockAbs;

/**
 * Objet contenant les informations sur la matrice du jeu
 */
public abstract class GridAbs {
    /**
     * nombre de lignes de la matrice
     */
    public int lines;
    /**
     * nombre de colonnes de la matrice
     */
    public int columns;
    /**
     * tableau de block/matrice du jeu
     */
    public BlockAbs[][] matrix;

    /**
     * permet de recuperer le block a l'emplacement souhaiter
     *
     * @param line   ligne a acceder
     * @param column colonne a acceder
     * @return le block a la position voulue
     */
    public abstract BlockAbs at(int line, int column);

    /**
     * permet de changer la valeur de l'emplacement souhaiter
     *
     * @param line   ligne a modifier
     * @param column colonne a modifier
     * @param value  valeur a donner a l'emplacement
     */
    public abstract void setAt(int line, int column, BlockAbs value);
}
