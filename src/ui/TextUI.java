/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ui;

import mazegame.MazeGame;
import java.util.Scanner;
import mazegame.MazeConstants;
/**
 *
 * @author Gavin
 */
public class TextUI implements UI{
    /** a TextUI class for mazegame.Play */
    private MazeGame game;
    private Scanner keyboard = new Scanner(System.in);
    
    public TextUI(MazeGame game){
        /** initializes TextUI */
        this.game = game;
    }
    
    @Override
    public void launchGame() {
        /** starts game */
        
        // initializing valid keys with 8 given keys
        char[] validkeys ={MazeConstants.P1_UP, MazeConstants.P1_DOWN, 
            MazeConstants.P1_LEFT, MazeConstants.P1_RIGHT, MazeConstants.P2_UP, 
            MazeConstants.P2_DOWN, MazeConstants.P2_LEFT, 
            MazeConstants.P2_RIGHT}; 
        
        // initializes legit: if key is valid then proceed
        boolean legit;
        
        // initializes endGame: if endGame is reached, stop program
        boolean endGame = true;

        //initializes keyboard
        String nextMove = keyboard.nextLine();
        
        // starts loop until endGame is reached
        while(endGame){
            
            //visual update
            System.out.println(game.getMaze().toString());
            
            //refreshes legit variable
            legit = false;
            
            //wait for next input
            nextMove = keyboard.nextLine();
            
            // checks if input is in validKays
            if (nextMove.length() == 1){
                for (char valid: validkeys){
                    if (valid == nextMove.charAt(0))
                        legit = true;
                }
                
                //if key valid, proceed
                if (legit){
                    
                    //uses game.move builded previously
                    game.move(nextMove.charAt(0));
                    //updates the game
                    this.game = game;
                }
                // if key invalid, yeld warning
                else
                    System.out.println("Please enter a valid key");
                
                
            }
            
            //if endGame is reached, display winner and stops the game
            if (game.isBlocked()){
                displayWinner();
                endGame = false;
            }
        
        }
    }

    @Override
    public void displayWinner() {
        int won = game.hasWon();
        int moves = 0;
        
        
        if (game.isBlocked()) { // no winners
            System.out.println("Game over! Both players are stuck.");
        } else {
            if (won == 0) { // game is still on
                return;
            } else if (won == 1) {
                System.out.println("Congratulations Player 1! You won the maze in " + 
                          game.getPlayerOne().getNumMoves() + " moves.");
            } else if (won == 2) { 
                System.out.println("Congratulations Player 2! You won the maze in " + 
                          game.getPlayerTwo().getNumMoves() + " moves.");
            } else { // it's a tie
                System.out.println("It's a tie!");
            }
        }
                
    }
    
}
