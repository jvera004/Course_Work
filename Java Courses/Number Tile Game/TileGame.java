
/**
 * Jonathan Vera
 * COP 3337
 * Assignment 1
 * 
 * I certify that this code is all of my own work.
 */
public class TileGame {

    // Constructs an empty board
    private NumberTile[] board;

    public TileGame() {
        board = new NumberTile[1];
    }// end constructor

    //Accessor for the board
    public NumberTile[] getBoard() {
        return board;
    }

    // Constructs and returns a hand of 5 random number tiles
    public NumberTile[] getHand() {
        NumberTile[] hand = new NumberTile[5];
        for (int counter = 0; counter < 5; counter++) {
            hand[counter] = new NumberTile();
        }
        return hand;
    }// end getHand

    // If tile fits in the board (without rotating) then
    // return the index i of a tile in the board
    // so that tile fits before ti for i = 0..k-1
    // If the tile does not fit
    public int getIndexForFit(NumberTile tile) {
        board = getBoard();
        if (board[0] == null) {
            return 0;
        }
        if (board[0].getLeft() == tile.getRight()) {
            return 0;
        }
        if (board[board.length - 1].getRight() == tile.getLeft()) {
            return board.length;
        }
        for (int i = 0; i < board.length - 2; i++) {
            if (board[i].getRight() == tile.getLeft()
                    && tile.getRight() == board[i + 1].getLeft()) {
                return i + 1;
            }
        }
        return -1;
    }// end getIndexForFit

    // Use the method getIndexForFit to insert tile into the board 
    //(if possible). In this method tile can be rotated. If a rotation
    //yields a successful fit insert tile into the board and return true.
    //If tile does not fit after rotating (at most 3 times) then return false.
    public boolean insertTile(NumberTile tile) {
        int index = -1;
        int rotations = 0;
        while (rotations < 4) {
            index = getIndexForFit(tile);
            if (index != -1) {
                NumberTile[] tempBoard = new NumberTile[board.length + 1];
                System.arraycopy(board, 0, tempBoard, 1, board.length);
                tempBoard[index] = tile;
                board = tempBoard;
                return true;
            }
            rotations++;
            tile = tile.rotate();
        }
        return false;
    }// end insertTile

    //Make a move from hand i.e. if a tile in the hand fits on the board
    //then remove it from the hand and place it in the board. If no tile
    //from the hand fits then add another tile to the hand
    public void makeMove(NumberTile[] hand) {
        for (int counter = 0; counter < hand.length; counter++) {
           if(insertTile(hand[counter])){
               NumberTile[] tempHand = new NumberTile[hand.length - 1];
                System.arraycopy(hand, 0, tempHand, 0, counter);
                System.arraycopy(hand, counter + 1, tempHand, counter, (hand.length - 1) - counter);
                hand = tempHand;
               return;
           }
       }
        NumberTile[] temp = new NumberTile[hand.length + 1];
        System.arraycopy(hand, 0, temp, 0, hand.length);
        temp[(hand.length)] = new NumberTile();
        hand = temp;
    }// end makeMove

    public String toString() {
        return board.toString();
    }
}// end TileGame