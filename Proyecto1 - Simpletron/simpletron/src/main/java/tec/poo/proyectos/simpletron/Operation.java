package tec.poo.proyectos.simpletron;

import java.util.Scanner;
public class Operation {
    
    // -----------> Instance variables <-----------

    private boolean exc;
    private int pos = 0;
    private int accumulator;
    private int cycleController = 0;

    // -----------> Methods <-----------

    /*
     * executeOperation(): Receives an type Memory object "memoria" 
     * and execute all the operations on the memory. 
     */
    public void executeOperation(Memory memoria) {

        Scanner inputScanner = new Scanner(System.in);

        exc = true;

        while(exc){
            String data = memoria.getMemory(pos);
            int codigoOperacion = memoria.getMemoryOperationCode(pos);
            int operando = memoria.getMemoryOperand(pos);
            if(accumulator > 999){
                System.out.println("Simple> Error: Desbordamiento del acumulador.");
                System.out.println("Simple> Ha ocurrido un error de desbordamiento de acumulador durante la ejecución de su programa simple.");
                System.out.println("Simple> Cerrando Simpletron... ");
                System.exit(-1);
            }

            if(data.equals("-99999")){
                exc = false;
            }

            else{
                switch(codigoOperacion){

                    
                    /* 
                     * Not a operation (+00<operand>): The 0 as operation code indicates
                     * that this is not a operation, is only a number allocated in the
                     * memory.
                     */
                    case 0:
                    break;

                    /* 
                     * Operation Read (+10<operand>): Reads a number from the keyboard entry,
                     * the number must have a max of 3 digits, and it will be stored in the
                     * memory direction indicated by the operand.
                     */
                    case 10:
                    boolean catchNumber = true; 

                    while(catchNumber){
                        System.out.print("Simple> Ingrese un numero: ");
                        int number = 0;

                        try {
                            number = Integer.parseInt(inputScanner.next());
                        } 
                        catch (Exception e) {
                            System.out.println("Simple> Error: Entrada invalida. ");
                            continue;
                        }

                        int operand = IOUtils.readOperand(number);

                        if(operand != 1000){
                            memoria.setMemory(operando, number);
                            catchNumber = false;
                        }
                        else{
                            continue;
                        }

                    }                   
                    break;

                    /* 
                     * Operation Write (+11<operand>): Prints in the terminal the number
                     * allocated in the memory space indicated by the operand.
                     */
                    case 11:
                        accumulator = (memoria.getMemoryOperand(operando));
                        System.out.print("Simple> ");
                        System.out.println(accumulator);
                    break;

                    /* 
                     * Operation Load (+20<operand>): Load in the accumulator a number from
                     * the memory direction indicated by the operand.
                     */
                    case 20:
                        accumulator = (memoria.getMemoryOperand(operando));
                    break;

                    /*
                     * Operation Storage (+21<operand>): Save in the memory direction
                     * indicated by the operand, the number loaded in the accumulator.
                     */
                    case 21:
                        memoria.setMemory(operando, accumulator);
                    break;

                    /*
                     * Operation Addition (+30<operand>): Add to the accumulator the value 
                     * allocated in the memory direction indicated by the operand.
                     */
                    case 30:
                    accumulator += (memoria.getMemoryOperand(operando));
                    break;

                    /*
                     * Operation Subtraction (+31<operand>): Subtract to the accumulator 
                     * the value allocated in the memory direction indicated by the operand.
                     */
                    case 31:
                    accumulator -= (memoria.getMemoryOperand(operando));
                    break;

                    /*
                     * Operation Multiplication (+32<operand>): Multiply the accumulator by
                     * the value allocated in the memory direction indicated by the operand. 
                     */
                    case 32:
                    accumulator *= (memoria.getMemoryOperand(operando));
                    break;

                    /*
                     * Operation Division (+33<operand>): Divide the accumulator by
                     * the value allocated in the memory direction indicated by the operand.  
                     */
                    case 33:
                    if(memoria.getMemoryOperand(operando) == 0){
                        System.out.println("Simple> Error: Division by zero. ");
                        System.exit(-1);
                    }else{
                        accumulator /= memoria.getMemoryOperand(operando);
                        break;
                    }

                    /*
                     * Operation Module (+34<operand>): Calculates accumulator module
                     * the number saved in the memory direction indicated by the operand.
                     */
                    case 34:
                    accumulator %= memoria.getMemoryOperand(operando);
                    break;

                    /*
                     * Operation Exponentiation (+35<operand>): Elevates the number loaded in
                     * the accumulator to the number of operands specified in the operand.
                     */
                    case 35:
                    Math.pow(accumulator, memoria.getMemoryOperand(operando));
                    break;

                    /*
                     * Operation Branch (+40<operand>): Jump to a memory space
                     * indicated by the operand. 
                     */
                    case 40:
                    pos = operando-1;
                    break;

                    /*
                     * Operation Branch if negative (+41<operand>):  Jump to a memory space
                     * indicated by the operand, if the number loaded in the accumulator is
                     * negative. 
                     */
                    case 41:
                    if(accumulator < 0){
                        pos = operando-1;
                    }
                    break;

                    /*
                     * Operation Branch if cero (+42<operand>):  Jump to a memory space
                     * indicated by the operand, if the number loaded in the accumulator is
                     * cero. 
                     */
                    case 42:
                    if(accumulator == 0){
                        pos = operando-1;
                    }
                    break;

                    /*
                     * Operation Branch if positive (+43<operand>): Jump to a memory space
                     * indicated by the operand, if the number loaded in the accumulator is
                     * positive.
                     */
                    case 43:
                    if(accumulator > 0){
                        pos = operando-1;
                    }
                    break;

                    /*
                     * Operation Stop (+44<operand>): Ends the execution of the program. 
                     */
                    case 44:
                    exc = false;
                    break;

                    /*
                     * Operation Clean accumulator (+45<operand>): Set the accumulator
                     * value to 0. 
                     */
                    case 45:
                    accumulator = 0;
                    break;

                    /*
                     * Operation Branch in cycle (+50<operand>): Jump to a memory space
                     * indicated by the operand, and could be used to create a cycle, after
                     * start the cycle controller.
                     */
                    case 50:
                    if(cycleController > 0){
                        cycleController -= 1;
                        pos = operando-1;
                    }
                    break;


                    /*
                     * Operation Start cycle controller (+51<operand>): Set the 
                     * cycleController to the number indicated by the operand.
                     */
                    case 51:
                    if (cycleController != 0){
                        System.out.println("Simple> Redefinición de un ciclo previamente inicializado, asegurate de vaciar en controlador de ciclos antes de inicializar otro. ");
                    }
                    else{
                        cycleController = operando;
                    }
                    break;

                    /*
                     * In case that the entry of the switch is not a valid instruction,
                     * launch this error and continue taking entries from the user.
                     */
                    default:
                    System.out.println("Simple> Error: El código de operación no es válido. ");
                    break;

                }

                pos ++;

            }
        }

        inputScanner.close();

    }
}