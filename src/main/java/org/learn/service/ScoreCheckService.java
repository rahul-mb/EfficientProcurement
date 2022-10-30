package org.learn.service;

import org.learn.model.Product;
import org.learn.model.ProductScore;
import org.learn.model.ScoreCheckRequest;
import org.learn.model.ScoreCheckResponse;
import org.learn.strategy.Context;
import org.learn.strategy.MobileDeviceStrategy;
import org.learn.strategy.NonPortableDeviceStrategy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Service instance to actually calculate the average price and total prices.
 */
@Service
public class ScoreCheckService{

    /** product type **/
    private final float thresholdPercentage = 50;

    public ScoreCheckResponse scoreCheck(final ScoreCheckRequest scoreCheckRequest){
        ScoreCheckResponse scoreCheckResponse = new ScoreCheckResponse();
        List<ProductScore> selectedProduct = new ArrayList<>();

        for(Product product : scoreCheckRequest.getProducts()){
            ProductScore productScore = new ProductScore();
            if(product.getProductType() == 1){
                Context context = new Context(new MobileDeviceStrategy());
                productScore = context.getScore(product);
            }else if (product.getProductType() == 2){
                Context context = new Context(new NonPortableDeviceStrategy());
                productScore = context.getScore(product);
            }else{
                /**
                 * this is the part for the device of type other than portable or non-portable devices
                 * for example kitchen devices like toaster. Currently they are out of scope
                 */
                continue;
            }

            if(productScore.getScorePercentage()>= thresholdPercentage){
                selectedProduct.add(productScore);
            }
        }
        scoreCheckResponse.setSelectedProducts(selectedProduct);
        calculateScores(selectedProduct, scoreCheckResponse);
        return scoreCheckResponse;
    }

    /**
     * This method calculates the average price and total price
     * @param selectedProduct
     * @param scoreCheckResponse
     */
    private void calculateScores(List<ProductScore> selectedProduct, ScoreCheckResponse scoreCheckResponse){
        float totalPrice = 0;
        int totalNumberOfProducts = 0;
        for(ProductScore productScore : selectedProduct){
            totalPrice = totalPrice + (productScore.getProduct().getProductCost() * productScore.getProduct().getQuantity());
            totalNumberOfProducts = totalNumberOfProducts + productScore.getProduct().getQuantity();
        }
        scoreCheckResponse.setTotalPrice(totalPrice);
        scoreCheckResponse.setAveragePrice(totalPrice/totalNumberOfProducts);
    }
}

