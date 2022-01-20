package model.utils.lineCleaner;

import model.entity.block.Block;
import model.entity.block.BlockAbs;
import model.entity.grid.Grid;
import model.entity.grid.GridAbs;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class LineCleanerTest {

    final GridAbs g = new Grid(new BlockAbs[][]{
            {null, null},
            {new Block(), new Block()},
            {null, null},
            {new Block(), new Block()},
            {new Block(), new Block()}});
    final ILineCleaner cleaner = new LineCleaner(g);

    @Test
    void removeLines() {
        cleaner.removeLines();
        assertArrayEquals(new BlockAbs[][]{
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null}},
                g.matrix);
        cleaner.removeLines();
        assertArrayEquals(new BlockAbs[][]{
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null}},
                g.matrix);
    }
}