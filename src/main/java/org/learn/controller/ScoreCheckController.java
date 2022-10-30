package org.learn.controller;

import lombok.AllArgsConstructor;
import org.learn.model.ScoreCheckRequest;
import org.learn.model.ScoreCheckResponse;
import org.learn.service.ScoreCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Controller to calculate the average price and total price
 */
@RestController
@RequestMapping("/efficientProcurement")
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
    public ResponseEntity<ScoreCheckResponse> scoreCheck(@RequestBody @Valid ScoreCheckRequest scoreCheckRequest){
        return ResponseEntity.ok(scoreCheckService.scoreCheck(scoreCheckRequest));
    }
}
