package pl.sda;

import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.math.RoundingMode;

@AllArgsConstructor
public enum TaxType {
    A(BigDecimal.valueOf(0.23)),
    B(BigDecimal.valueOf(0.08)),
    C(BigDecimal.valueOf(0)),
    D(BigDecimal.valueOf(0.05));

    private BigDecimal taxPercent;


    public BigDecimal computeTaxAmount(BigDecimal amount){
        return amount.multiply(taxPercent)
                .setScale(2, RoundingMode.HALF_UP);
    }

    public String getPercentString(){
        return taxPercent
                .multiply(BigDecimal.valueOf(100))
                .longValue() + "%";
    }
}
