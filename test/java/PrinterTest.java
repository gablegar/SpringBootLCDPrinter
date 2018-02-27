import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class PrinterTest {

    Printer printer = new Printer();

    @Test
    public void shouldGetErrorTextwhenInstructionsNotInFormat(){
        String expected = "Please enter the instructions in the specified format";
        String actual = printer.printLCDNumbers("11");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetTextForNumberOneSizeOne(){
        String expected =   "   \n" +
                            "  |\n" +
                            "   \n" +
                            "  |\n" +
                            "   \n";
        String actual = printer.printLCDNumbers("1,1");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetTextForNumberOneSizeTwo(){
        String expected =   "    \n" +
                "   |\n" +
                "   |\n" +
                "    \n" +
                "   |\n" +
                "   |\n" +
                "    \n";
        String actual = printer.printLCDNumbers("2,1");
        assertEquals(expected, actual);
    }


    @Test
    public void shouldGetTextForNumberOneAndTwoHorizontalSizeFour(){
        String expected =  "       ---- \n" +
                            "     |     |\n" +
                            "     |     |\n" +
                            "     |     |\n" +
                            "     |     |\n" +
                            "       ---- \n" +
                            "     ||     \n" +
                            "     ||     \n" +
                            "     ||     \n" +
                            "     ||     \n" +
                            "       ---- \n";
        String actual = printer.printLCDNumbers("4,12");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetTextForNumberOneAndTwoHorizontalSizeFourTwoTimes(){
        String expected =  "       ---- \n" +
                "     |     |\n" +
                "     |     |\n" +
                "     |     |\n" +
                "     |     |\n" +
                "       ---- \n" +
                "     ||     \n" +
                "     ||     \n" +
                "     ||     \n" +
                "     ||     \n" +
                "       ---- \n";
        String actual = printer.printLCDNumbers("4,12");
        assertEquals(expected, actual);
        String secondResult = printer.printLCDNumbers("4,12");
        assertEquals(expected, secondResult);
    }

    @Test
    public void shouldGetTextForNumberFromOneToTenHorizontalSizeSix(){
        String expected =   " ------          ------  ------          ------  ------  ------  ------  ------ \n" +
                            "|      |       |       |       ||      ||       |              ||      ||      |\n" +
                            "|      |       |       |       ||      ||       |              ||      ||      |\n" +
                            "|      |       |       |       ||      ||       |              ||      ||      |\n" +
                            "|      |       |       |       ||      ||       |              ||      ||      |\n" +
                            "|      |       |       |       ||      ||       |              ||      ||      |\n" +
                            "|      |       |       |       ||      ||       |              ||      ||      |\n" +
                            "                 ------  ------  ------  ------  ------          ------  ------ \n" +
                            "|      |       ||              |       |       ||      |       ||      |       |\n" +
                            "|      |       ||              |       |       ||      |       ||      |       |\n" +
                            "|      |       ||              |       |       ||      |       ||      |       |\n" +
                            "|      |       ||              |       |       ||      |       ||      |       |\n" +
                            "|      |       ||              |       |       ||      |       ||      |       |\n" +
                            "|      |       ||              |       |       ||      |       ||      |       |\n" +
                            " ------          ------  ------          ------  ------          ------  ------ \n";
        String actual = printer.printLCDNumbers("6,0123456789");
        assertEquals(expected, actual);
    }
}
