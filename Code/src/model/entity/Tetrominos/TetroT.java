package model.entity.Tetrominos;

import javafx.scene.paint.Color;
import model.entity.Block;
import model.entity.BlockAbs;

public class TetroT extends Tetrominos{
    public TetroT(){
        setMatrix(new BlockAbs[][] {{null,new Block(Color.CYAN),null,null},{new Block(Color.CYAN), new Block(Color.CYAN), new Block(Color.CYAN),null},{null,null,null,null},{null,null,null,null}});
        type=TetroType.T;
    }
}
