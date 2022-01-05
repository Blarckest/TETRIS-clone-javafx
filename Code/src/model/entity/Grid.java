package model.entity;

import javafx.geometry.Rectangle2D;
import model.utils.Couple;

public class Grid {
    public static final int lignes=20;
    public static final int colonnes=12;
    public int[][] matrix;

    public Grid(){
        matrix=new int[lignes][colonnes];
    }
    public Grid(int[][] matrix){
        this.matrix=matrix;
    }


    public boolean isEmptyBox(Couple dimensions){
        return matrix[dimensions.second][dimensions.first]==0;
    }
    public boolean isEmptyBox(Rectangle2D dimensions){return isEmptyBox(new Couple((int)dimensions.getMaxX(),(int)dimensions.getMaxY()));}

    public int at(int x, int y){
        return matrix[x][y];
    }
    public void setAt(int x, int y, int value){
        matrix[x][y]=value;
    }

    public Grid subMat(Couple startPoint, int height, int width){
        var mat=new int[height][width];
        for (int i = startPoint.first; i < width; i++) {
            int[] line = matrix[i];
            for (int j = startPoint.second; j < height; j++) {
                mat[i][j] = line[j];
            }
        }
        return new Grid(mat);
    }
}
