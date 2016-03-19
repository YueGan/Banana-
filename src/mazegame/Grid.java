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
public interface Grid<T> {
    /**
    * An array of items in MazeGame
    */
    public void setCell(int row, int col, T item);
    public T getCell(int row, int col);
    public int getNumRows();
    public int getNumCols();
    public boolean equals(Grid<T> other);
    public String toString();
    
}
