package pl.sda;

public class RecipePrinter {
    private Shop shop;
    private HeaderPrinter headerPrinter;
    private ProductTablePrinter productPrinter;
    private TaxTablePrinter taxPrinter;
    private FooterPrinter footerPrinter;

    public RecipePrinter(Shop shop, Printer printer){
        this.shop = shop;
        headerPrinter = new HeaderPrinter(printer);
        productPrinter = new ProductTablePrinter(printer);
        taxPrinter = new TaxTablePrinter(printer);
        footerPrinter = new FooterPrinter(printer);
    }

    public void print(RecipePosition[] positions){
        headerPrinter.printHeader(shop);
        productPrinter.printTableHeader();
        productPrinter.printProductTable(positions);
        taxPrinter.printTaxTable(positions);
        footerPrinter.printFooter(positions);
    }

}
