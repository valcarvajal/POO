package tec.poo.tareas;

import org.apache.commons.lang3.ArrayUtils;
import java.util.Arrays;

public class Battleship {

    public static String[][] matriz = {{"A0", "A1", "A2", "A3", "A4", "A5", "A6"},{"B0", "B1", "B2", "B3", "B4", "B5", "B6"},{"C0", "C1", "C2", "C3", "C4", "C5", "C6"},{"D0", "D1", "D2", "D3", "D4", "D5", "D6"},{"E0", "E1", "E2", "E3", "E4", "E5", "E6"},{"F0", "F1", "F2", "F3", "F4", "F5", "F6"},{"G0", "G1", "G2", "G3", "G4", "G5", "G6"}};

    public static String [] ship = {"B4", "B5", "B6", "C0", "D0", "E0", "E3", "E4", "E5"};
    public static String [] ship1 = {"C0", "D0", "E0"};
    public static String [] ship2 = {"B4", "B5", "B6"};
    public static String [] ship3 = {"E3", "E4", "E5"};

    public static boolean estaEnShip(String valor) {
        String stringToSearch = String.valueOf(valor);
        return (Arrays.asList(ship).contains(stringToSearch));
    }

    public static boolean estaEnShip1(String valor) {
        String stringToSearch = String.valueOf(valor);
        return (Arrays.asList(ship1).contains(stringToSearch));
    }

    public static boolean estaEnShip2(String valor) {
        String stringToSearch = String.valueOf(valor);
        return (Arrays.asList(ship2).contains(stringToSearch));
    }

    public static boolean estaEnShip3(String valor) {
        String stringToSearch = String.valueOf(valor);
        return (Arrays.asList(ship3).contains(stringToSearch));
    }

    public static boolean estaEnArray(String valor) {
        String stringToSearch = String.valueOf(valor);
        return (Arrays.asList(matriz).contains(stringToSearch));
    }

    public static String[] eliminarElemento(String valor) {
        String item = String.valueOf(valor);
        return ArrayUtils.removeElement(ship, item);
    }
}
