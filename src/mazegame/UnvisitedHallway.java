/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mazegame;

/**
 *
 * @author Gavin
 */
public class UnvisitedHallway extends Sprite{
    /** An UnvisitedHallway Class for MazeGame
     * 
     * @param symbol character of the symbol
     * @param row given row
     * @param col given column
     */
    public UnvisitedHallway(char symbol, int row, int col) {
        /** initializes this UnvisitedHallways */
        super(symbol, row, col);
    }

    @Override
    public String toString() {
        /** Returns a print String statement */
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getCol() {
        /** Returns the column of UnvisitedHallway */
        return super.getCol(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getRow() {
        /** Returns the row of UnvisitedHallway */
        return super.getRow(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public char getSymbol() {
        /** Returns the Symbol of UnvisitedHallway */
        return super.getSymbol(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
