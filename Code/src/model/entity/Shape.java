package model.entity;

import javafx.scene.image.Image;

public class Shape {
    private final Image sprite;
    private final Boolean [][] matrix;
    public Shape(Image sprite, Boolean[][] matrix){
        this.sprite=sprite;
        this.matrix=matrix;
    }
}
