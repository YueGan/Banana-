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
public class Wall extends Sprite{

    public Wall(char symbol, int row, int col) {
        /** initializes this Wall */
        super(symbol, row, col);
    }

    @Override
    public String toString() {
        /** Returns a print String statement */
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getCol() {
        /** Returns the column of Wall */
        return super.getCol(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getRow() {
        /** Returns the row of Wall */
        return super.getRow(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public char getSymbol() {
        /** Returns the Symbol of Wall */
        return super.getSymbol(); //To change body of generated methods, choose Tools | Templates.
    }    
}
