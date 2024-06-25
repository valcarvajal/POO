package tec.poo.battleship;

import com.google.gson.*;

import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class JsonSaver {

    public void saveObj(BattleshipGame toBeSaved) {
        //Objeto que hara la conversion
        Gson gsonToSave = new Gson();
        String jsonString = gsonToSave.toJson(toBeSaved);

        System.out.println(jsonString);

        try (PrintWriter pw = new PrintWriter(new File("savedata.json"))){
            //Guardarlo en un archivo
            
            pw.write(jsonString);
            //pw.flush();// con el close en teoria se hace solo
            // y se cierra con el try
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(JsonSaver.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public BattleshipGame loadBoard() {
        String json = "";
        try {
            BufferedReader br = new BufferedReader (new FileReader("saveData.json"));
            String linea;
            try {
                while ((linea = br.readLine()) != null){
                    json+= linea;
                    
                }
            } catch (IOException ex) {
                Logger.getLogger(JsonSaver.class.getName()).log(Level.SEVERE, null, ex);
            }
            
                    
        } catch (FileNotFoundException ex) {
            Logger.getLogger(JsonSaver.class.getName()).log(Level.SEVERE, null, ex);
        }
        Gson gson = new Gson();
        BattleshipGame loadBoard = gson.fromJson(json,BattleshipGame.class);
        return loadBoard;
    }
}
