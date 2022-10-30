package org.learn.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


/**
 * Model class for to describe product
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    /** Unique product identifier **/
    @NotNull(message = "Product ID is mandatory")
    private String productId;

    /** product name **/
    @NotNull(message = "Product name is mandatory")
    private String productName;

    /** product type **/
    @NotNull(message = "Product type is mandatory")
    private String productType;

    /** product color **/
    private String productColor;

//    private enum color {red, green, blue};

    /** product price/cost **/
    @NotNull(message = "Product cost is mandatory")
    @Min(0)
    private float productCost;

    /** availability or the number of products available with salesman **/
    @NotNull(message = "Product quantity is mandatory")
    @Min(0)
    private int quantity;
}
