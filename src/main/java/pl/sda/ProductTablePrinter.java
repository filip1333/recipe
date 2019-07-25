package pl.sda;

import lombok.AllArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
public class ProductTablePrinter {

    private Printer printer;


    public void printTableHeader() {
        printer.separate();
        printer.printCenter("Fiscal Receipt");
        printer.printJustify("Name    Quantity x Price", "Value    PTU");
        printer.separate();
    }

    public void printProductTable(RecipePosition[] positions) {
        for (RecipePosition position : positions) {
            Product product = position.getProduct();
            printer.print(product.getName());

            BigDecimal quantity = position.getQuantity();
            String unit = product.getUnit();
            BigDecimal price = product.getPrice();
            String left = "  " + quantity + " " + unit + " x " + price;

            BigDecimal value = position.getValue();
            TaxType taxType = product.getTaxType();
            String right = value + " " + taxType;

            printer.printJustify(left, right);
        }
        printer.separate();
    }
}
