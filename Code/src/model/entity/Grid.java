package model.entity;

import model.utils.Couple;

public class Grid {
    public static final int lignes=20;
    public static final int colonnes=12;
    public int[][] matrix;

    public Grid(){
        matrix=new int[lignes][colonnes];
    }

    public boolean isEmptyBox(Couple couple){
        return matrix[couple.second][couple.first]==0;
    }
}
