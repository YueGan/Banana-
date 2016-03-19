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
public class Monkey extends Sprite implements Moveable{
    /** Monkey class for MazeGame
     * 
     */
    private int score;
    private int numMoves;
    
    public Monkey(char symbol, int row, int col){
        /**
        * Initialization of Monkey
        */
        
        super(symbol, row, col);
        
    }

    public void eatBanana(int score){
        /** adds received point to score of this class */
        this.score += score;
    }
    
    public int getScore() {
        /**
         * Returns the score of Monkey
        */
        return score;
    }

    public int getNumMoves() {
        /**
         * Returns the Number of Moves of Monkey
        */
        return numMoves;
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getCol() {
        /**
         * Returns the column of this class
        */
        return super.getCol(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getRow() {
        /**
         * Returns the row of this class
        */
        return super.getRow(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public char getSymbol() {
        /**
         * Returns the symbol of this class
        */
        return super.getSymbol(); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void move(int row, int col) {
        /** Moves row and column by given row and col value 
         * adds number of Moves by 1 each move taken
         */
        this.row += row;
        this.col += col;
        this.numMoves += 1;        
    }
    
    
}
