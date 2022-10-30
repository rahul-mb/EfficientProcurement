package org.learn.model;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Model class for request to scoreCheck endpoint
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ScoreCheckRequest {
    /** List of product instance **/
    @Valid
    @NotNull
    public List<Product> products;
}
