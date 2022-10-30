package org.learn.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * Model class for to describe product score
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductScore {
    /** product instance **/
    private Product product;

    /** product score calculated considering considering conditions **/
    private float score;

    /** score percentage calculated depending on the number of conditions matched out of a rule **/
    private float scorePercentage;
}
