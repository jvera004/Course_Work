package Game_Mechanics;

import java.util.Random;
import javax.swing.JOptionPane;

public class Board {
    Random random = new Random();
    private int health = 0;
    private int numberOfShips;
    private int cruiser = 1; //length of 1 spot
    private int patrol = 1; //length of 3 spots
    private int destroyer = 1; //length of 5 spots
    public final int COLUMNS = 10;
    public final int ROWS = 10;
    private int[][] playerBoard = new int[ROWS][COLUMNS];
    
    public Board(){
        setNumberOfShips(5);
        setShipLengthNumbers();
    }
    
    public int getRows(){
        return ROWS;
    }
    
    public int getCols(){
        return COLUMNS;
    }
    
    public int[][] getBoard(){
        return playerBoard;
    }
    
    public void decrementHealth(){
        health--;
    }
    
    public int getHealth(){
        return health;
    }

    public int getCruiser() {
        return cruiser;
    }
    
    public void decrementCruiser(){
        cruiser--;
    }
    
    public void decrementPatrol(){
        patrol--;
    }
    
    public void decrementDestroyer(){
        destroyer--;
    }

    public int getDestroyer() {
        return destroyer;
    }
    
    public int getPatrol() {
        return patrol;
    }

    public int getNumberOfShips() {
        return numberOfShips;
    }

    
    public void setNumberOfShips(int ships){
        numberOfShips = ships;
    }
    
    public void setShipLengthNumbers(){
        int count = 3;
        while( count < numberOfShips){
            int randomNumber = random.nextInt(numberOfShips) + 1;
            switch (randomNumber){
                    case 1: cruiser++; count++; break;
                    case 3: patrol++; count++; break;
            }
        }
        health = (getCruiser()) + (5) + (getPatrol() * 3);
    }


    //added else statements and the position is not empty dialog box
    public Boolean checkValidPlacement(int row, int col, int size, String orientation){
        if(checkIfEmpty(row,col)){
            if(orientation.equalsIgnoreCase("h")){
                if(checkBoundary(row,col,size,orientation) && checkHorizontal(row,col,size)){
                    return true;
                }
                else{
                    JOptionPane.showMessageDialog(null, "Cannot place ship horizontally at these coordinates: " + row
                            + " ," + col,"Error!", JOptionPane.ERROR_MESSAGE);
                }
            }
            else if(orientation.equalsIgnoreCase("v")){
                if(checkBoundary(row,col,size,orientation) && checkVertical(row,col,size)){
                    return true;
                }
                else{
                    JOptionPane.showMessageDialog(null, "Cannot place ship vertically at these coordinates: " + row + " ,"
                            + col,"Error!", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        else
            JOptionPane.showMessageDialog(null, "Position is not empty!","Error!", JOptionPane.ERROR_MESSAGE);
            return false;
    }
    
    public Boolean checkIfEmpty(int row, int col){
        if(playerBoard[row][col] == 0){
            return true;
        }
        return false;
    }
    
    private Boolean checkHorizontal(int row, int col, int size){
        boolean valid = false;
        int length = 0;
        while(length < size){
            if(playerBoard[row][col] != 1  && 
               playerBoard[row][col] != 3  && 
               playerBoard[row][col] != 5 ){
                valid = true; //spot is good to go
                col++;    //change the column
                length++;   //up to the size of the ship
            }
            else valid = false;
        }
        return valid;
    }
    
    private Boolean checkVertical(int row, int col, int size){
        boolean valid = false;
        int length = 0;
        while(length < size){
            if(playerBoard[row][col] != 1 && 
               playerBoard[row][col] != 3 && 
               playerBoard[row][col] != 5 ){
                valid = true; //spot is good to go
                row++;    //change the row
                length++;   //up to the size of the ship
            }
            else valid = false;
        }
        return valid;
    }
    
    //-1
    private Boolean checkBoundary(int row, int col, int size, String orientation){
        boolean valid = false;
        if(orientation.equalsIgnoreCase("h")){
            if((col + size) > COLUMNS)
                valid = false;
            else valid = true;
        }
        if(orientation.equalsIgnoreCase("v")){
            if((row + size) > ROWS)
                valid = false;
            else valid = true;
        }
        return valid;
    }
    
    //
    public void placeShip(int row, int col, int size, String orientation){
        if(checkValidPlacement(row,col,size,orientation)){
            if(orientation.equalsIgnoreCase("h")){
                int horiz = 0;
                while (horiz < size){
                    playerBoard[row][col] = size;
                    col++;
                    horiz++;
                }
            }

            if(orientation.equalsIgnoreCase("v")){
               int vert = 0;
                while (vert < size){
                    playerBoard[row][col] = size;
                    row++;
                    vert++;
                }
            }
        }
        else 
            JOptionPane.showMessageDialog(null,"Bad Coordinates!", "Error!", JOptionPane.ERROR_MESSAGE);
    }
    
    
    public String printBoard(){
        String out = "";
        String tmp = "";
        int init = 0;
        out += "\t";
        //prints out the column headings
            while( init < COLUMNS){
                out += init + "\t";
                if( init + 1 == COLUMNS){
                    out += "\n     |----------------------------------------------------------------------------------|\n";
                }
                init++;
            }
        for(int row = 0; row < ROWS; row++){
            //prints out the row headings
            out += row + "   |\t";
            for(int col = 0; col < COLUMNS; col++){
                tmp = playerBoard[row][col] + "   |\t";
                out += tmp;
            }
            if((row + 1) != ROWS)
                out += "\n     |----------------------------------------------------------------------------------|\n";
        }
        return out;
    }
}
