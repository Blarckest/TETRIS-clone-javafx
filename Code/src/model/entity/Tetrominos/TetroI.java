package model.entity.Tetrominos;

import model.entity.Block;
import model.entity.BlockAbs;

public class TetroI extends Tetrominos{
    public TetroI(){
        setMatrix(new BlockAbs[][] {{null,null,null,null},{new Block(), new Block(), new Block(), new Block()},{null,null,null,null},{null,null,null,null}});
        type=TetroType.I;
    }
}
