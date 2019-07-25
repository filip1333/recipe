package pl.sda;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.math.RoundingMode;

@ToString
@Setter
@Getter
@AllArgsConstructor
public class RecipePosition {

    private Product product;
    private BigDecimal quantity;

    public BigDecimal getValue() {
        return quantity.multiply(product.getPrice()).setScale(2, RoundingMode.HALF_UP);
    }
}
