package model.entity.Tetrominos;

import javafx.scene.paint.Color;
import model.entity.Block;
import model.entity.BlockAbs;

public class TetroZ extends Tetrominos{
    public TetroZ(){
        setMatrix(new BlockAbs[][] {{new Block(Color.ORANGE), new Block(Color.ORANGE), null,null},{null,new Block(Color.ORANGE),new Block(Color.ORANGE),null},{null,null,null,null},{null,null,null,null}});
        type=TetroType.Z;
    }
}
