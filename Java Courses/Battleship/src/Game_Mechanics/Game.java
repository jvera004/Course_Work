/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Game_Mechanics;

import Player.*;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Game {

    private Player player1;
    private Player player2;
    private boolean someoneWon = false;

    public Game() {
    }

    public void Play() {
        getPlayers();
        DecimalFormat dratio = new DecimalFormat("#.##");
        while (!someoneWon) {
                player1.setEnemyBoard(player2.getBoard());
                player2.setEnemyBoard(player1.getBoard());
            if (player1.checkIfPlayerLost()) {
                JTextArea display = new JTextArea(player1.getHistory().printList(), 22, 33);
                display.setEditable(false);
                display.setTabSize(3);
                someoneWon = true;
                JOptionPane.showMessageDialog(null, player1.getName() + " won the game!");
                
                
               
                JOptionPane.showMessageDialog(null, player1.getName() + "\nHit Ratio: \t"
                        + dratio.format(player1.getHistory().getRatio()) + "\t" + "\n" + player1.getHistory().getHits()
                        + " Hits out of " + (player1.getHistory().getHits() + player1.getHistory().getMisses())
                        + " Shots fired.");
                JOptionPane.showMessageDialog(null, new JScrollPane(display), player1.getName() + "'s History", JOptionPane.INFORMATION_MESSAGE);
                
                
            } else if (player2.checkIfPlayerLost()) {
                someoneWon = true;
                JTextArea display = new JTextArea(player2.getHistory().printList(), 22, 33);
                display.setEditable(false);
                display.setTabSize(3);
                JOptionPane.showMessageDialog(null, player2.getName() + " won the game!");
                JOptionPane.showMessageDialog(null, player2.getName() + "\nHit Ratio: \t"
                        + dratio.format(player2.getHistory().getRatio()) + "\t" + "\n" + player2.getHistory().getHits()
                        + " Hits out of " + (player2.getHistory().getHits() + player2.getHistory().getMisses())
                        + " Shots fired.");
                JOptionPane.showMessageDialog(null, new JScrollPane(display), player2.getName() + "'s History", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, player1.getName() + "'s Turn", player1.getName(), JOptionPane.INFORMATION_MESSAGE);
                player1.Play();
                JOptionPane.showMessageDialog(null, player2.getName() + "'s Turn", player2.getName(), JOptionPane.INFORMATION_MESSAGE);
                player2.Play();
            }
        }
    }

    private void getPlayers() {

        //input validation for player names
        String player_one = JOptionPane.showInputDialog(null,
                "Choose a player:\n 1) Human \n 2) Computer ", "Player 1",
                JOptionPane.QUESTION_MESSAGE);

        while (!player_one.equals("1") && !player_one.equals("2")) {
            JOptionPane.showMessageDialog(null, "Invalid number!", "Bad Choice",
                    JOptionPane.ERROR_MESSAGE);
            player_one = JOptionPane.showInputDialog(null,
                    "Choose a player:\n 1) Human \n 2) Computer ", "Player 1",
                    JOptionPane.QUESTION_MESSAGE);
        }


        String player_two = JOptionPane.showInputDialog(null,
                "Choose a player:\n 1) Human \n 2) Computer ", "Player 2",
                JOptionPane.QUESTION_MESSAGE);

        while (!player_two.equals("1") && !player_two.equals("2")) {
            JOptionPane.showMessageDialog(null, "Invalid number!", "Bad Choice", JOptionPane.ERROR_MESSAGE);
            player_two = JOptionPane.showInputDialog(null,
                    "Choose a player:\n 1) Human \n 2) Computer ", "Player 2",
                    JOptionPane.QUESTION_MESSAGE);
        }

        //parse the number choices from the player
        int player_1 = Integer.parseInt(player_one);
        int player_2 = Integer.parseInt(player_two);

        //according to the numbers given, create the characters to the proper objects
        if (player_1 == 1) {
            JOptionPane.showMessageDialog(null, " Human Player", "Player 1", JOptionPane.INFORMATION_MESSAGE);
            player1 = new Human();
        }

        if (player_1 == 2) {
            JOptionPane.showMessageDialog(null, " Computer Player", "Player 1", JOptionPane.INFORMATION_MESSAGE);
            player1 = new Computer();
        }

        if (player_2 == 1) {
            JOptionPane.showMessageDialog(null, " Human Player", "Player 2", JOptionPane.INFORMATION_MESSAGE);
            player2 = new Human();
        }

        if (player_2 == 2) {
            JOptionPane.showMessageDialog(null, " Computer Player", "Player 2", JOptionPane.INFORMATION_MESSAGE);
            player2 = new Computer();
        }
        player1.setEnemyBoard(player2.getBoard());
        player2.setEnemyBoard(player1.getBoard());
    }
}
