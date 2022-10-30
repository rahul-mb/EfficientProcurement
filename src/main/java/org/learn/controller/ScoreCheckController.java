package org.learn.controller;

import lombok.AllArgsConstructor;
import org.learn.model.ScoreCheckRequest;
import org.learn.model.ScoreCheckResponse;
import org.learn.service.ScoreCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller to calculate the average price and total price
 */
@RestController
@AllArgsConstructor
public class ScoreCheckController {

    /** service instance   **/
    private ScoreCheckService scoreCheckService;

    /**
     * endpoint to calculate the average price and total price
     * @param scoreCheckRequest
     * @return instance of ScoreCheckResponse
     */
    @PostMapping("/scoreCheck")
    public ScoreCheckResponse scoreCheck(@RequestBody ScoreCheckRequest scoreCheckRequest){
        return scoreCheckService.scoreCheck(scoreCheckRequest);
    }
}
