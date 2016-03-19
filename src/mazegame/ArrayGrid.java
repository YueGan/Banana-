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
public class ArrayGrid<T> implements Grid<T> {
     /**
     * Private variables for ArrayGrid
     */
    private int numRows;
    private int numCols;
    private T[][] items; // Stores items as 2d array
    private String bigMaze; //Summarizes the maze as a string
    
    
    public ArrayGrid(int numRows, int numCols){
        /**
         * Initialization of ArrayGrid
        */
        
        this.numRows = numRows;
        this.numCols = numCols;
        items = (T[][])new Object[numRows][numCols];
    }


    @Override
    public void setCell(int row, int col, T item) {
        /**
         * Places item on given coordinate
        */
        items[row][col] = item;
    }

    @Override
    public T getCell(int row, int col) {
        /**
         * Retrieves item from given coordinate and returns
        */
        return items[row][col];
    }

    @Override
    public int getNumRows() {
        /**
         * Returns number of rows in this ArrayGrid
        */
        return numRows;
    }

    @Override
    public int getNumCols() {
        /**
         * Returns number of columns in this ArrayGrid
        */
        return numCols;
    }

    @Override
    public boolean equals(Grid<T> other) {
        /**
         * Compares this ArrayGrid with another ArrayGrid for equality
        */
        for(int i = 0; i < numRows; i ++){
            
            for(int j = 0; j < numRows; j ++){
                
                if (!(other.getCell(i, j) == getCell(i,j)))
                    return false; // If any the item are mismatched, returns 
                                   //false
            }
        }
        return true;
    }
    
    @Override
    public String toString(){
        /**
         * Returns the maze as a whole string
        */
        
        bigMaze = "";
        for(int i = 0; i < numRows; i++){
            
            for(int j = 0; j < numCols; j++){
                
                bigMaze += items[i][j];
                
            }
            bigMaze += "\n"; //New line
        }
        
        return bigMaze;
    }
}
