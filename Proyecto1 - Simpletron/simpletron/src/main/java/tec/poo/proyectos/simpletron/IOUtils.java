package tec.poo.proyectos.simpletron;
public class IOUtils {

    /* 
     * readInput(): Make all the necessary verifications of an input "instruction"
     * and return the corresponding error notifications.
     */    
    public static String readInput(String input) {
        
        if(null == input) {         
            System.out.println("Simple> Error: El código de operación no es válido. ");   
            return "e";
        }

        if(input.length() != 6) {
            System.out.println("Simple> Error: El código de operación no es válido. ");   
            return "e";
        }

        if(!input.substring(0,1).equals("+") && !input.substring(0,1).equals("-")) {
            System.out.println("Simple> Error: El código de operación no es válido. ");   
            return "e";
        }

        if(input.substring(0,1).equals("-")) {
            if((!input.substring(1,3).equals("00") && !input.substring(1,6).equals("99999")))
            {
                System.out.println("Simple> Error: El código de operación no es válido. ");   
                return "e";
            }
        }

        return input;
    }
    
    /* 
     * readOperand(): Make all the necessary verifications of an int input "operand"
     * and return the corresponding error notifications.
     */        
    public static int readOperand(int input) {

        if(input > 999 || input < -999) {         
            System.out.println("Simple> Error: Desbordamiento de memoria. "); 
            input = 1000;
        }
        return input;
        
    }
}
