package model.entity.tetrominos;

import javafx.scene.paint.Color;
import model.entity.block.Block;
import model.entity.block.BlockAbs;
import model.utils.CircularList;

/**
 * tetro de type J
 */
public class TetroJ extends Tetrominos {
    /**
     * construit un tetro de type J
     */
    public TetroJ() {
        blocks = new BlockAbs[]{new Block(Color.RED), new Block(Color.RED), new Block(Color.RED), new Block(Color.RED)};
        CircularList<BlockAbs[][]> list = new CircularList<>();
        list.add(new BlockAbs[][]{
                {null, null, null, null},
                {blocks[0], blocks[1], blocks[2], null},
                {null, null, blocks[3], null},
                {null, null, null, null}});
        list.add(new BlockAbs[][]{
                {null, null, null, null},
                {null, blocks[0], blocks[1], null},
                {null, blocks[2], null, null},
                {null, blocks[3], null, null}});
        list.add(new BlockAbs[][]{
                {null, null, null, null},
                {null, blocks[0], null, null},
                {null, blocks[1], blocks[2], blocks[3]},
                {null, null, null, null}});
        list.add(new BlockAbs[][]{
                {null, null, blocks[0], null},
                {null, null, blocks[1], null},
                {null, blocks[2], blocks[3], null},
                {null, null, null, null}});
        setShapeMatrix(list);
        setMatrix((BlockAbs[][]) list.get(0));
        type = TetroType.J;
    }
}
