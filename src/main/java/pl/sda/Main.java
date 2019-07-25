package pl.sda;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static pl.sda.TaxType.*;

public class Main {

    public static void main(String[] args) {
        Company company = getCompany();
        Shop shop = getShop(company);

        RecipePosition[] positions = {
                new RecipePosition(new Product("PC", BigDecimal.valueOf(3999.99), A, "arts"), BigDecimal.valueOf(3)),
                new RecipePosition(new Product("Assembly, transport and installation of a personal computer", BigDecimal.valueOf(50), B, "serv"), BigDecimal.valueOf(3)),
                new RecipePosition(new Product("Instruction of using PC ", BigDecimal.valueOf(1499.89), B, "usł"), BigDecimal.valueOf(1)),
                new RecipePosition(new Product("Coolant for computer", BigDecimal.valueOf(14.99), D, "kg"), BigDecimal.valueOf(1))
        };

        Printer printer40 = new UppercasePrinter(40, new ConsolePrinterOutput());
        RecipePrinter recipePrinter40 = new RecipePrinter(shop, printer40);

        recipePrinter40.print(positions);

        Printer printer60 = new NormalcasePrinter(60, new ConsolePrinterOutput());
        RecipePrinter recipePrinter60 = new RecipePrinter(shop, printer60);

        recipePrinter60.print(positions);

        Printer printerToFile = new NormalcasePrinter(
                55, new FilePrinterOutput("data/recipe.txt"));
        new RecipePrinter(shop, printerToFile).print(positions);
    }

    private static Shop getShop(Company company) {
        Shop shop = null;

        try {
            List<String> strings = Files.readAllLines(Paths.get("data/shop.txt"));
            shop = new Shop(strings.get(0), strings.get(1), strings.get(2), strings.get(3), strings.get(4), company);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return shop;
    }

    private static Company getCompany() {
        Company company = null;
        try {
            List<String> strings = Files.readAllLines(Paths.get("data/company.txt"));
            company = new Company(
                    strings.get(0),
                    strings.get(1),
                    strings.get(2),
                    strings.get(3)
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
        return company;
    }

}
