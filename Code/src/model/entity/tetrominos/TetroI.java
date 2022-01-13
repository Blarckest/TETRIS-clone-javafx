package model.entity.tetrominos;

import javafx.scene.paint.Color;
import model.entity.block.Block;
import model.entity.block.BlockAbs;
import model.utils.CircularList;

public class TetroI extends Tetrominos {
    public TetroI() {
        blocks = new BlockAbs[]{new Block(Color.BLUE), new Block(Color.BLUE), new Block(Color.BLUE), new Block(Color.BLUE)};
        CircularList<BlockAbs[][]> list = new CircularList<>();
        list.add(new BlockAbs[][]{
                {null, null, null, null},
                {blocks[0], blocks[1], blocks[2], blocks[3]},
                {null, null, null, null},
                {null, null, null, null}});
        list.add(new BlockAbs[][]{
                {null, blocks[0], null, null},
                {null, blocks[1], null, null},
                {null, blocks[2], null, null},
                {null, blocks[3], null, null}});
        setShapeMatrix(list);
        setMatrix((BlockAbs[][]) list.get(0));
        type = TetroType.I;
    }
}