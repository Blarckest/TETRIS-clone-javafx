package model.entity.tetrominos;

import javafx.scene.paint.Color;
import model.entity.block.Block;
import model.entity.block.BlockAbs;

public class TetroT extends Tetrominos{
    public TetroT(){
        setMatrix(new BlockAbs[][] {{null,new Block(Color.CYAN),null,null},{new Block(Color.CYAN), new Block(Color.CYAN), new Block(Color.CYAN),null},{null,null,null,null},{null,null,null,null}});
        type=TetroType.T;
    }
}
