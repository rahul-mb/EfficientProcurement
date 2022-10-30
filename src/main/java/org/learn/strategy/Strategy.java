package org.learn.strategy;

import org.learn.model.Product;
import org.learn.model.ProductScore;

/**
 * This is a strategy interface which will be implemented by two different classes
 * i.e MobilePhoneStrategy and TelevisionStrategy.
 */
public interface Strategy {

    /**
     * its method declaration of an interface which calculates the score and score percentage
     * which matches with the rule specific to product type
     * @param product
     * @return
     */
    public ProductScore getProductScore(Product product);
}
