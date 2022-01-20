package model.entity.grid;

import model.entity.block.BlockAbs;

/**
 * implementation d'un objet contenant les informations sur la matrice du jeu
 */
public class Grid extends GridAbs {
    /**
     * construit une matrice de la taille souhaiter
     *
     * @param lines   nombre de ligne de la matrice
     * @param columns nombre de colonne de la matrice
     */
    public Grid(int lines, int columns) {
        this.lines = lines;
        this.columns = columns;
        matrix = new BlockAbs[lines][columns];
    }

    /**
     * construit l'objet a partir d'une matrice preexistante
     *
     * @param matrix matrix a partir de laquelle sera construit la grid
     */
    public Grid(BlockAbs[][] matrix) {
        this.matrix = matrix;
        lines = matrix.length;
        columns = matrix[0].length;
    }

    @Override
    public BlockAbs at(int line, int column) {
        return matrix[line][column];
    }

    @Override
    public void setAt(int line, int column, BlockAbs value) {
        matrix[line][column] = value;
    }
}
