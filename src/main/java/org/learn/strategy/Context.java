package org.learn.strategy;

import org.learn.model.Product;
import org.learn.model.ProductScore;

/**
 * Inteface which will help to decide the strategy which will be applied to check the conditions on the basis of product type
 */
public class Context {

    /** strategy which will be used to check the rules    **/
    private final Strategy strategy;

    /**
     * its a constructor which will collect the decided strategy
     * @param strategy
     */
    public Context(Strategy strategy){
        this.strategy = strategy;
    }

    /**
     * this method will execute the chosen strategy for the product
     * @param product
     * @return
     */
    public ProductScore getScore(Product product){
        return strategy.getProductScore(product);
    }
}
