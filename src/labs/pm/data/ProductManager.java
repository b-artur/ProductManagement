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
public class ProductManager {

    public Product createProduct(int id, String name, BigDecimal price, Rating rating, LocalDate bestBefore) {
        return new Food(id, name, price, rating, bestBefore);
    }

    public Product createProduct(int id, String name, BigDecimal price, Rating rating) {
        return new Drink(id, name, price, rating);
    }
}
