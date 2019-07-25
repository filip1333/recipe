package pl.sda;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Product {
    private String name;
    private BigDecimal price;
    private TaxType taxType;
    private String unit;
}
