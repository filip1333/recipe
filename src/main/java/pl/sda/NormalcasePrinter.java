package pl.sda;

public class NormalcasePrinter extends Printer {

    public NormalcasePrinter(int lineLength, PrinterOutput output) {
        super(lineLength, output);
    }

    @Override
    public String prepareString(String string) {
        return string;
    }
}
