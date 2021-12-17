package model.entity.Tetrominos;

import javafx.scene.paint.Color;
import model.entity.Block;
import model.entity.BlockAbs;

public class TetroL extends Tetrominos{
    public TetroL(){
        setMatrix(new BlockAbs[][] {{null,null, new Block(Color.YELLOW),null},{new Block(Color.YELLOW), new Block(Color.YELLOW), new Block(Color.YELLOW),null},{null,null,null,null},{null,null,null,null}});
        type=TetroType.L;
    }
}
