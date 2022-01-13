package model.entity.grid;

import model.entity.block.BlockAbs;

public abstract class GridAbs {
    public int lines;
    public int columns;
    public BlockAbs[][] matrix;

    public abstract Object at(int line, int column);

    public abstract void setAt(int line, int column, BlockAbs value);
}
