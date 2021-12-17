package model.utils;

import model.entity.BlockAbs;
import model.entity.Grid;
import model.entity.Tetrominos.Tetrominos;
import model.interfaces.ICollider;

public class Collider implements ICollider {
    public static Grid grid=new Grid(); //temporaire, à mettre dans une autre classe
    public static boolean canMoveLeft(){

    }

    public static boolean canMoveRight(){

    }

    public static boolean canMoveDown(){

    }

    public static boolean canRotate(Tetrominos t){
        for(BlockAbs[] blockLine:t.getBlocks()){
            for(BlockAbs block:blockLine){
                if(grid.isEmptyBox(block.getCenter())){

                }
            }
        }
    }

    public static boolean canMoveLeft(){

    }
}
