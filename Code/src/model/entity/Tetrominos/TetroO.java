package model.entity.Tetrominos;

import javafx.scene.paint.Color;
import model.entity.Block;
import model.entity.BlockAbs;

public class TetroO extends Tetrominos{
    public TetroO(){
        setMatrix(new BlockAbs[][] {{null,null,null,null},{null, new Block(Color.GREEN), new Block(Color.GREEN),null},{null,new Block(Color.GREEN), new Block(Color.GREEN),null},{null,null,null,null}});
        type=TetroType.O;
    }
}
