package model.entity.tetrominos;

import javafx.scene.paint.Color;
import model.entity.block.Block;
import model.entity.block.BlockAbs;

public class TetroL extends Tetrominos{
    public TetroL(){
        setMatrix(new BlockAbs[][] {{null,null, new Block(Color.YELLOW),null},{new Block(Color.YELLOW), new Block(Color.YELLOW), new Block(Color.YELLOW),null},{null,null,null,null},{null,null,null,null}});
        type=TetroType.L;
    }
}
