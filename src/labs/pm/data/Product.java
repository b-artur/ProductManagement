/*-----------------------------------------------------------------------------
 - This code is created on educational purposes and for sure is strongly      -
 - protected and something else about something else                          -
 - Copyright (c) Artur Bakhmanov 2021.                                        -
 -----------------------------------------------------------------------------*/

package labs.pm.data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

import static java.math.RoundingMode.HALF_UP;
import static labs.pm.data.Rating.*;

/**
 * {@code Product} class represents properties and behaviors of
 * product objects in the Product Management System.
 * <br>
 * Each product has an id, name and price
 * <br>
 * Each product can have a discount calculated based on a
 * {@link #DISCOUNT_RATE discount rate}
 *
 * @author Artur Bakhmanov
 * @version 4.0
 */

public abstract class Product implements Rateable<Product>, Serializable {

    /**
     * A constant that defines a {@link java.math.BigDecimal BigDecimal} value
     * of the discount rate
     * <br>
     * Discount rate is 10%
     */
    public static final BigDecimal DISCOUNT_RATE = BigDecimal.valueOf(0.1);
    private int id;
    private String name;
    private BigDecimal price;
    private Rating rating;


    Product(int id, String name, BigDecimal price, Rating rating) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.rating = rating;
    }

    Product(int id, String name, BigDecimal price) {
        this(id, name, price, NOT_RATED);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public BigDecimal getPrice() {
        return price;
    }


    /**
     * Calculates discount based on a product price and
     * {@link #DISCOUNT_RATE discount rate}
     *
     * @return a {@link java.math.BigDecimal BigDecimal} value of the discount
     */
    public BigDecimal getDiscount() {
        return price.multiply(DISCOUNT_RATE).setScale(2, HALF_UP);
    }

    @Override
    public Rating getRating() {
        return rating;
    }


    /**
     * Get the value of the best before value of the product
     * <p>
     * return the value of bestBefore
     */
    public LocalDate getBestBefore() {
        return LocalDate.now();
    }

    @Override
    public String toString() {
        return id + " " + name + " " + price + " " + getDiscount() + " " + getRating().getStars() + " " + getBestBefore();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Product)) return false;
        Product product = (Product) obj;
        return id == product.id; // && Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
