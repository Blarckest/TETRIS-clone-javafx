package model.entity.Tetrominos;

import model.entity.Block;
import model.entity.BlockAbs;

public class TetroT extends Tetrominos{
    public TetroT(){
        setMatrix(new BlockAbs[][] {{null,new Block(),null,null},{new Block(), new Block(), new Block(),null},{null,null,null,null},{null,null,null,null}});
        type=TetroType.T;
    }
}
