package pl.sda;

import lombok.AllArgsConstructor;

import java.math.BigDecimal;

import static pl.sda.TaxType.*;

@AllArgsConstructor
public class TaxTablePrinter {
    private Printer printer;



    public void printTaxTable(RecipePosition[] positions) {
        printTaxAmount(positions, A);
        printTaxAmount(positions, B);
        printTaxAmount(positions, C);
        printTaxAmount(positions, D);
        printTaxAmountSummary(positions);
        printer.separate();
    }

    private void printTaxAmount(RecipePosition[] positions, TaxType taxType) {
        BigDecimal sum = summaryValueForTaxType(positions, taxType);
        if (sum.compareTo(BigDecimal.ZERO) != 0) {
            BigDecimal taxValue = taxType.computeTaxAmount(sum);
            String left = "Sp. op. " + taxType + " " + sum + " x " + taxType.getPercentString();
            String right = taxValue.toString();
            printer.printJustify(left, right);
        }
    }

    private BigDecimal summaryValueForTaxType(RecipePosition[] positions, TaxType taxType) {
        BigDecimal sum = BigDecimal.ZERO;

        for (RecipePosition position : positions) {
            if (position.getProduct().getTaxType() == taxType) {
                sum = sum.add(position.getValue());
            }
        }
        return sum;
    }

    private void printTaxAmountSummary(RecipePosition[] positions) {
        BigDecimal sum = A.computeTaxAmount(summaryValueForTaxType(
                positions, A));
        sum = sum.add(B.computeTaxAmount(summaryValueForTaxType(
                positions, B)));
        sum = sum.add(C.computeTaxAmount(summaryValueForTaxType(
                positions, C)));
        sum = sum.add(D.computeTaxAmount(summaryValueForTaxType(
                positions, D)));
        printer.printJustify("Suma PTU", sum.toString());
    }
}
