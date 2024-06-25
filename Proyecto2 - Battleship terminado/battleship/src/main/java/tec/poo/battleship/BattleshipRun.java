package tec.poo.battleship;

import java.util.Scanner;

public class BattleshipRun {
    Battleship gameboard1 = new Battleship();
	Scanner input = new Scanner(System.in);
	
	public void startGame(){
		
		gameboard1.createShipArray();
		gameboard1.fillBoard();
		gameboard1.positionShips();
		gameboard1.outputGame();
		gameboard1.endGame();
	}
}
