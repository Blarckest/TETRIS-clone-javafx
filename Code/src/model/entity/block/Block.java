package model.entity.block;

import javafx.scene.paint.Color;
import model.entity.block.BlockAbs;
import model.utils.Couple;

public class Block extends BlockAbs {

    public Block(Color color) {
        super("/img/spritesBlock.png",color, new Couple(1,1));
    }


}
