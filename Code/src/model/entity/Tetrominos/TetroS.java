package model.entity.Tetrominos;

import model.entity.Block;
import model.entity.BlockAbs;

public class TetroS extends Tetrominos {
    public TetroS(){
        setMatrix(new BlockAbs[][] {{null,new Block(),new Block(),null},{new Block(), new Block(), null,null},{null,null,null,null},{null,null,null,null}});
        type=TetroType.S;
    }
}
