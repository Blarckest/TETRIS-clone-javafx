package model.entity.Tetrominos;

import javafx.scene.paint.Color;
import model.entity.Block;
import model.entity.BlockAbs;

public class TetroS extends Tetrominos {
    public TetroS(){
        setMatrix(new BlockAbs[][] {{null,new Block(Color.PURPLE),new Block(Color.PURPLE),null},{new Block(Color.PURPLE), new Block(Color.PURPLE), null,null},{null,null,null,null},{null,null,null,null}});
        type=TetroType.S;
    }
}
