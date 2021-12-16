package model.entity.Tetrominos;

import model.entity.Block;
import model.entity.BlockAbs;

public class TetroL extends Tetrominos{
    public TetroL(){
        setMatrix(new BlockAbs[][] {{null,null, new Block(),null},{new Block(), new Block(), new Block(),null},{null,null,null,null},{null,null,null,null}});
        type=TetroType.L;
    }
}
