package model.entity.Tetrominos;

import javafx.scene.paint.Color;
import model.entity.Block;
import model.entity.BlockAbs;

public class TetroJ extends Tetrominos{
    public TetroJ(){
        setMatrix(new BlockAbs[][] {{new Block(Color.RED),null,null,null},{new Block(Color.RED), new Block(Color.RED), new Block(Color.RED),null},{null,null,null,null},{null,null,null,null}});
        type=TetroType.J;
    }
}
