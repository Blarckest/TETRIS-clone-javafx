package model.entity.tetrominos;

import javafx.scene.paint.Color;
import model.entity.block.Block;
import model.entity.block.BlockAbs;

public class TetroI extends Tetrominos{
    public TetroI(){
        setMatrix(new BlockAbs[][] {{null,null,null,null},{new Block(Color.BLUE), new Block(Color.BLUE), new Block(Color.BLUE), new Block(Color.BLUE)},{null,null,null,null},{null,null,null,null}});
        type=TetroType.I;
    }
}