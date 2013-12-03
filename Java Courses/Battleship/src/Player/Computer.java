package Player;

import Game_Mechanics.*;
import java.io.FileReader;
import java.util.Random;
import javax.swing.JOptionPane;
import java.util.Scanner;
import javax.swing.JTextArea;

public class Computer extends Player {

    Random random = new Random();
    private String name;
    private int rowCoordinate = 0;
    private int colCoordinate = 0;
    private int shipSize;
    private boolean hitOrMiss = false;
    private boolean shipsSet = false;
    private Board board = new Board();
    private Board enemyBoard = new Board();
    private Board dummyBoard = new Board();
    private LinkedList playerHistory = new LinkedList();

    public Computer() {
        setName();
        getShipPlacements();
    }

    @Override
    public Board getBoard() {
        return board;
    }

    @Override
    public void setEnemyBoard(Board enemy) {
        enemyBoard = enemy;
    }

    public int getHealth() {
        return enemyBoard.getHealth();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName() {
        try {
            setRandomName();
        } catch (java.io.IOException e) {
            System.out.println("Error in opening the file!");
        }
    }

    public void setRandomName() throws java.io.IOException {
        Scanner scanner = new Scanner(new FileReader("C:\\Users\\VenerealDelight\\Documents\\NetBeansProjects\\Battleship\\src\\Fantasy.txt"));
        scanner.useDelimiter("[\n]");
        int line = random.nextInt(2056) + 1;
        int count = 1;
        String randomName = "Moses";
        while (count <= line) {
            randomName = scanner.next();
            count++;
        }
        scanner.close();
        randomName.trim();
        name = randomName;
    }

    @Override
    //check and see if the player's health is 0 and the number of ships is 0
    public boolean checkIfPlayerLost() {
        if (getHealth() == 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void addToPlayerHistory() {
        Node history = new Node(rowCoordinate, colCoordinate, hitOrMiss);
        playerHistory.addLast(history);
    }

    @Override
    public void attack() {
        System.out.println("Player 1 : " + board.getHealth());
        System.out.println("Player 2 : " + enemyBoard.getHealth());
        setCoordinates();
        JTextArea display = new JTextArea(dummyBoard.printBoard(), 22, 33);
        display.setEditable(false);
        display.setTabSize(3);
        JOptionPane.showMessageDialog(null, display, getName() + "'s Attack Board", JOptionPane.INFORMATION_MESSAGE);

        setCoordinates();
        if (enemyBoard.checkIfEmpty(rowCoordinate, colCoordinate)) {
            hitOrMiss = false;
            dummyBoard.getBoard()[rowCoordinate][colCoordinate] = 88;
            enemyBoard.getBoard()[rowCoordinate][colCoordinate] = 88;
            JOptionPane.showMessageDialog(null, "You missed! ;(","Failure", JOptionPane.ERROR_MESSAGE);
        } else if(enemyBoard.getBoard()[rowCoordinate][colCoordinate] == 88){
            JOptionPane.showMessageDialog(null, "You missed again! ;(","Failure", JOptionPane.ERROR_MESSAGE);
        } else if(enemyBoard.getBoard()[rowCoordinate][colCoordinate] == 96){
            JOptionPane.showMessageDialog(null, "You destroyed that part already!","Failure", JOptionPane.ERROR_MESSAGE);
        }
        else{
            hitOrMiss = true;
            enemyBoard.getBoard()[rowCoordinate][colCoordinate] = 96;
            dummyBoard.getBoard()[rowCoordinate][colCoordinate] = 96;
            enemyBoard.decrementHealth();
            JOptionPane.showMessageDialog(null, "You got a hit!", " Success!", JOptionPane.INFORMATION_MESSAGE);
        }
      
    }

    @Override
    public void setCoordinates() {
        if(!shipsSet){
            setToSizeCoordinates(shipSize);
        }
        else
            rowCoordinate = random.nextInt(board.ROWS);
            colCoordinate = random.nextInt(board.COLUMNS);
    }
    
    public void setToSizeCoordinates(int shipSize){
        if(shipSize == 1){
            rowCoordinate = random.nextInt(board.ROWS);
            colCoordinate = random.nextInt(board.COLUMNS -1);
        }
        else if(shipSize ==3){
            rowCoordinate = random.nextInt(board.ROWS);
            colCoordinate = random.nextInt(board.COLUMNS - 4);
        }
        else if( shipSize == 5){
            rowCoordinate = 0;
            colCoordinate = 9;
        }
    }

    //gets the coordinates for the ship placements
     public void getShipPlacements() {
        int shipsPlaced = 0;
        int cruiser = board.getCruiser();
        String orientation = "v";
        shipSize = 1;
        setCoordinates();

        System.out.println("Entering cruiser setup:\n" + cruiser + " Cruisers Available");
        for(int count = 0; count < cruiser; count++){
            shipSize = 1;
            setCoordinates();
            board.placeShip(rowCoordinate, colCoordinate, shipSize, orientation);
            board.decrementCruiser();
            shipsPlaced++;
        }

        System.out.println("Entering patrol setup:\n" + board.getPatrol() + " Patrols Available");
        while(board.getPatrol() != 0){
            shipSize = 3;
            setCoordinates();
            orientation = "h";
            if (board.checkValidPlacement(rowCoordinate, colCoordinate, shipSize, orientation)) {
                board.placeShip(rowCoordinate, colCoordinate, shipSize, orientation);
                board.decrementPatrol();
                shipsPlaced++;
            }
        }

        System.out.println("Entering destroyer setup:\n" + board.getDestroyer() + " Destroyers Available");
        while(board.getDestroyer() != 0){
            shipSize = 5;
            setCoordinates();
            orientation = "v";
            if (board.checkValidPlacement(rowCoordinate, colCoordinate, shipSize, orientation)) {
                board.decrementDestroyer();
                shipsPlaced++;
            }
        }
        System.out.println(getName() + ": Ships have been set.\n\n");
        shipsSet = true;
    }

    @Override
    public void Play() {
        attack();
        addToPlayerHistory();
    }

    @Override
    public void printHistory() {
        playerHistory.printList();
    }

    @Override
    public LinkedList getHistory() {
        return playerHistory;
    }
}
