import static org.junit.Assert.*;
import org.junit.Test;

/**
 * MarkProject2 tests the project on Akari.
 *
 * @author  Lyndon While
 * @version 2021 v1
 */
public class MarkProject2
{
    int    n7  = 73;
    String f7  = "Puzzles/p" + n7 / 10 + "-e" + n7 % 10 + ".txt";
    Akari  a7  = new Akari(f7);
    int    n14 = 141;
    String f14 = "Puzzles/p" + n14 / 10 + "-e" + n14 % 10 + ".txt";
    Akari  a14 = new Akari(f14);
    int    n25 = 251;
    String f25 = "Puzzles/p" + n25 / 10 + "-e" + n25 % 10 + ".txt";
    Akari  a25 = new Akari(f25);
    Akari  a5  = new Akari("Puzzles/p5-e1.txt");
    
    @Test
    public void testAkari7()
    {
        assertTrue("",      a7 != null);
        assertTrue("",      a7.getFilename().equals(f7));
        assertEquals("", 7, a7.getSize());
        for (int c : new int[] {0,1,2,3,6})
            assertEquals(c + "", Space.EMPTY, a7.getBoard(0,c));
        assertEquals("", Space.BLACK, a7.getBoard(0,4));
        assertEquals("", Space.TWO,   a7.getBoard(0,5));
        for (int c : new int[] {1,2,3,4,5,6})
            assertEquals(c + "", Space.EMPTY, a7.getBoard(1,c));
        assertEquals("", Space.ZERO, a7.getBoard(1,0));
        for (int c : new int[] {1,3,5,6})
            assertEquals(c + "", Space.EMPTY, a7.getBoard(2,c));
        for (int c : new int[] {0,2,4})
            assertEquals(c + "", Space.ZERO, a7.getBoard(2,c));
        for (int c = 0; c < 7; c++)
            assertEquals("", Space.EMPTY, a7.getBoard(3,c));
        for (int c : new int[] {0,1,3,5})
            assertEquals(c + "", Space.EMPTY, a7.getBoard(4,c));
        for (int c : new int[] {2,6})
            assertEquals(c + "", Space.BLACK, a7.getBoard(4,c));
        assertEquals("", Space.TWO, a7.getBoard(4,4));
        for (int c : new int[] {0,1,2,3,4,5})
            assertEquals(c + "", Space.EMPTY, a7.getBoard(5,c));
        assertEquals("", Space.BLACK, a7.getBoard(5,6));
        for (int c : new int[] {0,3,4,5,6})
            assertEquals(c + "", Space.EMPTY, a7.getBoard(6,c));
        assertEquals("", Space.BLACK, a7.getBoard(6,2));
        assertEquals("", Space.ZERO,  a7.getBoard(6,1));
    }
    
    @Test
    public void testAkari14()
    {
        assertTrue("",       a14 != null);
        assertTrue("",       a14.getFilename().equals(f14));
        assertEquals("", 14, a14.getSize());
        for (int c : new int[] {0,4,5,7,8,9,10,11,12,13})
            assertEquals(c + "", Space.EMPTY, a14.getBoard(0,c));
        assertEquals("", Space.BLACK, a14.getBoard(0,1));
        assertEquals("", Space.BLACK, a14.getBoard(0,3));
        assertEquals("", Space.ONE,   a14.getBoard(0,2));
        assertEquals("", Space.TWO,   a14.getBoard(0,6));
        for (int c : new int[] {0,2,3,4,5,6,8,9,10})
            assertEquals(c + "", Space.EMPTY, a14.getBoard(1,c));
        assertEquals("", Space.BLACK, a14.getBoard(1,1));
        assertEquals("", Space.BLACK, a14.getBoard(1,13));
        assertEquals("", Space.ZERO,  a14.getBoard(1,11));
        assertEquals("", Space.ONE,   a14.getBoard(1,7));
        assertEquals("", Space.ONE,   a14.getBoard(1,12));
        for (int c : new int[] {0,3,4,6,7,8,9,10,12})
            assertEquals(c + "", Space.EMPTY, a14.getBoard(2,c));
        for (int c : new int[] {1,2,5,11,13})
            assertEquals(c + "", Space.BLACK, a14.getBoard(2,c));
        for (int c = 0; c < 14; c++)
            if (c % 8 < 5)
               assertEquals(c + "", Space.EMPTY, a14.getBoard(3,c));
        assertEquals("", Space.BLACK, a14.getBoard(3,6));
        assertEquals("", Space.ZERO,  a14.getBoard(3,7));
        assertEquals("", Space.ZERO,  a14.getBoard(3,13));
        assertEquals("", Space.TWO,   a14.getBoard(3,5));
        for (int c = 0; c < 14; c++)
            assertEquals(c + "", c == 7 ? Space.ZERO : Space.EMPTY, a14.getBoard(4,c));
        for (int c = 0; c < 14; c++)
            assertEquals(c + "", c == 10 ? Space.ZERO : c == 11 ? Space.BLACK : Space.EMPTY, a14.getBoard(5,c));
        for (int c : new int[] {0,2,5,8,9,11,12})
            assertEquals(c + "", Space.EMPTY, a14.getBoard(6,c));
        for (int c : new int[] {3,4,6,7,10,13})
            assertEquals(c + "", Space.BLACK, a14.getBoard(6,c));
        assertEquals("", Space.THREE, a14.getBoard(6,1));
        for (int c : new int[] {1,2,4,5,8,11,13})
            assertEquals(c + "", Space.EMPTY, a14.getBoard(7,c));
        for (int c : new int[] {0,3,6,12})
            assertEquals(c + "", Space.BLACK, a14.getBoard(7,c));
        assertEquals("", Space.ZERO, a14.getBoard(7,7));
        assertEquals("", Space.ONE,  a14.getBoard(7,9));
        assertEquals("", Space.ONE,  a14.getBoard(7,10));
        for (int c = 0; c < 14; c++)
            assertEquals(c + "", c == 3 ? Space.TWO : c == 2 ? Space.BLACK : Space.EMPTY, a14.getBoard(8,c));
        for (int c = 0; c < 14; c++)
            assertEquals(c + "", c == 6 ? Space.BLACK : Space.EMPTY, a14.getBoard(9,c));
        for (int c = 0; c < 14; c++)
            if (1 <= c % 8 && c % 8 <= 5) assertEquals(c + "", Space.EMPTY, a14.getBoard(10,c));
            else
            if (c % 7 == 0)               assertEquals(c + "", Space.BLACK, a14.getBoard(10,c));
            else                          assertEquals(c + "", Space.ZERO, a14.getBoard(10,c));
        for (int c : new int[] {1,3,4,5,6,7,9,10,13})
            assertEquals(c + "", Space.EMPTY, a14.getBoard(11,c));
        for (int c : new int[] {0,2,11,12})
            assertEquals(c + "", Space.BLACK, a14.getBoard(11,c));
        assertEquals("", Space.ONE, a14.getBoard(11,8));
        for (int c : new int[] {3,4,5,7,8,9,10,11,13})
            assertEquals(c + "", Space.EMPTY, a14.getBoard(12,c));
        for (int c : new int[] {0,2,6,12})
            assertEquals(c + "", Space.BLACK, a14.getBoard(12,c));
        assertEquals("", Space.ONE, a14.getBoard(12,1));
        for (int c : new int[] {0,1,2,3,4,5,6,8,9,13})
            assertEquals(c + "", Space.EMPTY, a14.getBoard(13,c));
        assertEquals("", Space.TWO,   a14.getBoard(13,7));
        assertEquals("", Space.ONE,   a14.getBoard(13,10));
        assertEquals("", Space.BLACK, a14.getBoard(13,11));
        assertEquals("", Space.ONE,   a14.getBoard(13,12));
    }
    
    // this one is not exhaustive
    @Test
    public void testAkari25()
    {
        for (int r : new int[] {0,24})
            for (int c : new int[] {0,24})
                assertEquals("", Space.EMPTY, a25.getBoard(r,c));
        assertEquals("", Space.EMPTY, a25.getBoard(24,20));
        assertEquals("", Space.BLACK, a25.getBoard(19,22));
        assertEquals("", Space.ONE,   a25.getBoard(17,12));
        assertEquals("", Space.TWO,   a25.getBoard(15,16));
        assertEquals("", Space.THREE, a25.getBoard(18,3));
        assertEquals("", Space.FOUR,  a25.getBoard(23,21));
        for (int k = 0; k < 10; k++)
        {
            assertEquals("", Space.EMPTY, a25.getBoard(21 - k, 9 + k));
            assertEquals("", Space.EMPTY, a25.getBoard( 9 + k, 3 + k));
        }
        for (int k = 0; k < 4; k++)
        {
            assertEquals("", Space.BLACK, a25.getBoard( 8 + k / 2, 23 + k % 2));
            assertEquals("", Space.BLACK, a25.getBoard(18 + k / 2, 22 + k % 2));
            assertEquals("", Space.BLACK, a25.getBoard(23 + k / 2, 15 + k % 2));
            assertEquals("", Space.BLACK, a25.getBoard(22 + k / 2,  5 + k % 2));
            assertEquals("", Space.BLACK, a25.getBoard( 7 - k,     18 + k));
            assertEquals("", Space.BLACK, a25.getBoard( 3 + k,      4 + k));
        }
    }
    
    @Test
    public void testisLegal1()
    {
        for (int k = -30; k < 30; k++)
        {
            assertTrue (k + "",  a7.isLegal(k) == (0 <= k && k < 7));
            assertTrue (k + "", a14.isLegal(k) == (0 <= k && k < 14));
            assertTrue (k + "", a25.isLegal(k) == (0 <= k && k < 25));
        }
    }
    
    @Test
    public void testisLegal2()
    {
        for (int r = -30; r < 30; r++)
            for (int c = -30; c < 30; c++)
            {
                assertTrue (r + c + "",  a7.isLegal(r,c) == (0 <= r && r < 7  && 0 <= c && c < 7));
                assertTrue (r + c + "", a14.isLegal(r,c) == (0 <= r && r < 14 && 0 <= c && c < 14));
                assertTrue (r + c + "", a25.isLegal(r,c) == (0 <= r && r < 25 && 0 <= c && c < 25));
            }
    }
    
    @Test
    public void testgetBoard()
    {
        testAkari7();
        testAkari14();
        testAkari25();
    }
    
    @Test
    public void testgetBoardException() 
    {
        for (int[] sq : new int[][] {{-1,0,7},{13,14,14},{25,-1,25}})
            try
            {
                if (sq[2] ==  7) a7.getBoard(sq[0],sq[1]);
                else
                if (sq[2] == 14) a14.getBoard(sq[0],sq[1]);
                else
                if (sq[2] == 25) a25.getBoard(sq[0],sq[1]);
                assert false : "getBoard didn't throw an exception for " + sq[0] + "," + sq[1];
            }
            catch (IllegalArgumentException e) {}
    }
    
    @Test
    public void testparseIndex()
    {
        for (int k = 0; k < 10; k ++)
            assertEquals(k + "", k,      Akari.parseIndex((char) ('0' + k)));
        for (int k = 0; k < 26; k ++)
            assertEquals(k + "", k + 10, Akari.parseIndex((char) ('A' + k)));
    }
    
    @Test
    public void testparseIndexException() 
    {
        String s = "b %\n" + (char) 0 + (char) 4000;
        for (int c = 0; c < s.length(); c++)
            try
            {
                Akari.parseIndex(s.charAt(c));
                assert false : "parseIndex didn't throw an exception for " + s.charAt(c);
            }
            catch (IllegalArgumentException e) {}
    }
    
    // returns a deep copy of the board from a
    private Space[][] copyboard(Akari a)
    {
        Space[][] z = new Space[a.getSize()][a.getSize()];
        for (int r = 0; r < 25; r++)
            for (int c = 0; c < 25; c++)
                z[r][c] = a.getBoard(r,c);
        return z;
    }
    
    @Test
    public void testleftClick()
    {
        try 
        {
            a25.leftClick(-1,0); // off edges
            a25.leftClick(0,-1);
            a25.leftClick(24,25);
            a25.leftClick(25,24);
            a25.leftClick(1,1);  // BLACK
            a25.leftClick(2,0);  // ZERO
            a25.leftClick(2,1);  // ONE
            a25.leftClick(12,0); // TWO
            a25.leftClick(22,0); // THREE
            a25.leftClick(3,6);  // FOUR
        }
        catch(Exception e) {assert false : "leftClick should never throw an exception";}
        testAkari25();
        Space[][] copy = copyboard(a25);
        for (int r = 0; r < 25; r++)
            for (int c = 0; c < 25; c++)
            {
                assertEquals(r + "," + c, copy[r][c], a25.getBoard(r,c));
                assertEquals(r + "," + c, copy[c][r], a25.getBoard(c,r));
                a25.leftClick(r,c);
                if (Space.isMutable(a25.getBoard(r,c)))
                     assertEquals(r + "," + c, Space.BULB, a25.getBoard(r,c));
                else assertEquals(r + "," + c, copy[r][c], a25.getBoard(r,c));
                if (r != c) assertEquals(r + "," + c, copy[c][r], a25.getBoard(c,r));
                a25.leftClick(r,c);
                assertEquals(r + "," + c, copy[r][c], a25.getBoard(r,c));
                assertEquals(r + "," + c, copy[c][r], a25.getBoard(c,r));
            }
        testAkari25();
    }
    
    @Test
    public void testclear()
    {
        testAkari7();
        for (int i = 0; i < 7; i++)
        {
            for (int j = 0; j < 7; j++)
                a7.leftClick(i,j); // fill a column
            a7.clear();            // then clear the board
            testAkari7();
        }
        testAkari14();
        for (int i = 0; i < 14; i++)
        {
            for (int j = 0; j < 14; j++)
                a14.leftClick(j,i); // fill a row
            a14.clear();            // then clear the board
            testAkari14();
        };
        testAkari25();
        for (int i = -24; i < 25; i++)
        {
            for (int j = 0; j < 25; j++)
                a25.leftClick(i+j,j); // fill a diagonal
            a25.clear();              // then clear the board
            testAkari25();
        };
    }
    
    @Test
    public void testnumberOfBulbs()
    {
        // internal squares 
        for (int[] xs : new int[][] {{10,5},{20,6},{17,19},{6,4}}) // all 4 empties around them
        {
            for (int k = 1; k < 4; k++)
            {
                assertEquals(k + "", (int) Math.signum(k-1), a25.numberOfBulbs(xs[0],xs[1]));
                a25.leftClick(xs[0]+k,xs[1]);
            }
            for (int k = 1; k < 4; k++)
            {
                assertEquals(k + "", (int) Math.signum(k-1)+1, a25.numberOfBulbs(xs[0],xs[1]));
                a25.leftClick(xs[0],xs[1]+k);
            }
            for (int k = 1; k < 4; k++)
            {
                assertEquals(k + "", (int) Math.signum(k-1)+2, a25.numberOfBulbs(xs[0],xs[1]));
                a25.leftClick(xs[0],xs[1]-k);
            }
            for (int k = 1; k < 4; k++)
            {
                assertEquals(k + "", (int) Math.signum(k-1)+3, a25.numberOfBulbs(xs[0],xs[1]));
                a25.leftClick(xs[0]-k,xs[1]);
            }
            a25.clear();
        }
        int[][][] xss = {{{17,5},{6,20},{7,19}}                         // 0 empties
                        ,{{2,14},{19,3},{22,1},{7,21}}                  // 1 
                        ,{{22,2},{22,4},{22,22},{21,2},{21,11},{21,12}} // 2 
                        ,{{23,10},{1,14},{10,4},{9,7}}};                // 3 
        for (int b = 0; b < xss.length; b++)
            for (int[] xs : xss[b])
            {
                assertEquals(xs[0] + " " + xs[1], 0, a25.numberOfBulbs(xs[0],xs[1]));
                a25.leftClick(xs[0]+1,xs[1]);
                a25.leftClick(xs[0]-1,xs[1]);
                a25.leftClick(xs[0],xs[1]+1);
                a25.leftClick(xs[0],xs[1]-1);
                assertEquals(xs[0] + " " + xs[1], b, a25.numberOfBulbs(xs[0],xs[1]));
                a25.clear();
            }
        // edge & corner squares 
        xss = new int[][][] {{{14,0},{0,10},{10,24},{24,14}} // 0 empties
                            ,{{0,1},{3,24},{24,11},{11,0}}   // 1 
                            ,{{0,21},{21,24},{24,6},{8,0},{0,0},{0,24},{24,0},{24,24}} // 2 
                            ,{{0,20},{4,0},{24,7},{17,24}}}; // 3 
        for (int b = 0; b < xss.length; b++)
            for (int[] xs : xss[b])
            {
                assertEquals(xs[0] + " " + xs[1], 0, a25.numberOfBulbs(xs[0],xs[1]));
                a25.leftClick(xs[0]+1,xs[1]);
                a25.leftClick(xs[0]-1,xs[1]);
                a25.leftClick(xs[0],xs[1]+1);
                a25.leftClick(xs[0],xs[1]-1);
                assertEquals(xs[0] + " " + xs[1], b, a25.numberOfBulbs(xs[0],xs[1]));
                a25.clear();
            }
        // corner squares partly blocked
        for (int[] xs : new int[][] {{0,0},{0,6},{6,0},{6,6}})
        {
            assertEquals(xs[0] + " " + xs[1], 0, a7.numberOfBulbs(xs[0],xs[1]));
            a7.leftClick(xs[0]+1,xs[1]);
            a7.leftClick(xs[0]-1,xs[1]);
            a7.leftClick(xs[0],xs[1]+1);
            a7.leftClick(xs[0],xs[1]-1);
            assertEquals(xs[0] + " " + xs[1], 1, a7.numberOfBulbs(xs[0],xs[1]));
        }
        // exhaustive, including corner squares completely blocked
        for (int r = 0; r < 5; r++)
            for (int c = 0; c < 5; c++)
                assertEquals("", 0, a5.numberOfBulbs(r,c));
        for (int r = 0; r < 5; r++)
            for (int c = 0; c < 5; c++)
                a5.leftClick(r,c);
        xss = new int[][][] {{{0,0},{3,3},{4,0},{4,2},{4,4}}                   // 0 empties
                            ,{{2,0},{2,4},{3,1}}                               // 1 
                            ,{{0,2},{0,3},{0,4},{1,0},{1,1},{1,4},{2,2},{3,0}} // 2 
                            ,{{0,1},{1,3},{2,1},{3,4},{4,1},{4,3}}             // 3
                            ,{{1,2},{2,3},{3,2}}};                             // 4
        for (int b = 0; b < xss.length; b++)
            for (int[] xs : xss[b])
                assertEquals("", b, a5.numberOfBulbs(xs[0],xs[1]));
    }
    
    @Test
    public void testnumberOfBulbsException() 
    {
        for (int[] sq : new int[][] {{-1,6,7},{0,14,14},{-1,25,25}})
            try
            {
                if (sq[2] ==  7) a7.numberOfBulbs(sq[0],sq[1]);
                else
                if (sq[2] == 14) a14.numberOfBulbs(sq[0],sq[1]);
                else
                if (sq[2] == 25) a25.numberOfBulbs(sq[0],sq[1]);
                assert false : "numberOfBulbs didn't throw an exception for " + sq[0] + "," + sq[1];
            }
            catch (IllegalArgumentException e) {}
    }
    
    // returns true iff x,y can see a bulb at r,c
    private boolean canSee(int x, int y, int r, int c, int[]xs)
    {
        return ((r == x && xs[0] <= y && y <= xs[1]) ||  // visible along the row 
                (c == y && xs[2] <= x && x <= xs[3])) && // or the column, 
               !(r == x && c == y);                      // and can't see itself
    }
    
    @Test
    public void testcanSeeBulb()
    {
        // visibility matrix for 73
        // for each square, give the range along the row, then the range along the column
        // black squares have empty entries
        int[][][]   xs = {{{0,4,0,1},{0,4,0,6},{0,4,0,2},{0,4,0,6},{}       ,{}       ,{5,6,0,4}}
                         ,{{}       ,{0,6,0,6},{0,6,0,2},{0,6,0,6},{0,6,0,2},{0,6,0,6},{0,6,0,4}}
                         ,{{}       ,{0,2,0,6},{}       ,{2,4,0,6},{}       ,{4,6,0,6},{4,6,0,4}}
                         ,{{0,6,2,6},{0,6,0,6},{0,6,2,4},{0,6,0,6},{0,6,2,4},{0,6,0,6},{0,6,0,4}}
                         ,{{0,2,2,6},{0,2,0,6},{}       ,{2,4,0,6},{}       ,{4,6,0,6},{}}
                         ,{{0,6,2,6},{0,6,0,6},{0,6,4,6},{0,6,0,6},{0,6,4,6},{0,6,0,6},{}}
                         ,{{0,1,2,6},{},       {},       {2,6,0,6},{2,6,4,6},{2,6,0,6},{2,6,5,6}}
                         };
        // no bulbs
        for (int r = 0; r < 7; r++)
            for (int c = 0; c < 7; c++)
                assertFalse(r + "," + c, a7.canSeeBulb(r,c));
        // one bulb at a time
        for (int r = 0; r < 7; r++)
            for (int c = 0; c < 7; c++)
                if (Space.isMutable(a7.getBoard(r,c)))
                {
                    a7.leftClick(r,c);
                    for (int x = 0; x < 7; x++)
                        for (int y = 0; y < 7; y++)
                            assertTrue(r + "," + c + " " + x + "," + y, a7.canSeeBulb(x,y) == (canSee(x,y,r,c,xs[r][c])));
                    a7.leftClick(r,c);
                }
        // two bulbs at a time
        for (int r1 = 0; r1 < 7; r1++)
            for (int c1 = 0; c1 < 7; c1++)
                if (Space.isMutable(a7.getBoard(r1,c1)))
                {
                    a7.leftClick(r1,c1);
                    for (int r2 = 0; r2 < 7; r2++)
                        for (int c2 = 0; c2 < 7; c2++)
                            if (!(r2 == r1 && c2 == c1) && Space.isMutable(a7.getBoard(r2,c2)))
                            {
                                a7.leftClick(r2,c2);
                                for (int x = 0; x < 7; x++)
                                    for (int y = 0; y < 7; y++)
                                        assertTrue(r1 + "," + c1 + " " + r2 + "," + c2 + " " + x + "," + y, 
                                                   a7.canSeeBulb(x,y) == (canSee(x,y,r1,c1,xs[r1][c1]) || canSee(x,y,r2,c2,xs[r2][c2])));
                                a7.leftClick(r2,c2);
                            }
                    a7.leftClick(r1,c1);
                }
        // bulbs everywhere on 73, every square lit up
        for (int r = 0; r < 7; r++)
            for (int c = 0; c < 7; c++)
                a7.leftClick(r,c);
        for (int r = 0; r < 7; r++)
            for (int c = 0; c < 7; c++)
                assertTrue(r + "," + c, a7.canSeeBulb(r,c));
        a7.clear();
        Akari a77 = new Akari("Puzzles/p7-e7.txt");
        // no bulbs on 77
        for (int r = 0; r < 7; r++)
            for (int c = 0; c < 7; c++)
                assertFalse(r + "," + c, a77.canSeeBulb(r,c));
        // bulbs everywhere on 77, every square lit up except the centre
        for (int r = 0; r < 7; r++)
            for (int c = 0; c < 7; c++)
                a77.leftClick(r,c);
        for (int r = 0; r < 7; r++)
            for (int c = 0; c < 7; c++)
                assertTrue(r + "," + c, a77.canSeeBulb(r,c) || (r == 3 && c == 3));
        a77.clear();
    }
    
    @Test
    public void testcanSeeBulbException() 
    {
        for (int[] sq : new int[][] {{-1,6,7},{0,14,14},{-1,25,25}})
            try
            {
                if (sq[2] ==  7) a7.canSeeBulb(sq[0],sq[1]);
                else
                if (sq[2] == 14) a14.canSeeBulb(sq[0],sq[1]);
                else
                if (sq[2] == 25) a25.canSeeBulb(sq[0],sq[1]);
                assert false : "canSeeBulb didn't throw an exception for " + sq[0] + "," + sq[1];
            }
            catch (IllegalArgumentException e) {}
    }
    
    @Test
    public void testisSolution()
    {
        String unlit = "Unlit square at ";
        String broke = "Broken number at ";
        String clash = "Clashing bulb at ";
        String done  = "\u2713\u2713\u2713";
        int[][]ss;
        // empty board
        assertTrue("", a14.isSolution().startsWith(unlit) || 
                       a14.isSolution().startsWith(broke));
        // set up the solution
        for (int[] s : new int[][] {{0,5},{0,7},{1,2},{2,3},{2,8},{2,12},{3,4},{3,10}
                                   ,{4,5},{4,11},{5,1},{5,13},{6,0},{6,2},{6,9}
                                   ,{7,11},{8,0},{8,4},{9,3},{9,9},{10,2},{10,12}
                                   ,{11,1},{11,7},{12,10},{13,6},{13,8},{13,13}})
            a14.leftClick(s[0], s[1]);
        assertTrue("", a14.isSolution().equals(done));
        // unlit squares
        ss = new int[][] {{2,3},{},{4,11},{},{5,13},{},{8,0},{},{10,2},{},{10,12},{}
                         ,{3,10},{1,10},{2,8},{1,8,7,8,2,7,2,6},{9,9},{9,7,11,9}};
        for (int k = 0; k < ss.length; k += 2)
        {
            a14.leftClick(ss[k][0], ss[k][1]);
            assertTrue("", a14.isSolution().startsWith(unlit));
            boolean b = false;
            b = a14.isSolution().endsWith(ss[k][0] + "," + ss[k][1]);
            for (int j = 0; j < ss[k+1].length; j += 2)
                b |= a14.isSolution().endsWith(ss[k+1][j] + "," + ss[k+1][j+1]);
            assertTrue("", b);
            a14.leftClick(ss[k][0], ss[k][1]);
            assertTrue("", a14.isSolution().equals(done));
        }
        // clashing bulbs
        ss = new int[][] {{10,12},{10,11},{7,11}, {10,13},{13,13},{9,12},{9,9}
                                 ,{10,10},{12,10},{8,12}, {8,4}
                         ,{2,3},  {1,3},  {1,2},  {3,3},  {3,4},  {4,3}, {4,5}
                               ,  {5,3},  {5,1},  {2,4},  {3,4}};
        for (int k = 0; k < ss.length; k += 11)
        {
            a14.leftClick(ss[k][0],   ss[k][1]);
            a14.leftClick(ss[k+1][0], ss[k+1][1]);
            assertTrue("", a14.isSolution().startsWith(clash));
            assertTrue("", a14.isSolution().endsWith(ss[k+1][0] + "," + ss[k+1][1]) ||
                           a14.isSolution().endsWith(ss[k+2][0] + "," + ss[k+2][1]));
            a14.leftClick(ss[k][0],   ss[k][1]);
            a14.leftClick(ss[k+1][0], ss[k+1][1]);
            assertTrue("", a14.isSolution().equals(done));
        }
        // broken squares
        ss = new int[][] {{0,7,0,13,0,6,1,7},{0,7,0,12,0,6,1,12,1,7},{0,7,0,11,0,6,1,11,1,7}
                         ,{1,2,1,6,0,2,0,6,1,7},{2,12,6,12,1,12},{3,10,1,10,1,11}
                         ,{5,1,5,6,6,1},{5,1,5,7,6,1,4,7},{6,2,7,2,6,1},{6,9,1,9,7,9},{7,11,6,11,7,10}
                         ,{9,3,12,3,8,3},{11,7,11,6,11,8,10,6},{11,1,7,1,6,1,12,1}
                         ,{13,6,13,0,13,7},{13,6,13,2,13,7},{13,6,13,1,13,7,12,1}
                         ,{13,13,12,13,13,12},{13,13,11,13,13,12},{13,13,7,13,13,12}
                         };
        for (int[] s : ss)
        {
            a14.leftClick(s[0], s[1]);
            a14.leftClick(s[2], s[3]);
            assertTrue("", a14.isSolution().startsWith(broke));
            boolean b = false;
            for (int j = 4; j < s.length; j += 2)
                b |= a14.isSolution().endsWith(s[j] + "," + s[j+1]);
            // System.out.println(a14.isSolution());
            assertTrue("", b);
            a14.leftClick(s[0], s[1]);
            a14.leftClick(s[2], s[3]);
            assertTrue("", a14.isSolution().equals(done));
        }
        // multiple errors (at least sometimes)
        for (int r = 0; r < 14; r++) 
            for (int c = 0; c < 14; c++)
                {
                    a14.leftClick(r, c);
                    assertTrue("", a14.isSolution().equals(done) != Space.isMutable(a14.getBoard(r,c)));
                    a14.leftClick(r, c);
                    assertTrue("", a14.isSolution().equals(done));
                }
    }
    
    @Test
    public void testAkariViewer()
    {
        AkariViewer av7 = new AkariViewer(n7);
        assertTrue("", av7 != null);
        assertTrue("", av7.getCanvas() != null);
        Akari a7 = av7.getPuzzle();
        testAkari7();
        AkariViewer av14 = new AkariViewer(n14);
        assertTrue("", av14 != null);
        assertTrue("", av14.getCanvas() != null);
        Akari a14 = av14.getPuzzle();
        testAkari14();
        AkariViewer av25 = new AkariViewer(n25);
        assertTrue("", av25 != null);
        assertTrue("", av25.getCanvas() != null);
        Akari a25 = av25.getPuzzle();
        testAkari25();
    }
    
    @Test
    public void testDisplayAndMouseMethods()
    {
        assert false : "display and mouse methods are not tested";
    }
    
    @Test
    public void testleftClickViewer()
    {
        testleftClick();
    }
}