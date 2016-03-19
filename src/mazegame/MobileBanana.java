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
public class MobileBanana extends Banana implements Moveable{
    /** MobileBanana class for MazeGame
     * 
     * @param symbol character of the Banana
     * @param row given row
     * @param col given column
     * @param value points worth
     */
    
    public MobileBanana(char symbol, int row, int col, int value){
        
        super(symbol, row, col, value);
    }

    @Override
    public void move(int row, int col) {
        /** Moves row and column by given row and col value */
        this.row += row;
        this.col += col;
    }

    @Override
    public char getSymbol() {
        /**
        * Returns character symbol for this class
        */
        return super.getSymbol(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getRow() {
        /**
        * Returns row for this class
        */
        
        return super.getRow(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getCol() {
        /**
        * Returns columb for this class
        */
        return super.getCol(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        /**
        * Returns toString which is inherits from parent
        */
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getValue() {
        /**
        * Returns value point of this class
        */
        return super.getValue(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
