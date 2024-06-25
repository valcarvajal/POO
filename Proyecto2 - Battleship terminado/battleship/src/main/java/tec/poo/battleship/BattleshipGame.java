package tec.poo.battleship;

import java.io.IOException;

public class BattleshipGame {
    	public static void main(String[] args) {
		
		BattleshipRun playGame = new BattleshipRun();
		playGame.startGame();
	}

        public void startUI() throws IOException {
            Runtime.getRuntime().exec("java -jar battleship.jar");
        }
}