package model.entity.grid;

import javafx.geometry.Rectangle2D;
import model.utils.Couple;

public class Grid {
    public final int lignes=20;
    public final int colonnes=12;
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
}
