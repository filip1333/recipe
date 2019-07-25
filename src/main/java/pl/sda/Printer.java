package pl.sda;

public abstract class Printer {

    private int lineLength;
    private PrinterOutput output;

    public Printer(int lineLength, PrinterOutput output) {
        this.lineLength = lineLength;
        this.output = output;
    }

    public abstract String prepareString(String string);

    public void print(String string) {
        if (string.length() > lineLength) {
            string = string
                    .substring(0, lineLength - 3)
                    + "...";
        }
        printLine(prepareString(string));
    }

    public void printCenter(String string) {
        int stringLength = string.length();
        int freeSpaces = lineLength - stringLength;
        int marginLength = freeSpaces / 2;

        printSpaces(marginLength);
        printLine(prepareString(string));
    }

    public void printJustify(String string1, String string2) {
        int spaceBetweenWords = lineLength -
                string1.length() - string2.length();

        printString(prepareString(string1));
        printSpaces(spaceBetweenWords);
        printLine(prepareString(string2));
    }


    private void printSpaces(int spaceBetweenWords) {
        for (int i = 0; i < spaceBetweenWords; i++) {
            printString(" ");
        }
    }

    public void separate() {
        for (int i = 0; i < lineLength; i++) {
            printString("-");
        }
        printLine("");
    }

    private void printLine(String string) {
        output.println(string);
    }

    private void printString(String string) {
        output.print(string);
    }
}
