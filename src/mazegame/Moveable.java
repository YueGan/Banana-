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
public interface Moveable {
    /**
     * implements must have move method
     * @param row is the given row
     * @param col is the given column
     */
    
    public void move(int row, int col);
    
}
