package enums;

public enum NumberLCDPatternVertical {
    ZERO(new char[]{' ', '-', ' ', '|', ' ', '|', ' ', ' ', ' ', '|', ' ', '|', ' ', '-', ' '}),
    ONE(new char[]{' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' '}),
    TWO(new char[]{' ', '-', ' ', ' ', ' ', '|', ' ', '-', ' ', '|', ' ', ' ', ' ', '-', ' '}),
    THREE(new char[]{' ', '-', ' ', ' ', ' ', '|', ' ', '-', ' ', ' ', ' ', '|', ' ', '-', ' '}),
    FOUR(new char[]{' ', ' ', ' ', '|', ' ', '|', ' ', '-', ' ', ' ', ' ', '|', ' ', ' ', ' '}),
    FIVE(new char[]{' ', '-', ' ', '|', ' ', ' ', ' ', '-', ' ', ' ', ' ', '|', ' ', '-', ' '}),
    SIX(new char[]{' ', '-', ' ', '|', ' ', ' ', ' ', '-', ' ', '|', ' ', '|', ' ', '-', ' '}),
    SEVEN(new char[]{' ', '-', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' '}),
    EIGHT(new char[]{' ', '-', ' ', '|', ' ', '|', ' ', '-', ' ', '|', ' ', '|', ' ', '-', ' '}),
    NINE(new char[]{' ', '-', ' ', '|', ' ', '|', ' ', '-', ' ', ' ', ' ', '|', ' ', '-', ' '});

    private char[] lcdPattern;

    NumberLCDPatternVertical(char [] pattern){
        lcdPattern = pattern;
    }

    public char[] getLcdPattern() {
        return lcdPattern.clone();
    }
}