package enums;


public enum NumberLCDPattern {

    ZERO(new String[]{" - ", "| |", "   ", "| |", " - "}),
    ONE(new String[]{"   ", "  |", "   ", "  |", "   "}),
    TWO(new String[]{" - ", "  |", " - ", "|  ", " - "}),
    THREE(new String[]{" - ", "  |", " - ", "  |", " - "}),
    FOUR(new String[]{"   ", "| |", " - ", "  |", "   "}),
    FIVE(new String[]{" - ", "|  ", " - ", "  |", " - "}),
    SIX(new String[]{" - ", "|  ", " - ", "| |", " - "}),
    SEVEN(new String[]{" - ", "  |", "   ", "  |", "   "}),
    EIGHT(new String[]{" - ", "| |", " - ", "| |", " - "}),
    NINE(new String[]{" - ", "| |", " - ", "  |", " - "});

    private String[] lcdPattern;

    NumberLCDPattern(String[] pattern){
        lcdPattern = pattern;
    }

    public String[] getLcdPattern() {
        return lcdPattern.clone();
    }
}
