package model.entity.grid;

import model.entity.block.BlockAbs;

public class Grid extends GridAbs {
    public Grid(int lignes, int colonnes){
        this.lignes=lignes;
        this.colonnes=colonnes;
        matrix=new BlockAbs[lignes][colonnes];
    }
    public Grid(BlockAbs[][] matrix){
        this.matrix=matrix;
        lignes= matrix.length;
        colonnes=matrix[0].length;
    }

    public Object at(int ligne, int colonne){
        return matrix[ligne][colonne];
    }
    public void setAt(int ligne, int colonne, BlockAbs value){
        matrix[ligne][colonne]=value;
    }
}
