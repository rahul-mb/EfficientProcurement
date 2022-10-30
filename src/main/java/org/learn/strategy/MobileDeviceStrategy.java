package org.learn.strategy;

import org.learn.model.Product;
import org.learn.model.ProductScore;

import java.util.function.Predicate;

/**
 * This class is a dedicated strategy to check the rules for
 * products of type 1 i.e. hand held devices or portable devices
 */
public class MobileDeviceStrategy implements Strategy{

    /** total Score given to the rule **/
    final static float totalScore = 300;

    /** total number of the conditions in the rule **/
    final static float totalConditions = 2;

    /** total number of conditions which are matched actually with product **/
    private float numOfConditionsMatched = 0;

    /** predicate to verify the rule of product cost **/
    private Predicate<Product> costCheck = p -> p.getProductCost() <= 300;

    /** predicate to verify the rule of quantity **/
    private Predicate<Product> quantityCheck = p -> p.getQuantity() > 1000;


    /**
     * this method check the matching of conditions with input product
     * and shares back the score and its score percentage of rule which matched.
     * @param product
     * @return instance of ProductScore
     */
    @Override
    public ProductScore getProductScore(Product product) {
        ProductScore productScore = new ProductScore();
        if(costCheck.test(product)){
            numOfConditionsMatched++;
        }

        if(quantityCheck.test(product)){
            numOfConditionsMatched++;
        }

        productScore.setScore((numOfConditionsMatched/totalConditions)*totalScore);
        productScore.setProduct(product);
        productScore.setScorePercentage((productScore.getScore()/totalScore)*100);
        return productScore;
    }
}
