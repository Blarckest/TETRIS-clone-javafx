package model.entity.grid;

public abstract class IGrid {
    public int ligne;
    public int colonnes;
    public int[][] matrix;
    public abstract int at(int x, int y);
    public abstract void setAt(int x, int y, int value);
}
