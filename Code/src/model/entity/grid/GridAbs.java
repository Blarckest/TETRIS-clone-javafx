package model.entity.grid;

import model.entity.block.BlockAbs;

public abstract class GridAbs {
    public int lignes;
    public int colonnes;
    public BlockAbs[][] matrix;
    public abstract Object at(int x, int y);
    public abstract void setAt(int x, int y, BlockAbs value);
}
