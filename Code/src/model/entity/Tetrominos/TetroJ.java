package model.entity.Tetrominos;

import model.entity.Block;
import model.entity.BlockAbs;

public class TetroJ extends Tetrominos{
    public TetroJ(){
        setMatrix(new BlockAbs[][] {{new Block(),null,null,null},{new Block(), new Block(), new Block(),null},{null,null,null,null},{null,null,null,null}});
        type=TetroType.J;
    }
}
