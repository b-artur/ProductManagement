/******************************************************************************
 * Copyright (c) 2021.                                                        *
 * This code is created on educational purposes and for sure is strongly      *
 * protected and something else about something else                          *
 ******************************************************************************/

package labs.pm.data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * @author Artur Bakhmanov
 * @version 6.0
 */
public final class Drink extends Product {
    Drink(int id, String name, BigDecimal price, Rating rating) {
        super(id, name, price, rating);
    }

    /**
     * Calculates discount based on a product price, product type and
     * {@link DISCOUNT_RATE discount rate}
     *
     * @return a {@link BigDecimal BigDecimal} value of the discount
     */
    @Override
    public BigDecimal getDiscount() {
        LocalTime now = LocalTime.now();
        return (now.isAfter(LocalTime.of(17, 30)) && now.isBefore(LocalTime.of(18, 30)))
                ? super.getDiscount() : BigDecimal.ZERO;
    }

    @Override
    public Product applyRating(Rating newRating) {
        return new Drink(getId(), getName(), getPrice(), newRating);
    }
}
