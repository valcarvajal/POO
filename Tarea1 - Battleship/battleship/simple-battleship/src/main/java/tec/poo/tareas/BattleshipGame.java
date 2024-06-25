package tec.poo.tareas;

import java.util.Scanner;

import static tec.poo.tareas.Battleship.*;

public class BattleshipGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numOfHits_Ship1 = 0;
        int numOfHits_Ship2 = 0;
        int numOfHits_Ship3 = 0;
        int numOfShipsDown = 0;
        int count = 0;

        System.out.println("Write only capital letters please. Let's start! \n");

        while (numOfShipsDown != 3) {
            while (numOfHits_Ship1 != 3 || numOfHits_Ship2 != 3 || numOfHits_Ship3 != 3) {
                System.out.println("Enter a guess: ");
                count++;
                String guess = sc.next();

                if (estaEnShip(guess)) {
                    System.out.println("hit");
                    ship = eliminarElemento(guess);
                    if (estaEnShip1(guess)) {
                        numOfHits_Ship1++;
                        if (numOfHits_Ship1 == 3) {
                            System.out.println("You sunk ship-1 \n");
                            numOfShipsDown++;
                        }
                    } else if (estaEnShip2(guess)) {
                        numOfHits_Ship2++;
                        if (numOfHits_Ship2 == 3) {
                            System.out.println("You sunk ship-2 \n");
                            numOfShipsDown++;
                        }
                    } else if (estaEnShip3(guess)) {
                        numOfHits_Ship3++;
                        if (numOfHits_Ship3 == 3) {
                            System.out.println("You sunk ship-3 \n");
                            numOfShipsDown++;
                        }
                    }

                } else {
                    System.out.println("miss");
                }
            }
        }
        System.out.println("All startups are dead!");
        System.out.println("You took " + count + " guesses");
    }
}
