
/**
 * Jonathan Vera
 * COP 3337
 * Assignment 1
 *
 * I certify that this code is all of my own work.
 */
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class play {

    public static void main(String[] args) {
        int playerOneWins = 0;
        int playerTwoWins = 0;
        int playerTies = 0;
        int games = 0;

        TileGame board = new TileGame();
        NumberTile[] playerOne = board.getHand();
        NumberTile[] playerTwo = board.getHand();
        

        JOptionPane.showMessageDialog(null,"Player 1's hand: \n" + playerOne.toString()
                + "\n\n\n" + "Player 2's hand: \n" + playerTwo.toString() + "\n");
        
        while (playerOne.length != 0 && playerTwo.length != 0) {
            board.makeMove(playerOne);
            board.makeMove(playerTwo);
            if (playerOne.length == 0 && playerTwo.length == 0) {
                playerTies += 1;
                JOptionPane.showMessageDialog(null,"It's a tie!");
            }
            if (playerOne.length == 0 && playerTwo.length != 0) {
                playerOneWins += 1;
                JOptionPane.showMessageDialog(null,"Player 1 wins!");
            }
            if (playerTwo.length == 0 && playerOne.length != 0) {
                playerTwoWins += 1;
                JOptionPane.showMessageDialog(null,"Player 2 wins!");
            }
        }//end while
        JOptionPane.showMessageDialog(null, "Tiles on the Board: \n" + board.toString()
                + "\nPlayer 1 wins: " + playerOneWins + "\nPlayer ties:  " + playerTies);
        playerOneWins = 0;
        playerTwoWins = 0;
        playerTies = 0;
        while (games != 1) {
            board = new TileGame();
            playerOne = board.getHand();
            playerTwo = board.getHand();

            while (playerOne.length != 0 && playerTwo.length != 0) {
                board.makeMove(playerOne);
                board.makeMove(playerTwo);
                if (playerOne.length == 0 && playerTwo.length == 0) {
                    playerTies += 1;
                    System.out.println("It's a tie!");
                }
                if (playerOne.length == 0 && playerTwo.length != 0) {
                    playerOneWins += 1;
                    System.out.println("Player 1 wins!");
                }
                if (playerTwo.length == 0 && playerOne.length != 0) {
                    playerTwoWins += 1;
                    System.out.println("Player 2 wins!");
                }
            }//end one game
            games++;
        }//end 10000 games
        JOptionPane.showMessageDialog(null, "Tiles on the Board: \n" + board.toString()
                + "\nPlayer 1 wins: " + playerOneWins + "\nPlayer ties:  " + playerTies);

        //to be continued....
    }//end main
}