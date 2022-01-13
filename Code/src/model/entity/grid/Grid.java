package model.entity.grid;

import model.entity.block.BlockAbs;

public class Grid extends GridAbs {
    public Grid(int lines, int columns) {
        this.lines = lines;
        this.columns = columns;
        matrix = new BlockAbs[lines][columns];
    }

    public Grid(BlockAbs[][] matrix) {
        this.matrix = matrix;
        lines = matrix.length;
        columns = matrix[0].length;
    }

    public Object at(int line, int column) {
        return matrix[line][column];
    }

    public void setAt(int line, int column, BlockAbs value) {
        matrix[line][column] = value;
    }
}
