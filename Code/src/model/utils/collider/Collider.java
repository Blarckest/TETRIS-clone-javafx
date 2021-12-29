package model.utils.collider;

import model.entity.block.BlockAbs;
import model.entity.Grid;
import model.entity.tetrominos.Tetrominos;

public class Collider implements ICollider {
    public static Grid grid=new Grid(); //temporaire, à mettre dans une autre classe
    public static boolean canMoveLeft(){
        throw new UnsupportedOperationException(); //todo
    }

    public static boolean canMoveRight(){
        throw new UnsupportedOperationException();//todo
    }

    public static boolean canMoveDown(){
        throw new UnsupportedOperationException();//todo
    }

    public static boolean canRotate(Tetrominos t){
        for(BlockAbs[] blockLine:t.getBlocks()){
            for(BlockAbs block:blockLine){
                if(grid.isEmptyBox(block.getBoundingRectangle())){
                    throw new UnsupportedOperationException();//todo
                }
            }
        }
        throw new UnsupportedOperationException();//todo
    }

}
