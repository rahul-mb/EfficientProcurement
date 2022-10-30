package org.learn.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * Model class for to describe product
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    /** Unique product identifier **/
    private int productId;

    /** product name **/
    private String productName;

    /** product type **/
    private int productType;

    /** product color **/
    private String productColor;

//    private enum color {red, green, blue};

    /** product price/cost **/
    private float productCost;

    /** availability or the number of products available with salesman **/
    private int quantity;
}
