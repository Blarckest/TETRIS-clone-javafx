package model.entity.tetrominos;

import javafx.scene.paint.Color;
import model.entity.block.Block;
import model.entity.block.BlockAbs;
import model.utils.CircularList;

/**
 * tetro de type I
 */
public class TetroI extends Tetrominos {
    /**
     * construit un tetro de type I
     */
    public TetroI() {
        blocks = new BlockAbs[]{new Block(Color.BLUE), new Block(Color.BLUE), new Block(Color.BLUE), new Block(Color.BLUE)};
        CircularList<BlockAbs[][]> list = new CircularList<>();
        list.add(new BlockAbs[][]{
                {blocks[0], blocks[1], blocks[2], blocks[3]}});
        list.add(new BlockAbs[][]{
                {blocks[0]},
                {blocks[1]},
                {blocks[2]},
                {blocks[3]}});
        setShapeMatrix(list);
        setMatrix((BlockAbs[][]) list.get(0));
        type = TetroType.I;
    }
}