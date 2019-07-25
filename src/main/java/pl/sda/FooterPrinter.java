package pl.sda;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class FooterPrinter {
    private Printer printer;

    public FooterPrinter(Printer printer) {
        this.printer = printer;
    }

    public void printFooter(RecipePosition[] positions) {
        BigDecimal sum = BigDecimal.ZERO;
        for (RecipePosition position : positions) {
            sum = sum.add(position.getValue());
        }
        sum = sum.setScale(2, RoundingMode.HALF_UP);
        printer.printJustify("Sum PLN", sum.toString());
        printer.separate();

        LocalTime hour = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        printer.printJustify("Time", hour.format(formatter));

        printer.printCenter("CONTROL NUMBER");
        printer.printCenter("#" + UUID.randomUUID().toString() + "#");
        printer.printCenter("BBH 104267834");

        printer.printJustify("Cash", sum.toString());
    }
}
