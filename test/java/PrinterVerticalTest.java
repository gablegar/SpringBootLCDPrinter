import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class PrinterVerticalTest {

    static String TEXT_FOR_ZERO_SIZE_ONE = " - \n| |\n   \n| |\n - \n";
    static String TEXT_FOR_TWO_SIZE_ONE = " - \n  |\n - \n|  \n - \n";
    static String TEXT_FOR_THREE_SIZE_ONE = " - \n  |\n - \n  |\n - \n";

    PrinterVertical printer = new PrinterVertical();
    @Test
    public void shouldGetErrorTextwhenInstructionsNotInFormat(){
        String expected = "Please enter the instructions in the specified format";
        String actual = printer.printLCDNumbers("11");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetTextForOneNumber(){
        String expected = "   \n  |\n   \n  |\n   \n";
        String actual = printer.printLCDNumbers("1,1");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetTextForNumberOneSizeTwo(){
        String expected = "    \n   |\n   |\n    \n   |\n   |\n    \n";
        String actual = printer.printLCDNumbers("2,1");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetTextForNumberTWO(){
        String expected = TEXT_FOR_TWO_SIZE_ONE;
        String actual = printer.printLCDNumbers("1,2");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetTextForNumberThreeSizeTwo(){
        String expected = " -- \n   |\n   |\n -- \n   |\n   |\n -- \n";
        String actual = printer.printLCDNumbers("2,3");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetTextForNumberTwoAndThreeSizeOne(){
        String expected = TEXT_FOR_TWO_SIZE_ONE + TEXT_FOR_THREE_SIZE_ONE;
        String actual = printer.printLCDNumbers("1,23");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetTextForOneNumberHorizontal(){
        String expected = TEXT_FOR_ZERO_SIZE_ONE;
        String actual = printer.printLCDNumbers("1,0");
        assertEquals(expected, actual);
    }

}
