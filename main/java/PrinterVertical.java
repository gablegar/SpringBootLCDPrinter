import enums.NumberLCDPatternVertical;

public class PrinterVertical {

    private static String[] NUMBER_TO_STRING = {"ZERO", "ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE"};

    public String printLCDNumbers(String instruction){
        int size = Integer.valueOf(instruction.substring(0,1));
        String numbers = instruction.substring(2);
        String column = "";

        if(size > 0 && numbers.length() > 0) {
            return getTextForInstructions(size, numbers, column);
        } else {
            return "Please enter the instructions in the specified format";
        }
    }

    private String getTextForInstructions(int size, String numbers, String column) {
        String printText = "";
        for(char number : numbers.toCharArray()) {
            char[] numberPattern = NumberLCDPatternVertical.valueOf(String.valueOf(NUMBER_TO_STRING[Integer.valueOf(String.valueOf(number))])).getLcdPattern();
            int counter = 0;
            for (char field : numberPattern) {
                if ((counter >= 0 && counter <= 2) || (counter >= 6 && counter <= 8) || (counter >= 12 && counter <= 14)) {
                    if (counter == 1 || counter == 7 || counter == 13) {
                        for (int i = 0; i < size; i++) {
                            printText = printText + field;
                        }
                    } else {
                        printText = printText + field;
                    }
                    if (counter == 2 || counter == 8 || counter == 14) {
                        printText = printText + "\n";
                    }
                } else {
                    if (counter == 4 || counter == 10) {
                        for (int i = 0; i < size; i++) {
                            column = column + field;
                        }
                    } else {
                        column = column + field;
                    }
                    if (column.length() == 2 + size) {
                        for (int i = 0; i < size; i++) {
                            printText = printText + column + "\n";
                        }
                        column = "";
                    }
                }
                counter++;
            }
        }
        return printText;
    }
}
