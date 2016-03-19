package mazegame;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * A class that represents the basic functionality of the maze game.
 * This class is responsible for performing the following operations:
 * 1. At creation, it initializes the instance variables used to store the
 *        current state of the game.
 * 2. When a move is specified, it checks if it is a legal move and makes the
 *        move if it is legal.
 * 3. It reports information about the current state of the game when asked.
 */
public class MazeGame {

    /** A random number generator to move the MobileBananas. */
    private Random random;
    
    /** The maze grid. */
    private Grid<Sprite> maze;
    
    /** The first player. */
    private Monkey player1;
    
    /** The second player. */
    private Monkey player2;

    /** The bananas to eat. */
    private List<Banana> bananas;
    
    /**
     * @param layoutFileName
     */
    public MazeGame(String layoutFileName) throws IOException {
        /**
         * Initialization of MazeGame, which takes a fileName for reading
        */
        random = new Random();        
        
        int[] dimensions = getDimensions(layoutFileName);
        maze = new ArrayGrid<Sprite>(dimensions[0], dimensions[1]);
        
               
        BufferedReader br = new BufferedReader(new FileReader(layoutFileName));

	/* INITIALIZE THE GRID HERE */
        
        
        String nextLine = br.readLine();
        bananas = new ArrayList<Banana>(); //Initializing List of Bananas
 
        /* Reading all characters in text file and generate appropriate 
                                                                    classes*/
        
        // Reads by rows
        for(int i = 0; i < dimensions[0]; i++){
            
            //Reads by columns
            for(int j = 0; j < nextLine.length(); j++){
                
                //if read item is x, then create wall class, 
                if(nextLine.charAt(j) == MazeConstants.WALL){
                    Wall iWall = new Wall(MazeConstants.WALL,i,j);
                    maze.setCell(i, j, iWall); // sets item on grid
                }
                
                //similar as above
                else if(nextLine.charAt(j) == MazeConstants.BANANA){
                    Banana iBanana = new Banana(MazeConstants.BANANA, i, j, 
                            MazeConstants.BANANA_SCORE);
                    bananas.add(iBanana); //banana kind, add to list
                    maze.setCell(i, j, iBanana);
                }
                
                //similar as above
                else if(nextLine.charAt(j) == MazeConstants.MOBILE_BANANA){
                    MobileBanana iMobileBanana = new MobileBanana(MazeConstants.MOBILE_BANANA, 
                            i, j, MazeConstants.MOBILE_BANANA_SCORE);
                    bananas.add(iMobileBanana); //banana kind, ad to list
                    maze.setCell(i, j, iMobileBanana);
                }
                
                //similar as above
                else if(nextLine.charAt(j) == MazeConstants.P1){
                    player1 = new Monkey(MazeConstants.P1,i,j);
                    maze.setCell(i, j, player1);
                }
                
                //similar as above
                else if(nextLine.charAt(j) == MazeConstants.P2){
                    player2 = new Monkey(MazeConstants.P2,i,j);
                    maze.setCell(i, j, player2);
                }
                
                //similar as above
                else if(nextLine.charAt(j) == MazeConstants.VISITED){
                    VisitedHallway vWall = new VisitedHallway(MazeConstants.VISITED,i,j);
                    maze.setCell(i, j, vWall);
                }
                
                //similar as above
                else if(nextLine.charAt(j) == MazeConstants.VACANT){
                    UnvisitedHallway iBlank = new UnvisitedHallway(MazeConstants.VACANT,i,j);
                    maze.setCell(i, j, iBlank);
                }
                
            }
            
            //reads new line
            nextLine = br.readLine();
            
            
        }
	
        br.close();
    }

    public Grid<Sprite> getMaze() {
        /** Returns this ArrayGrid */
        return maze;
    }

    public Monkey getPlayerOne() {
        /** Returns Player1 */
        return player1;
    }

    public Monkey getPlayerTwo() {
        /** Returns Player2 */        
        return player2;
    }
    
    public int getNumRows() {
        /** Returns Number of Rows */
        return maze.getNumRows();
    }
    
    public int getNumCols() {
        /** Returns Number of Rows */
        return maze.getNumCols();
    }
    
    public Sprite get(int i, int j){
        /** Returns item at given location */
        return maze.getCell(i,j);
    }
    
    public void move(char nextMove){
        /** Moves player according to valid inputs
         * nextMove is a valid input character key
         */
        
        //Checks if no more moves can be made
        isBlocked();
        
        //if input key matches P1's UP button
        switch(nextMove){
            case MazeConstants.P1_UP:
                swap("UP", player1); // begins swaping of two items
                break;
            case MazeConstants.P1_LEFT:
                swap("LEFT", player1);
                break;
            case MazeConstants.P1_DOWN:
                swap("DOWN", player1);
                break;
            case MazeConstants.P1_RIGHT:
                swap("RIGHT", player1);
                break;
            case MazeConstants.P2_UP:
                swap("UP", player2); // begins swaping of two items
                break;
            case MazeConstants.P2_LEFT:
                swap("LEFT", player2);
                break;
            case MazeConstants.P2_DOWN:
                swap("DOWN", player2);
                break;
            case MazeConstants.P2_RIGHT:
                swap("RIGHT", player2);
                break;
                
        }
        /**
        if(nextMove == MazeConstants.P1_UP){
            swap("UP", player1); // begins swaping of two items
        }
        //Similar as above
        else if(nextMove == MazeConstants.P1_LEFT){
            swap("LEFT", player1);
        }
        else if(nextMove == MazeConstants.P1_DOWN){
            swap("DOWN", player1);
        }
        else if(nextMove == MazeConstants.P1_RIGHT){
            swap("RIGHT", player1);
        }
        else if(nextMove == MazeConstants.P2_UP){
            swap("UP", player2);
        }
        else if(nextMove == MazeConstants.P2_LEFT){
            swap("LEFT", player2);
        }
        else if(nextMove == MazeConstants.P2_DOWN){
            swap("DOWN", player2);
        }
        else if(nextMove == MazeConstants.P2_RIGHT){
            swap("RIGHT", player2);
        }
        */
    }
    
    public void swap(String direction, Monkey player){
        /** Swaps position according to direction and the player
         * direction identifies which item to swap with
         * player is the player according to input
         */
        
        int row = player.getRow();
        int col = player.getCol();

        if (direction == "UP"){
            //Checks if given direction is moveable
            if(canMove(maze.getCell(row + MazeConstants.UP, col))){
                
                //if does, obtain the banana in front
                eatsBanana(maze.getCell(row + MazeConstants.UP, col), player);
                
                //moves player to the given direction
                player.move(MazeConstants.UP,0);
                
                //update visual
                maze.setCell(player.getRow(), col, player);                
                
                //mark visited
                visited(row, col);
            }
        }
        
        else if (direction == "DOWN"){
            //Similar as above
            if(canMove(maze.getCell(row + MazeConstants.DOWN, col))){
                eatsBanana(maze.getCell(row + MazeConstants.DOWN, col), player);
                player.move(MazeConstants.DOWN,0);
                maze.setCell(player.getRow(), col, player);
                visited(row, col);
            }
        }
        else if (direction == "LEFT"){
            //Similar as above
            if(canMove(maze.getCell(row, col + MazeConstants.LEFT))){
                eatsBanana(maze.getCell(row, col + MazeConstants.LEFT), player);
                player.move(0,MazeConstants.LEFT);
                maze.setCell(row, player.getCol(), player);
                visited(row, col);
            }
        }
        else if (direction == "RIGHT"){
            //Similar as above
            if(canMove(maze.getCell(row, col + MazeConstants.RIGHT))){
                eatsBanana(maze.getCell(row, col+ MazeConstants.RIGHT), player);
                player.move(0,MazeConstants.RIGHT);
                maze.setCell(row, player.getCol(), player); 
                visited(row, col);
            }
        }
        
    }
    
    public void visited(int row, int col){
        /** Marks player past route as visited
         * row and col gives coordinate on where to mark visited
         */     
        
        //Creates new visited Hallway vWall
        VisitedHallway vWall = new VisitedHallway(MazeConstants.VISITED, row, 
                col);
        maze.setCell(row, col, vWall);
        moveBanana(); //only after the player moved, then move banana
    }
    
    public void moveBanana(){
        /** Moves Banana, step takes place after player has moved. */     
        
        int cases; //initializes number holder for random generator
           
        // runs all bananas in the list<Banana>
        for (Banana banana: bananas){
            
            //pick out the ones that are MobileBanana object
            if(banana instanceof MobileBanana){
                
                // Casting so MobileBanana.move() is useable
                MobileBanana mbanana = (MobileBanana)banana;
                
                int row = mbanana.getRow();
                int col = mbanana.getCol();                
                
                // generates random variable
                cases = random.nextInt(3) + 0;

                // moves banana depending on its generated number
                switch(cases){
                    
                    //I.E case 0 moves banana UP
                    case 0:
                        if (canMoveBanana(maze.getCell(row+MazeConstants.UP, 
                                col))){
                            
                            // do not refresh hallway if Monkey is right behind
                            if (!(maze.getCell(row+MazeConstants.DOWN, col) 
                                    instanceof Monkey))
                                
                                //refreshes hallway to unvisited
                                unvisited(row, col);
                            
                            //moves banana
                            mbanana.move(MazeConstants.UP,0);
                            
                            //visual update
                            maze.setCell(mbanana.getRow(), col, mbanana);
                        }
                        // end case;
                        break;

                    //Similar as above
                    case 1:
                        if (canMoveBanana(maze.getCell(row+MazeConstants.DOWN, 
                                col))){
                            if (!(maze.getCell(row+MazeConstants.UP, col) 
                                    instanceof Monkey))
                                unvisited(row, col);                            
                            mbanana.move(MazeConstants.DOWN,0);
                            maze.setCell(mbanana.getRow(), col, mbanana);

                        }
                        break;

                    //Similar as above
                    case 2:
                        if (canMoveBanana(maze.getCell(row, col + 
                                MazeConstants.LEFT))){
                            if (!(maze.getCell(row, col+MazeConstants.RIGHT) 
                                    instanceof Monkey))
                                unvisited(row, col);
                            mbanana.move(0,MazeConstants.LEFT);
                            maze.setCell(row, mbanana.getCol(), mbanana);

                        }
                        break;
                    
                    //Similar as above
                    case 3:
                        if (canMoveBanana(maze.getCell(row, col + 
                                MazeConstants.RIGHT))){
                            if (!(maze.getCell(row, col+MazeConstants.LEFT) 
                                    instanceof Monkey))
                                unvisited(row, col);
                            mbanana.move(0,MazeConstants.RIGHT);
                            maze.setCell(row, mbanana.getCol(), mbanana);

                        }
                        break;                        
                }
            } 
        }
    }
    
    public void unvisited(int row, int col){
        /** Marks unvisited hallway as unvisited.
         * row, col gives coordinate of where to set unvisited. 
         */     
        
        // creates new unvisited hallway
        UnvisitedHallway hallway = new UnvisitedHallway(MazeConstants.VACANT, 
                row, col);
        
        // sets cell and visual update
        maze.setCell(row, col, hallway);
        
    }

    
    public boolean canMoveBanana(Sprite cell){
        /** Returns true if MobileBanana can move. 
         *MobileBanana can move iff the next cell is Unvisited Hallway
         */
        
        return cell instanceof UnvisitedHallway;
    }
    public boolean canMove(Sprite cell){
        /** Returns true if Monkey can move. 
         * Monkey can moves iff the next cell is either UnvisitedHallway, Banana
         * or MobileBanana
         */

        return cell instanceof UnvisitedHallway || cell instanceof Banana 
                || cell instanceof MobileBanana;
    }
    
    public void eatsBanana(Sprite cell, Monkey player){
        /** Eats banana and deleting if from <List>Banana. 
         * cell is the nextCell in which player is moving to
         * player is the given Monkey object(player 1 or player 2)
         */
        
        
        if (cell instanceof Banana){
            
            //player eatBanana and award with corresponding score
            player.eatBanana(MazeConstants.BANANA_SCORE);
            //retrieve the banana object
            Banana banana = (Banana)cell;
            //deleting it from the list
            bananas.remove(banana);
        }
        
        //Similar as above
        else if (cell instanceof MobileBanana){
            player.eatBanana(MazeConstants.MOBILE_BANANA_SCORE);
            MobileBanana mBanana = (MobileBanana)cell;
            bananas.remove(mBanana);
        }
    }
    
    public int hasWon(){
        /** Returns the final result as int 0-3
         * p1 wins, loses, ties, no winner, correspondingly         
         */
        
        if (bananas.isEmpty()){
            if (player1.getScore() > player2.getScore())
                return 1;
            if (player1.getScore() < player2.getScore())
                return 2;
            else 
                return 3;
        }
        return 0;
    }
    
    public boolean isBlocked(){
        /** Returns true if no more steps can be made by p1 and p2*/
        
        // stores player1,2 rows and column to reduce repetetive calls                     
        int p1r = player1.getRow();
        int p1c = player1.getCol();
        int p2r = player2.getRow();
        int p2c = player2.getCol();
        
        //initializes canPlay variable
        boolean canPlay = canMove(maze.getCell(p1r + MazeConstants.UP, p1c));
       
        
        canPlay = canPlay | canMove(maze.getCell(p1r + MazeConstants.DOWN, 
                p1c));
        canPlay = canPlay | canMove(maze.getCell(p1r, p1c 
                + MazeConstants.LEFT));       
        canPlay = canPlay | canMove(maze.getCell(p1r, p1c 
                + MazeConstants.RIGHT));       
            
        canPlay = canPlay | canMove(maze.getCell(p2r + MazeConstants.UP, p2c));       
        canPlay = canPlay | canMove(maze.getCell(p2r + MazeConstants.DOWN, 
                p2c));       
        canPlay = canPlay | canMove(maze.getCell(p2r, p2c 
                + MazeConstants.LEFT));       
        canPlay = canPlay | canMove(maze.getCell(p2r, p2c 
                + MazeConstants.RIGHT));            
        
        //if any of the 8 valid keys is moveable, the final canPlay return True
        // thus invert it as false, game continues.
        return !canPlay;
    }
    
    private int[] getDimensions(String layoutFileName) throws IOException {       
        
        BufferedReader br = new BufferedReader(new FileReader(layoutFileName));
    
        // find the number of columns
        String nextLine = br.readLine();
        int numCols = nextLine.length();

        int numRows = 0;
    
        // find the number of rows
        while (nextLine != null && nextLine != "") {
            numRows++;
            nextLine = br.readLine();
        }
        
        br.close();
        return new int[]{numRows, numCols};
    }
}
