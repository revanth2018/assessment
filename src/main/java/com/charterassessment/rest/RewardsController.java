package com.charterassessment.rest;


import com.charterassessment.domain.RewardDetails;
import com.charterassessment.service.TransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class RewardsController {

    @Autowired
    TransactionService transactionService;

    private static final Logger LOG = LoggerFactory.getLogger(TransactionController.class);

    /**
     * Pass customer Id in order to get rewards for each customer
     *
     * @param customerID id for user.
     */
    @GetMapping(value = "getRewards", produces = {"application/json"})
    public RewardDetails getRewards(@RequestHeader("CustomerID") String customerID) {

        LOG.info("Requesting for use's rewards");

        return transactionService.fetchRewardsByCustomerId(customerID);

    }

}
