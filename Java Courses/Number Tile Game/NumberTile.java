/**
 * Jonathan Vera
 * COP 3337
 * Assignment 1
 * 
 * I certify that this code is all of my own work.
 */
import java.util.Random;

public class NumberTile {
    private int[] tile;
    Random dice = new Random();
    
    //This constructor constructs a number tile using 4 random integers in the range 1 to 9.
    public NumberTile() {
        tile = new int[4];
        for(int i = 0; i < tile.length; i++){
            tile[i] = dice.nextInt(9)+1;
        }
    }// end constructor 1
    
    //This is used for to construct a known hand
    public NumberTile(int[] tile) {
        this.tile = new int[4];
        System.arraycopy(tile, 0, this.tile, 0, tile.length ) ;
    }// end constructor 2
    
    //This method rotates the tile 90 degrees
    public NumberTile rotate() {
        int temp = tile[0];
        tile[0] = tile[3];
        tile[3] = tile[2];
        tile[2] = tile[1];
        tile[1] =  temp;
        return new NumberTile(tile);
    }// end rotate
    
    public int getLeft() {
        return tile[0];
    }// end getLeft
    
    public int getRight() {
        return tile[2];
    }// end getRight
    
    @Override
    public String toString() {
        String out ="\n" +"    " + tile[1] + "\n" + tile[0]
                   + "       " + tile[2] + "\n    " + tile[3] + "\n";
        // returns the tile as a string in the form
        //    4
        // 5      7
        //    1
        return out;
    }// end toString
}// end NumberTile