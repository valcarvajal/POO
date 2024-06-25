package tec.poo.proyectos.simpletron;

public class Instruction {

    //-----------> Methods <-----------

    /*
     * operandToInstruction():
     * Receives the a int named operand (-999 < operand < 999),
     * transform the operand in String and give the the correct
     * format +000<operand> or -000<operand> that is necessary to
     * be saved in memory.
     */
    public static String operandToInstruction(int operand) {
        String sign = "+";
        if(operand<0){
            sign = "-";
            operand *= -1;
        }
        String instruction = operand+"";
        while(instruction.length() < 3){
            instruction = "0"+instruction;
        }
        instruction = sign+"00"+instruction;
        return instruction;
    }

    /*
     * instructionToOperand():
     * Receives the a String named instruction, corresponding to
     * one of the instructions allocated in the Simpletron memory,
     * takes the last tree digits of the instruction, that corresponds
     * to the operand of the instruction, and returns the operand as int.
     * The returned operand could be positive o negative, depending of
     * the sign at the start of the instruction, and always have 3
     * or less digits.
     */
    public static int instructionToOperand(String instruction) {
        int operand = Integer.valueOf((instruction).substring(3, 6));
        if( ((instruction).substring(0,1)).equals("-")){
            return -1*operand;
        }
        return operand;
    }

    /*
     * instructionToOperationCode():
     * Receives the a String named instruction, corresponding to
     * one of the instructions allocated in the Simpletron memory,
     * takes the first two digits of the instruction after the sign,
     * that corresponds to the operationCode of the instruction,
     * and returns the operationCode as int. The returned operationCode
     * is always a positive number of two digits.
     */
    public static int instructionToOperationCode(String instruction) {
        int opetationCode = Integer.valueOf((instruction).substring(1, 3));
        return opetationCode;
    }

    /*
     * instructionToSign():
     * Receives the a String named instruction, corresponding to
     * one of the instructions allocated in the Simpletron memory,
     * takes the first character that correspond to the sign of
     * the instruction and returns a boolean True if the sign is
     * plus, or False if the sign is minus.
     */
    public static boolean instructionToSign(String instruction) {
        if( (instruction).substring(0, 1) == "-"){
            return false;
        }
        return true;
    }

}
