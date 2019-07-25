package pl.sda;

public class UppercasePrinter extends Printer{

    public UppercasePrinter(int lineLength, PrinterOutput output) {
        super(lineLength, output);
    }

    @Override
    public String prepareString(String string) {
        return string.toUpperCase();
    }
}
