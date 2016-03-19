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
public class Banana extends Sprite{
    /** Banana class for MazeGame
     * Protected variables for Banana
     */
    protected int value;
    
    public Banana(char symbol, int row, int col, int value){
        /**
         * Initialization of Banana
        */
        super(symbol, row, col);
        this.value = value;
    }

    public int getValue() {
        /** Returns the value of Banana */
        return value;
    }

    @Override
    public String toString() {
        /**
         * Returns toString which is inherits from parent.
        */
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getCol() {
        /**
         * Returns getCol() which is inherits from parent.
        */
        return super.getCol(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getRow() {
        /**
         * Returns getRow() which is inherits from parent.
        */
        return super.getRow(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public char getSymbol() {
        /**
         * Returns getSymbol which is inherits from parent.
        */
        return super.getSymbol(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
