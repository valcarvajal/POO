/*
 * @author Valery Carvajal
 * Carné: 2022314299
 */

package tec.poo.battleship;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Battleship {
	
	private int hits;
	private int misses;

	private ArrayList<Integer> shipLengthArray = new ArrayList<Integer>();
	private ArrayList<Integer> shipCharArray = new ArrayList<Integer>();

	private int boardSize = 7;
	private int[][] gameBoard = new int[7][7];

	private int shotsFired = 0;

	// ships
	private int Aircraft = 3;
	private int Battleship = 4;
	private int Destroyer = 3;
	private int Submarine = 2;
	private int Patrol = 2;

	Random rand = new Random();
	
	Scanner input = new Scanner(System.in);
	
	// initializing the whole board to empty (0)
	public void fillBoard() {
		for(int i = 0; i < boardSize; i++) {
			for (int j = 0; j < boardSize; j++) {
				gameBoard[i][j] = 0;
			}
		}
	}

	
	// method to print board
	public void outputGame() { 
		char water = '~';
		char miss = '*';
		char hit = 'X';
		
		System.out.print("   ");

		// print letters on top of board
		for (int i = 0; i < gameBoard[0].length; i++) {
			System.out.printf("%3d", i+1);
		} System.out.println();
		
		// goes through gameBoard's rows
		for (int row = 0; row < gameBoard[0].length; row++) {	
			System.out.printf("%3c", getLetter(row+1));
			
			// goes through the columns of current row
			for (int column = 0; column < gameBoard[0].length; column++) {
					if (gameBoard[row][column] == 0)
						System.out.printf("%3c", water);
					if (gameBoard[row][column] == 1)
						System.out.printf("%3c", miss);
					if (gameBoard[row][column] == 2)
						System.out.printf("%3c", hit);
						if (gameBoard[row][column] == 'A' || gameBoard[row][column] == 'B' || gameBoard[row][column] == 'D' || gameBoard[row][column] == 'S' || gameBoard[row][column] == 'P')
						System.out.printf("%3c", water);
			} System.out.println();
		}
	}
	
	// method to check if it is a hit
	boolean checkHit() {
		for (int row = 0; row < gameBoard[0].length; row++) {
			for (int column = 0; column < gameBoard[0].length; column++) {
				if (gameBoard[row][column] == 2) {
					if (gameBoard[row][column] == 'A' || gameBoard[row][column] == 'B' || gameBoard[row][column] == 'D' || gameBoard[row][column] == 'S' || gameBoard[row][column] == 'P') {
						return true;
					}
				}
			}
		} return false;
	}

	// method to track hits
	public void endGame() {		
		while (hits != 17) {
			shotsFired++;
			
			System.out.println("Choose the row you want to attack. (Enter a valid LETTER): ");
			String guess = input.next();
			
			// make sure the input is upper case
			guess = guess.toUpperCase();
			
			char charInput = guess.charAt(0); 
			int a = getNumber(charInput);
			
			// make sure a is within boardSize coordinates
			if (a < 1 || a > boardSize){
				System.out.println("You did not enter a valid guess.");
				continue;
			}
			
			// make sure a prints in correct spot
			a = getNumber(charInput) - 1;
			
			System.out.println("Choose the column you want to attack (Enter a valid NUMBER): ");
			
			// make sure b places in correct spot
			int b = input.nextInt() - 1;
			if (b > boardSize || b < 0) {
				System.out.println("You did not enter a valid coordinate.");
				continue;
			}
			
			// which ship sunk
			if (gameBoard[a][b] == 'A') {
				Aircraft--;
				if (Aircraft == 0){
					System.out.println("\n" + "You sunk the Aircraft Carrier!");
				}
			} else if (gameBoard[a][b] == 'B') {
				Battleship--;
				if (Battleship == 0){
					System.out.println("\n" + "You sunk the Battleship!");
				}
			} else if (gameBoard[a][b] == 'D') {
				System.out.println(Destroyer);
				Destroyer--;
				System.out.println(Destroyer);
				if (Destroyer == 0){
					System.out.println("\n" + "You sunk the Destroyer!");
				}
			} else if (gameBoard[a][b] == 'S') {
				Submarine--;
				if (Submarine == 0){
					System.out.println("\n" + "You sunk the Submarine!");
				}
			} else if (gameBoard[a][b] == 'P') {
				Patrol--;
				if (Patrol == 0){
					System.out.println("\n" + "You sunk the Patrol Boat!");
				}
			}
			
			for (int j = 0; j < shipLengthArray.size(); j++) {
			// checks if it was a hit or miss
			for (int i = 0; i < shipLengthArray.get(j); i++) {
				if (gameBoard[a][b] == getLetter(shipCharArray.get(j))) {
					// convert hit to X when printing next board
					gameBoard[a][b] = 2;
				}
			}
		}
			
			
			// check if the space is empty
			if (gameBoard[a][b] == 0) {

				// convert miss to * on next board
				gameBoard[a][b] = 1;
				System.out.println("MISS");
				misses++;
			} else if (gameBoard[a][b] == 2) {				
				System.out.println("HIT");
				hits++;
			} System.out.println("HITS: " + hits);
			System.out.println("MISSES: " + misses);
			outputGame();
		}
	}

	// method to check win (checks if all ships are dead)
	boolean validateWin() {
		if (hits == 17) {
			System.out.println("CONGRATULATIONS! YOU WON!");
			System.out.println("--------STATS--------");
		}
		System.out.println("All startups are dead!");
        System.out.println("You took " + shotsFired + " guesses");
	 	return true;}
	
		
	// conversion method to change letters to numbers for int[][] board
	public int getNumber(char input) {
		int row = 1;
		
		switch(input){
		case 'A':
			row = 1;
			break;
		case 'B':
			row = 2;
			break;
		case 'C':
			row = 3;
			break;
		case 'D':
			row = 4;
			break;
		case 'E':
			row = 5;
			break;
		case 'F':
			row = 6;
			break;
		case 'G':
			row = 7;
			break;		
		}
		
		
		return row;
}

	
	// converts int to char for column
	public char getLetter(int i){
		  return (char) (i + 64);
		}

	
	public enum Ships {
		// these values are according to our getLetter method to convert to ascii values
		AIRCRAFT (3, 1, "Aircraft Carrier"),
		BATTLESHIP (4, 2, "Battleship"),
		DESTROYER (3, 4, "Destroyer"),
		SUBMARINE (2, 19, "Submarine"),
		PATROL (2, 16, "Patrol");
		
		final int shipSize;
		final int shipMarker;
		final String shipString;
		
		// enum constructor
		Ships(int shipSize, int shipMarker, String shipString) {
			this.shipSize = shipSize;
			this.shipMarker = shipMarker;
			this.shipString = shipString;
		}
		
		public int getShipLength() {
			return shipSize;
		}
		
		public int getShipMarker() {
			return shipMarker;
		}
		
		public String getShipString() {
			return shipString;
		}
	}
	
	// add ships from enum ship class to array list and allows access in ship positioning method
	public void createShipArray() {
		// stores each ship length from enum
		shipLengthArray.add(Ships.AIRCRAFT.getShipLength()); 
		shipLengthArray.add(Ships.BATTLESHIP.getShipLength()); 
		shipLengthArray.add(Ships.DESTROYER.getShipLength()); 
		shipLengthArray.add(Ships.SUBMARINE.getShipLength()); 
		shipLengthArray.add(Ships.PATROL.getShipLength()); 
		
		// stores each ship marker from enum
		shipCharArray.add(Ships.AIRCRAFT.getShipMarker());
		shipCharArray.add(Ships.BATTLESHIP.getShipMarker());
		shipCharArray.add(Ships.DESTROYER.getShipMarker());
		shipCharArray.add(Ships.SUBMARINE.getShipMarker());
		shipCharArray.add(Ships.PATROL.getShipMarker());
	
	}
	
	// method to place ships
	public void positionShips() {
			
			// loops through arrayLists that hold enum values for shipSize and shipMarker
			for (int j = 0; j < shipLengthArray.size();j++) {
				boolean shipsOnBoard = false;

			start:
			while (!shipsOnBoard) {
				boolean horizontal = rand.nextBoolean();
				
				// generate random numbers for ship placement (row and column)
				int col = rand.nextInt(boardSize);
				int row = rand.nextInt(boardSize);
				
				// ensure row and column are not taken up 
				if (gameBoard[row][col] > 0) {
					continue;
				}
				
				// if boolean horizontal is true
				if (horizontal) {
					for (int i = 0; i < shipLengthArray.get(j); i++) {
						// ensure entire space is free for ship
						if (gameBoard[row][i+1] != 0) {
							continue start;
						} else {
						gameBoard[row][i+1] = getLetter(shipCharArray.get(j));
						}
					}
				
				// if boolean horizontal is false
				} else { //vertically
					for (int i = 0; i < shipLengthArray.get(j); i++) {
						if (gameBoard[i+1][col] != 0) {
							continue start;
						} else {
						gameBoard[i+1][col] = getLetter(shipCharArray.get(j));
						}
					}
				} shipsOnBoard = true;
			}		
		}	
	 }
}

