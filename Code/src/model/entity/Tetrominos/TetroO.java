package model.entity.Tetrominos;

import model.entity.Block;
import model.entity.BlockAbs;

public class TetroO extends Tetrominos{
    public TetroO(){
        setMatrix(new BlockAbs[][] {{null,null,null,null},{null, new Block(), new Block(),null},{null,new Block(), new Block(),null},{null,null,null,null}});
        type=TetroType.O;
    }
}
