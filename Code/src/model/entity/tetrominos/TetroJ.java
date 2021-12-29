package model.entity.tetrominos;

import javafx.scene.paint.Color;
import model.entity.block.Block;
import model.entity.block.BlockAbs;

public class TetroJ extends Tetrominos{
    public TetroJ(){
        setMatrix(new BlockAbs[][] {{new Block(Color.RED),null,null,null},{new Block(Color.RED), new Block(Color.RED), new Block(Color.RED),null},{null,null,null,null},{null,null,null,null}});
        type=TetroType.J;
    }
}
