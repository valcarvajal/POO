package tec.poo.proyectos.simpletron;

import java.util.Scanner;

public class Simpletron {

    private Memory memory;
    private Operation operation;

    private int memoryPosition = 0;
    private String instruction = "";

    public Simpletron() {
        this.memory = new Memory();
        this.operation = new Operation();
    }

    
    /* 
     * main(): The principal method of the program, calls all the 
     * other classes and objects and execute the program Simpletron.
     */
    public static void main(String... args) {

        System.out.println("--- Simpletron --- ");

        Simpletron s = new Simpletron();
        Scanner instructionEntry = new Scanner(System.in);
        while(!s.instruction.equals("-99999")) { 

            String pp = ((s.memoryPosition + 1000)+"").substring(1); 
            System.out.print(pp + "> ");
            s.instruction = instructionEntry.next();
            s.instruction = IOUtils.readInput(s.instruction);

            if(!s.instruction.equals("e")){
                s.memory.setMemoryInstruction(s.memoryPosition, s.instruction);
                s.memoryPosition++;
            }

        }
        
        System.out.println("Carga completada, ejecutando ");
        System.out.println();
        s.operation.executeOperation(s.memory);

        //for(String i : s.memory.memoryDump()) {
        //    System.out.println("Inst " + i);
        //}
            
        instructionEntry.close();
        System.exit(0);
    }
}
