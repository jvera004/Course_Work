package Player;

import Game_Mechanics.*;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Human extends Player {

    private String name;
    private int shipsPlaced = 0;
    private int rowCoordinate = 0;
    private int colCoordinate = 0;
    private boolean hitOrMiss = false;
    private Board board = new Board();
    private Board enemyBoard = new Board();
    private Board dummyBoard = new Board();
    private LinkedList playerHistory = new LinkedList();

    public Human() {
        setName();
        getShipPlacements();
    }

    public int getColCoordinate() {
        return colCoordinate;
    }

    public int getRowCoordinate() {
        return rowCoordinate;
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
        while (name == null || name.equals(" ")) {
            name = JOptionPane.showInputDialog(null, "Enter your name:", "Player", JOptionPane.QUESTION_MESSAGE);
        }
    }

    @Override
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
            JOptionPane.showMessageDialog(null, "You got a hit!");
        }
    }

    @Override
    public void setCoordinates() {
        String tmpRow = "";
        String tmpCol = "";
        boolean goodChoice = false;
        tmpRow = JOptionPane.showInputDialog(null, "Enter a Row coordinate:", "Y-Coord", JOptionPane.INFORMATION_MESSAGE);
        tmpCol = JOptionPane.showInputDialog(null, "Enter a Column coordinate:", "X-Coord", JOptionPane.INFORMATION_MESSAGE);

        //if it is not valid input, keep asking user for coordinates
        while (!goodChoice) {
            if (tmpRow.matches("[0-9]") && tmpCol.matches("[0-9]")) {
                //when it is good, parse it into an int
                goodChoice = true;
                rowCoordinate = Integer.parseInt(tmpRow);
                colCoordinate = Integer.parseInt(tmpCol);
            } else {
                tmpRow = JOptionPane.showInputDialog(null, "Enter a Row coordinate:", "Y-Coord", JOptionPane.INFORMATION_MESSAGE);
                tmpCol = JOptionPane.showInputDialog(null, "Enter a Column coordinate:", "X-Coord", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        //if it is out of bounds, ask the user again for good coordinates
        if (getRowCoordinate() > board.ROWS && getRowCoordinate() < 0 && getColCoordinate() > board.COLUMNS && getColCoordinate() < 0) {
            setCoordinates();
        }
    }

    public String getOrientation() {
        boolean goodChoice = false;
        //get the ship's orientation to be placed on the map
        String orientation = JOptionPane.showInputDialog("Please enter the ship's orientation:\nH for Horizontal\nV for Vertical");
        while (!goodChoice) {
            if (orientation.equalsIgnoreCase("h")) {
                goodChoice = true;
            } else if (orientation.equalsIgnoreCase("v")) {
                goodChoice = true;
            } else if (!goodChoice) {
                JOptionPane.showMessageDialog(null, "Invalid orientation!", "Tsk-tsk...", JOptionPane.ERROR_MESSAGE);
                orientation =
                        JOptionPane.showInputDialog("Please enter the ship's orientation:\nH for Horizontal\nV for Vertical");
            }
        }
        return orientation;
    }

    public String getShipChoice() {
        String shipChoice = "";
        boolean goodChoice = false;
        shipChoice = JOptionPane.showInputDialog(null,
                "Please enter a type of ship:\n1)Cruiser\n2)Patrol\n3)Destroyer\n\n\n\n\tShips Available\n\t"
                + board.getCruiser() + " Cruiser\n\t" + board.getPatrol() + " Patrol\n\t"
                + board.getDestroyer() + " Destroyer", "Choose Your Ship:", JOptionPane.INFORMATION_MESSAGE);

        //ship choice validation
        while (!goodChoice) {
            if (shipChoice.equals("1")) 
                goodChoice = true;
            else if (shipChoice.equals("2")) 
                goodChoice = true;
            else if (shipChoice.equals("3")) 
                goodChoice = true;
            else if (goodChoice == false) 
                //choice was bad, ask for a choice again
                shipChoice = getShipChoice();
        }
        goodChoice = false;
        while(!goodChoice){
            if (shipChoice.equals("1")) {
                if (board.getCruiser() == 0) {
                    JOptionPane.showMessageDialog(null, "No cruiser ships available!", "Invalid Choice",
                            JOptionPane.ERROR_MESSAGE);
                    shipChoice = getShipChoice();
                }else
                    goodChoice = true;
            }
            else if (shipChoice.equals("2")) {
                if (board.getPatrol() == 0) {
                    JOptionPane.showMessageDialog(null, "No patrol ships available!", "Invalid Choice",
                            JOptionPane.ERROR_MESSAGE);
                    shipChoice = getShipChoice();
                }else
                    goodChoice = true;
            }
            else if (shipChoice.equals("3")) {
                if (board.getDestroyer() == 0) {
                    JOptionPane.showMessageDialog(null, "No destroyer ships available!", "Invalid Choice",
                            JOptionPane.ERROR_MESSAGE);
                    shipChoice = getShipChoice();
                }else
                    goodChoice = true;
            } 
        }
        return shipChoice;
    }

    //sets the ship size to place the number on the board
    public int getShipSize(String shipChoice) {
        int shipSize = 0;
        if (shipChoice.equals("1")) {
            shipSize = 1;
        } else if (shipChoice.equals("2")) {
            shipSize = 3;
        } else if (shipChoice.equals("3")) {
            shipSize = 5;
        }
        return shipSize;
    }

    //gets the coordinates for the ship placements
    public void getShipPlacements() {
        JTextArea display = new JTextArea(board.printBoard(), 22, 33);
        display.setEditable(false);
        display.setTabSize(3);
        JOptionPane.showMessageDialog(null, display, getName() + "'s Board", JOptionPane.INFORMATION_MESSAGE);
        while (shipsPlaced < board.getNumberOfShips()) {
            String shipChoice = getShipChoice();
            int shipSize = getShipSize(shipChoice);
            String orientation = getOrientation();
            setCoordinates();
            //if the placement is valid, place the ship and increment the counter
            if (board.checkValidPlacement(rowCoordinate, colCoordinate, shipSize, orientation)) {
                board.placeShip(rowCoordinate, colCoordinate, shipSize, orientation);
                shipsPlaced++;
                if (shipSize == 1) {
                    if (board.getCruiser() > 0) {
                        board.decrementCruiser();
                    }
                } else if (shipSize == 3) {
                    if (board.getPatrol() > 0) {
                        board.decrementPatrol();
                    }
                } else if (shipSize == 5) {
                    if (board.getDestroyer() > 0) {
                        board.decrementDestroyer();
                    }
                }
                //show the board so the player can see his ships
                display = new JTextArea(board.printBoard(), 22, 33);
                display.setEditable(false);
                display.setTabSize(3);
                JOptionPane.showMessageDialog(null, display, getName() + "'s Board",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                getShipPlacements();
            }
        }
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