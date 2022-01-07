package model.entity.grid;

public class Grid extends GridAbs {
    public final int lignes=20;
    public final int colonnes=12;
    public Object[][] matrix;

    public Grid(){
        matrix=new Object[lignes][colonnes];
    }
    public Grid(Object[][] matrix){
        this.matrix=matrix;
    }

    public Object at(int ligne, int colonne){
        return matrix[ligne][colonne];
    }
    public void setAt(int ligne, int colonne, Object value){
        matrix[ligne][colonne]=value;
    }
}
