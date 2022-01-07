package model.entity.grid;

public class Grid extends GridAbs {
    public int lignes;
    public int colonnes;
    public Object[][] matrix;

    public Grid(int lignes, int colonnes){
        this.lignes=lignes;
        this.colonnes=colonnes;
        matrix=new Object[lignes][colonnes];
    }
    public Grid(Object[][] matrix){
        this.matrix=matrix;
        lignes= matrix.length;
        colonnes=matrix[0].length;
    }

    public Object at(int ligne, int colonne){
        return matrix[ligne][colonne];
    }
    public void setAt(int ligne, int colonne, Object value){
        matrix[ligne][colonne]=value;
    }
}
