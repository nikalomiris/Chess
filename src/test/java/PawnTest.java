import com.kalomiris.model.pieces.Pawn;
import org.junit.Test;

import static org.junit.Assert.*;

public class PawnTest {
    private Pawn pawn = new Pawn(0, 1, "White");

    @Test
    public void isValidPath() throws Exception {
        assertFalse(pawn.isValidPath(0, 4));
        assertFalse(pawn.isValidPath(1, 3));
        assertFalse(pawn.isValidPath(0, 0));

        assertTrue(pawn.isValidPath(0, 2));
        assertTrue(pawn.isValidPath(0, 3));
    }

    @Test
    public void drawPath() throws Exception {
        int[][] path = {{0,1},{0,2},{0,3}};
        int[][] path1 = {{0,1},{0,2}};
        int[][] path2 = {{0,1},{1,2}};
        assertArrayEquals(path, pawn.drawPath(0, 3));
        assertArrayEquals(path1, pawn.drawPath(0, 2));
        assertArrayEquals(path2, pawn.drawPath(1, 2));
    }

}