package model.entity.grid;

public abstract class GridAbs {
    public int lignes;
    public int colonnes;
    public Object[][] matrix;
    public abstract Object at(int x, int y);
    public abstract void setAt(int x, int y, Object value);
}
