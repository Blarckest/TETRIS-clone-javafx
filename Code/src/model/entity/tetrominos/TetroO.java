package model.entity.tetrominos;

import javafx.scene.paint.Color;
import model.entity.block.Block;
import model.entity.block.BlockAbs;
import model.utils.CircularList;

/**
 * tetro de type O
 */
public class TetroO extends Tetrominos {
    /**
     * construit un tetro de type O
     */
    public TetroO() {
        blocks = new BlockAbs[]{new Block(Color.GREEN), new Block(Color.GREEN), new Block(Color.GREEN), new Block(Color.GREEN)};
        CircularList<BlockAbs[][]> list = new CircularList<>();
        list.add(new BlockAbs[][]{
                {null, null, null, null},
                {null, blocks[0], blocks[1], null},
                {null, blocks[2], blocks[3], null},
                {null, null, null, null}});
        setShapeMatrix(list);
        setMatrix((BlockAbs[][]) list.get(0));
        type=TetroType.O;
    }
}
