package org.learn.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

/**
 * Model class for response from the endpoint scoreCheck
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ScoreCheckResponse {
    /** Average price of the products selected from a salesman which are matching the conditions as per threshold **/
    public float averagePrice;

    /** total price of the products which are meeting the conditions more than threshold **/
    public float totalPrice;

    /** List of products which are selected **/
    public List<ProductScore> selectedProducts;
}
