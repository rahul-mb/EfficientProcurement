package org.learn.strategy;

import org.learn.model.Product;
import org.learn.model.ProductScore;

import java.util.function.Predicate;

/**
 * This class is a dedicated strategy to check the rules for
 * products of type 2 i.e. non-portable devices
 */
public class NonPortableDeviceStrategy implements Strategy{

    final static float totalScore = 100;
    final static float totalConditions = 2;
    
    private float numOfConditionsMatched = 0;

    private Predicate<Product> costCheck = p -> p.getProductCost() <= 500;

    private Predicate<Product> quantityCheck = p -> p.getQuantity() > 400;


    /**
     * @param product
     * @return
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
