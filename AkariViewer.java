/**
 * AkariViewer represents an interface for a player of Akari.
 *
 * @author Lyndon While
 * @version 2021
 */

/**
 Harper Wu(23052765)
 */


import java.awt.*;
import java.awt.event.*; 

public class AkariViewer implements MouseListener
{    
    private Akari puzzle;    // the internal representation of the puzzle
    private SimpleCanvas sc; // the display window
    
    private int cellNum;                        // board size
        private final int CELLSIZE = 80;        // cell size on canvas
    private final int OFFSET = CELLSIZE/3*2;    // string offset
    private final int CELL_OFFSET = 1;          // cell offset to show the grid
    
    private final Color BG_COLOR = Color.white;
    private final Color GRID_COLOR = Color.black;
    private final Color BLOCK_COLOR = Color.black;
    private final Color TXT_COLOR = Color.white;
    private final Color BTN_COLOR = Color.blue;
    private final Color BULB_COLOR = Color.orange;
    private final Color LIT_COLOR = Color.yellow;
    private final Color CLASH_COLOR = Color.red;
    

    /**
     * Constructor for objects of class AkariViewer.
     * Sets all fields and displays the initial puzzle.
     */
    public AkariViewer(Akari puzzle)
    {
        // TODO 10
        this.puzzle = puzzle;
        cellNum = puzzle.getSize();
        sc = new SimpleCanvas("Akari",
                              cellNum * CELLSIZE,
                              (cellNum+2) * CELLSIZE,   // add 2 cell size show buttons and output info
                              BG_COLOR);
        sc.addMouseListener(this);
        sc.setFont(new Font("Arial", 20, CELLSIZE / 2));
        displayPuzzle();
        drawButton(0, cellNum * CELLSIZE + 1, cellNum * CELLSIZE / 2, (cellNum + 1) * CELLSIZE, "SOLVED?");
        drawButton(cellNum * CELLSIZE / 2, cellNum * CELLSIZE + 1, cellNum * CELLSIZE, (cellNum + 1) * CELLSIZE, "CLEAR");
    }
    
    // helper method
    private void drawButton(int x1, int y1, int x2, int y2, String btnTxt) {
        sc.drawRectangle(x1 + CELL_OFFSET, y1 + CELL_OFFSET, x2 - CELL_OFFSET, y2 - CELL_OFFSET, BTN_COLOR);
        sc.drawString(btnTxt, x1 + OFFSET, y1 + OFFSET, TXT_COLOR);
    }
    
    /**
     * Selects from among the provided files in folder Puzzles. 
     * The number xyz selects pxy-ez.txt. 
     */
    public AkariViewer(int n)
    {
        this(new Akari("Puzzles/p" + n / 10 + "-e" + n % 10 + ".txt"));
    }
    
    /**
     * Uses the provided example file on the LMS page.
     */
    public AkariViewer()
    {
        this(77);
    }
    
    /**
     * Returns the internal state of the puzzle.
     */
    public Akari getPuzzle()
    {
        // TODO 9a
        return puzzle;
    }
    
    /**
     * Returns the canvas.
     */
    public SimpleCanvas getCanvas()
    {
        // TODO 9b
        return sc;
    }
    
    /**
     * Displays the initial puzzle; see the LMS page for a suggested layout. 
     */
    private void displayPuzzle()
    {
        // TODO 11
        // clear canvas
        sc.drawRectangle(0, 0, cellNum*CELLSIZE, (cellNum + 2)*CELLSIZE, BG_COLOR);
        // Draw grid
        for (int i = 0; i <= cellNum; i++)
            sc.drawLine(i * CELLSIZE, 0, i * CELLSIZE, cellNum * CELLSIZE, GRID_COLOR);
        for (int j = 0; j <= cellNum; j++)
            sc.drawLine(0, j * CELLSIZE, cellNum * CELLSIZE, j * CELLSIZE, GRID_COLOR);
        
        // Draw puzzle
        for (int x = 0; x < cellNum; x++) {
            for (int y = 0; y < cellNum; y++) {
                Space cell = puzzle.getBoard(y, x);
                // check cell, drawDifferent cell according to its Space,
                // if can see bulb and empty, draw lit up cell
                if (cell == Space.ZERO) drawPuzzle(x, y, 0);
                if (cell== Space.ONE) drawPuzzle(x, y, 1);
                if (cell == Space.TWO) drawPuzzle(x, y, 2);
                if (cell == Space.THREE) drawPuzzle(x, y, 3);
                if (cell == Space.FOUR) drawPuzzle(x, y, 4);
                if (cell == Space.BLACK) drawPuzzle(x, y, -1);
                if (cell == Space.BULB) drawPuzzle(x, y, -2);
                if (puzzle.canSeeBulb(y,x) && cell == Space.EMPTY) drawPuzzle(x, y, -3);
                if (puzzle.canSeeBulb(y,x) && cell == Space.BULB) drawPuzzle(x, y, -4);
            }
        }
        drawButton(0, cellNum * CELLSIZE + 1, cellNum * CELLSIZE / 2, (cellNum + 1) * CELLSIZE, "SOLVED?");
        drawButton(cellNum * CELLSIZE / 2, cellNum * CELLSIZE + 1, cellNum * CELLSIZE, (cellNum + 1) * CELLSIZE, "CLEAR");
    }
    
    // helper method: draws one puzzle at (x,y) with number 0-4 and -1: Black -2: Bulb -3: Lit up 4: clashing bulb
    private void drawPuzzle(int x, int y, int num) {
        // draw black blocks, if has number, draw number String
        if (num >= -1){
            sc.drawRectangle(x*CELLSIZE, y*CELLSIZE,
                            (x+1)*CELLSIZE, (y+1)*CELLSIZE,
                            BLOCK_COLOR);
            if (num >= 0) sc.drawString(num, x*CELLSIZE+OFFSET/2, y*CELLSIZE+OFFSET, TXT_COLOR);
        }
        // lit up cells, if it is bulb, draw a bulb
        else {
            sc.drawRectangle(x*CELLSIZE + CELL_OFFSET, y*CELLSIZE+ CELL_OFFSET,
                            (x+1)*CELLSIZE - CELL_OFFSET, (y+1)*CELLSIZE - CELL_OFFSET,
                            LIT_COLOR);
            // light bulb unicode: "\uD83D\uDCA1", can't work on mac, try windows
            if (num == -2) sc.drawString("\u263c", x * CELLSIZE + OFFSET / 2, y * CELLSIZE + OFFSET, BULB_COLOR);
            if (num == -4) sc.drawString("\u263c", x * CELLSIZE + OFFSET / 2, y * CELLSIZE + OFFSET, CLASH_COLOR);
        } 

    }

    
    /**
     * Performs a left click on the square at r,c if the indices are legal, o/w does nothing. 
     * Updates both puzzle and the display. 
     */
    public void leftClick(int r, int c)
    {
        // TODO 12
        puzzle.leftClick(r,c);
        displayPuzzle();
    }
    
    // TODO 13
    public void mousePressed (MouseEvent e) {}
    public void mouseClicked (MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {
        if (puzzle.isLegal(e.getY()/CELLSIZE))
            this.leftClick(e.getY()/CELLSIZE, e.getX()/CELLSIZE);
        else if (e.getX() < cellNum * CELLSIZE / 2 && e.getY() < (cellNum+1) * CELLSIZE) {
            // Left side: SOLVED button
            sc.drawString(puzzle.isSolution(),OFFSET, (cellNum+1) * CELLSIZE + OFFSET, GRID_COLOR);
        }
        else if (e.getX() > cellNum * CELLSIZE / 2 && e.getY() < (cellNum+1) * CELLSIZE) {
            // Right side: CLEAR button
            puzzle.clear();
            displayPuzzle();
        }
    }
    public void mouseEntered (MouseEvent e) {}
    public void mouseExited  (MouseEvent e) {}
}
