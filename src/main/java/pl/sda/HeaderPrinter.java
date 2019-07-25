package pl.sda;

import java.time.LocalDate;

public class HeaderPrinter {

    private Printer printer;

    public HeaderPrinter(Printer printer) {
        this.printer = printer;
    }

    public void printHeader(Shop shop) {
        printer.printCenter(shop.getCompany().getName());
        printer.printCenter(shop.getCompany().getFullAddress());
        printer.printCenter(shop.getName());
        printer.printCenter(shop.getAddress());
        printer.printCenter(shop.getContactInfo());
        printer.printCenter("NIP " + shop.getNip());

        LocalDate now = LocalDate.now();
        printer.printJustify(now.toString(), "124");
    }
}
