package model.entity.Tetrominos;

import model.entity.Block;
import model.entity.BlockAbs;

public class TetroZ extends Tetrominos{
    public TetroZ(){
        setMatrix(new BlockAbs[][] {{new Block(), new Block(), null,null},{null,new Block(),new Block(),null},{null,null,null,null},{null,null,null,null}});
        type=TetroType.Z;
    }
}
