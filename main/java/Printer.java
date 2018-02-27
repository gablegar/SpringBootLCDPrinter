import enums.NumberLCDPattern;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

/*
* This Exercise was built using spring-boot
* to test please launch mvn spring-boot:run
* */
public class Printer {

    private static int HORIZONTAL_PATTERN_SIZE = 5;
    private static String[] NUMBER_TO_STRING = {"ZERO", "ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE"};

    public static void main(String[] args){
        ConfigurableApplicationContext springContext = new SpringApplicationBuilder().sources(Printer.class).run(args);
        Printer printer = springContext.getBean(Printer.class);
        printer.start();
    }

    private void start(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Please enter instructions in format 6,9999 \n" +
                            "where first number is size and following numbers are the ones to print in LCD mode \n" +
                            "tape exit to finish the program\n");
        try {
            while(true){
                System.out.println("Enter new instruction");
                String instructions = br.readLine();
                if(instructions.toLowerCase().equals("exit")) {
                    break;
                }
                System.out.println(printLCDNumbers(instructions));
            }
        } catch(IOException exception){
            System.out.print("Error while reading instruction" + exception);
        }
    }

    public String printLCDNumbers(String instruction){
        int size = Integer.valueOf(instruction.substring(0,1));
        String numbers = instruction.substring(2);
        if(size > 0 && numbers.length() > 0) {
            return getTextFromInstructions(size, numbers);
        } else {
            return "Please enter the instructions in the specified format";
        }
    }

    private String getTextFromInstructions(int size, String numbers) {
        String[] linesToPrint = Arrays.stream(new String[2*size+3]).map(lineToPrint -> lineToPrint = new String()).toArray(String[]::new);

        for(char number : numbers.toCharArray()) {
            String[] numberPattern = NumberLCDPattern.valueOf(String.valueOf(NUMBER_TO_STRING[Integer.valueOf(String.valueOf(number))])).getLcdPattern();
            for (int i = 0, counter = 0 ; i < HORIZONTAL_PATTERN_SIZE; i++) {
                numberPattern[i] = (size == 1) ? numberPattern[i] : resizePatternLine(size, numberPattern[i]);
                int sizeOfNewLines = size;
                if(i % 2 == 0) sizeOfNewLines = 1;
                counter = getLineToPrint(linesToPrint, numberPattern[i], counter, sizeOfNewLines);
            }
        }
        return Arrays.stream(linesToPrint).map(line -> line + "\n").collect(Collectors.joining());
    }

    private int getLineToPrint(String[] linesToPrint, String numberPatternLine, int counter, int size) {
        for(int j = 0; j< size; j++) {
            linesToPrint[counter] = linesToPrint[counter] + numberPatternLine;
            counter++;
        }
        return counter;
    }

    private String resizePatternLine(int size, String line) {
        String resizedLine = line.substring(0,1);
        for(int i = 0; i < size; i++) {
            resizedLine = resizedLine + line.substring(1,2);
        }
        return resizedLine + line.substring(2,3);
    }
}