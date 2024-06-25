    package tec.poo.proyectos.simpletron;

import java.util.*;
import java.util.stream.Collectors;

public class Memory {

    // -----------> Instance variables <-----------

    private String[] memorylist;
    

    // -----------> Constructors <-----------

    public Memory() {
        memorylist = new String[1000];
        Arrays.fill(memorylist,"+00000");
    }

    // -----------> Methods <-----------

    /* 
     * getMemory(): Get an instruction from the memory position 
     * indicated by the entry int pos.
     */
    public String getMemory(int pos){
        return memorylist[pos];
    }

    /* 
     * getMemorySign(): Get the sign of an instruction from the memory position 
     * indicated by the entry int pos.
     */
    public boolean getMemorySign(int pos){
        String instruction = memorylist[pos];
        boolean sign = Instruction.instructionToSign(instruction);
        return sign;
    }

    /* 
     * getMemoryInstruction(): Get an operationCode from the memory position 
     * indicated by the entry int pos.
     */
    public int getMemoryOperationCode(int pos){
        String instruction = memorylist[pos];
        int operationCode = Instruction.instructionToOperationCode(instruction);
        return operationCode;
    }

    /* 
     * getMemoryRegister(): Get an operand from the memory position 
     * indicated by the entry int pos.
     */
    public int getMemoryOperand(int pos){
        String instruction = memorylist[pos];
        int operand = Instruction.instructionToOperand(instruction);
        return operand;
    }

    /* 
     * setMemory(): Set an operand number in the memory position 
     * indicated by the entry int pos. 
     */
    public void setMemory(int pos, int operand){
        String instruction = Instruction.operandToInstruction(operand);
        memorylist[pos] = instruction;
    }

    /* 
     * setMemoryInstruction(): Set an instruction in the memory position 
     * indicated by the entry int pos. 
     */
    public void setMemoryInstruction(int pos, String instruction){
        memorylist[pos] = instruction;
    }

    /* 
     * memoryDump(): Print in descendent order all that is storage in the memory
     * at the moment the method is called. Used for testing the program during
     * the develop stage.
     */
    public List<String> memoryDump() {
        return Arrays.asList(this.memorylist)
        .stream()
        .filter(i -> !i.equals("+00000"))
        .collect(Collectors.toList());
    }
}
