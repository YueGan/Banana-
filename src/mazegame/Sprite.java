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
public abstract class Sprite {
    /** abstract class Sprite for implementation of different Sprite objects */
    
    protected char symbol;
    protected int row;
    protected int col;
    
    public Sprite(char symbol, int row, int col){
        /** initializes Sprite class */
        this.symbol = symbol;
        this.row = row;
        this.col = col;
        
        
    }

    public char getSymbol() {
        /** Returns the Symbol of Sprite */
        return symbol;
    }

    public int getRow() {
        /** Returns the row of Sprite */
        return row;
    }

    public int getCol() {
        /** Returns the column of Sprite */
        return col;
    }

    @Override
    public String toString() {
        /** Returns a print String statement */
        return Character.toString(symbol);
    }
    
    
    
}
