package model.entity.Tetrominos;

import javafx.scene.paint.Color;
import model.entity.Block;
import model.entity.BlockAbs;

public class TetroI extends Tetrominos{
    public TetroI(){
        setMatrix(new BlockAbs[][] {{null,null,null,null},{new Block(Color.BLUE), new Block(Color.BLUE), new Block(Color.BLUE), new Block(Color.BLUE)},{null,null,null,null},{null,null,null,null}});
        type=TetroType.I;
    }
}