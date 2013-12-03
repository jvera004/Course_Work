package Player;

import Game_Mechanics.*;

public abstract class Player {
    
    //this will be one players turn, not the whole game
    public abstract void Play();
    
    //sets the name of the player
    public abstract void setName();
    
    //will check if the player sent in has no health and no ships
    public abstract boolean checkIfPlayerLost();
    
    //add the current coordinates and whatnot to the linkedlist of the player's history
    public abstract void addToPlayerHistory();

    //prints out the full player history
    public abstract void printHistory();

    //returns the player history
    public abstract LinkedList getHistory();
    
    public abstract void setEnemyBoard(Board enemy);
    
    public abstract Board getBoard();
    
    //this method will check the coordinates gotten in the method setCoordinates will hit a ship or not
    //and set the flag in each players class if it hit or missed
    public abstract void attack();
    
    //in human this will ask the player for attack coordinates
    //in computer this get random coordinates to attack with
    public abstract void setCoordinates();

    public abstract String getName();
}
