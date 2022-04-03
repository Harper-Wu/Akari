/**
 * Akari represents a single puzzle of the game Akari.
 *
 * @author Lyndon While 
 * @version 2021
 */

/**
 Harper Wu(23052765)
 */


import java.util.ArrayList; 

public class Akari 
{
    private String filename; // the name of the puzzle file
    private int size;        // the board is size x size
    private Space[][] board; // the board is a square grid of spaces of various types

    /**
     * Constructor for objects of class Akari. 
     * Creates and initialises the fields with the contents of filename. 
     * The layout of a puzzle file is described on the LMS page; 
     * you may assume the layout is always correct. 
     */
    public Akari(String filename)
    {
        // TODO 3
        this.filename = filename;
        initFile(filename);         //Use helper method to initailize size and board
    }
    
    // helper method: get board size and set board
    private void initFile(String filename) {
        ArrayList<String> lines = new FileIO(filename).getLines();

        // Prase first line string into into to be size
        size = Integer.parseInt(lines.get(0));
        
        // initialize board with size
        board = new Space[size][size];
        // make board empty
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                board[i][j] = Space.EMPTY;
            }
        }
        
        // read rest of lines in file, if line is empty do nothing
        // if not, assign space at the board according to line index
        for (int j = 1; j < lines.size(); j++) {
            String cells = lines.get(j);
            if (!cells.isEmpty()) {
                for (String c : cells.split(" ")) {
                    int x = Character.getNumericValue(c.charAt(0));
                    for (int i= 1; i < c.length(); i ++) {
                        int y = parseIndex(c.charAt(i));
                        if (j == 1) board[x][y] = Space.BLACK;
                        if (j == 2) board[x][y] = Space.ZERO;
                        if (j == 3) board[x][y] = Space.ONE;
                        if (j == 4) board[x][y] = Space.TWO;
                        if (j == 5) board[x][y] = Space.THREE;
                        if (j == 6) board[x][y] = Space.FOUR;
                    }    
                }
            }
        }
    }
    
    /**
     * Uses the example file from the LMS page.
     */
    public Akari()
    {
        this("Puzzles/p7-e7.txt");
    }
    
    /**
     * Returns the name of the puzzle file.
     */
    public String getFilename()
    {
        // TODO 1a
        return filename;
    }
    
    /**
     * Returns the size of the puzzle.
     */
    public int getSize()
    {
        // TODO 1b
        return size;
    }
    
    /**
     * Returns true iff k is a legal index into the board. 
     */
    public boolean isLegal(int k)
    {
        // TODO 5
        return k < size; 
    }
    
    /**
     * Returns true iff r and c are both legal indices into the board. 
     */
    public boolean isLegal(int r, int c)
    {
        // TODO 6
        return isLegal(r) && isLegal(c);
    }
    
    /**
     * Returns the contents of the square at r,c if the indices are legal, 
     * o/w throws an illegal argument exception. 
     */
    public Space getBoard(int r, int c)
    {
        // TODO 7
        if (isLegal(r, c))
            return board[r][c];
        else
            throw new IllegalArgumentException("Illegal Coordinate");
    }
    
    /**
     * Returns the int equivalent of x. 
     * If x is a digit, returns 0 -> 0, 1 -> 1, etc; 
     * if x is an upper-case letter, returns A -> 10, B -> 11, etc; 
     * o/w throws an illegal argument exception. 
     */
    public static int parseIndex(char x)
    {
        // TODO 2
        if (Character.isDigit(x)) 
            return Character.getNumericValue(x);
        else if (Character.isUpperCase(x)) 
            return (x - 'A' + 10);
        else throw new IllegalArgumentException("Illegal Index");
    }
    
    /**
     * Performs a left click on the square at r,c if the indices are legal, o/w does nothing. 
     * If r,c is empty, a bulb is placed; if it has a bulb, that bulb is removed.
     */
    public void leftClick(int r, int c)
    {
        // TODO 8
        if (isLegal(r, c)) {
            if (board[r][c] == Space.EMPTY) 
                board[r][c] = Space.BULB;
            else if (board[r][c] == Space.BULB) 
                board[r][c] = Space.EMPTY;    
        }
        
    }
    
    /**
     * Sets all mutable squares on the board to empty.
     */
    public void clear()
    {
        // TODO 4
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if (board[i][j] == Space.BULB)
                    board[i][j] = Space.EMPTY;
            }
        }
        
    }
    
    /**
     * Returns the number of bulbs adjacent to the square at r,c. 
     * Throws an illegal argument exception if r,c are illegal coordinates.
     */
    public int numberOfBulbs(int r, int c)
    {
        // TODO 14
        if (isLegal(r, c)) {
            int n = 0;
            int rp = (r + 1)        % size;
            int rm = (r - 1 + size) % size;
            int cp = (c + 1)        % size;
            int cm = (c - 1 + size) % size;
            if (board[rp][c] == Space.BULB) n++;
            if (board[rm][c] == Space.BULB) n++;
            if (board[r][cp] == Space.BULB) n++;
            if (board[r][cm] == Space.BULB) n++;
            return n;
        }
        else throw new IllegalArgumentException("Illegal Coordinates");
    }
    
    /**
     * Returns true iff the square at r,c is lit by a bulb elsewhere. 
     * Throws an illegal argument exception if r,c are illegal coordinates.
     */
    public boolean canSeeBulb(int r, int c)
    {
        // TODO 15
        // if (r, c) is legal position, loop its right, left, down, up puzzles
        // if puzzle is bulb return true,
        // else if it's one of the blocks, break this loop and search for next direction
        if (isLegal(r, c)){
            for(int cp = c + 1; cp < size; cp++) {
                if (board[r][cp] == Space.BULB) return true;
                else if (board[r][cp] != Space.EMPTY) break;
            }
            for(int cm = c - 1; cm >= 0; cm--) {
                if (board[r][cm] == Space.BULB) return true;
                else if (board[r][cm] != Space.EMPTY) break;
            }
            for(int rp = r + 1; rp < size; rp++) {
                if (board[rp][c] == Space.BULB) return true;
                else if (board[rp][c] != Space.EMPTY) break;
            }
            for(int rm = r - 1; rm >= 0; rm--) {
                if (board[rm][c] == Space.BULB) return true;
                else if (board[rm][c] != Space.EMPTY) break;
            }
            return false;
        }
        else throw new IllegalArgumentException("Illegal Coordinates");
    }
    
    /**
     * Returns an assessment of the state of the puzzle, either 
     * "Clashing bulb at r,c", 
     * "Unlit square at r,c", 
     * "Broken number at r,c", or
     * three ticks, as on the LMS page. 
     * r,c must be the coordinates of a square that has that kind of error. 
     * If there are multiple errors on the board, you may return any one of them. 
     */
    public String isSolution()
    {
        // TODO 16
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                // if the cell has a bulb and can see bulb, clashing
                if (getBoard(y,x) == Space.BULB && canSeeBulb(y,x)) {
                    return "Clashing bulb at " + y +","+ x;}
                //if the cell is empty but can't see bulb, unlit
                if (getBoard(y,x) == Space.EMPTY && !canSeeBulb(y,x))
                    return "Unlit square at " + y +","+ x;
                // if the cell is one of the number block, 
                // compare the number of bulbs around it to its number, 
                // if not match, broken number
                else {
                    if ((getBoard(y,x) == Space.ONE && numberOfBulbs(y,x) != 1) ||
                        (getBoard(y,x) == Space.TWO && numberOfBulbs(y,x) != 2) ||
                        (getBoard(y,x) == Space.THREE && numberOfBulbs(y,x) != 3) ||
                        (getBoard(y,x) == Space.FOUR && numberOfBulbs(y,x) != 4) ||
                        (getBoard(y,x) == Space.ZERO && numberOfBulbs(y,x) != 0))
                    return "Broken number at " + y +","+ x;
                }
            }
        }
        return "\u2713\u2713\u2713";
    }
}