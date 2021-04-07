/******************************************************************************
 * Copyright (c) 2021.                                                        *
 * This code is created on educational purposes and for sure is strongly      *
 * protected and something else about something else                          *
 ******************************************************************************/

package labs.pm.data;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @author Artur Bakhmanov
 * @version 6.0
 */
public final class Food extends Product {
    private LocalDate bestBefore;

    Food(int id, String name, BigDecimal price, Rating rating, LocalDate bestBefore) {
        super(id, name, price, rating);
        this.bestBefore = bestBefore;
    }

    /**
     * Get the value of the best before value of the product
     * <p>
     * return the value of bestBefore
     */
    public LocalDate getBestBefore() {
        return bestBefore;
    }

    //    public Food() {
//        super();
//    }

    /**
     * Calculates discount based on a product price, product type and
     * {@link DISCOUNT_RATE discount rate}
     *
     * @return a {@link BigDecimal BigDecimal} value of the discount
     */
    @Override
    public BigDecimal getDiscount() {
        return (bestBefore.isEqual(LocalDate.now())) ? super.getDiscount() : BigDecimal.ZERO;
    }

    @Override
    public Product applyRating(Rating newRating) {
        return new Food(getId(), getName(), getPrice(), newRating, bestBefore);
    }

    @Override
    public String toString() {
        return super.toString() + ", " + bestBefore;
    }


}
