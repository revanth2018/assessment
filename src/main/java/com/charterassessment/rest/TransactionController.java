package com.charterassessment.rest;


import com.charterassessment.domain.TransactionDetails;
import com.charterassessment.service.TransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    private static final Logger LOG = LoggerFactory.getLogger(TransactionController.class);

    /**
     * This Method is for saving User's Transaction details by passing below params
     *
     * @param customerId
     * @param transactionDetails
     * @return
     */
    @PostMapping(value = "saveUserTransaction", produces = "application/json")
    public boolean saveTransactions(@RequestHeader("CustomerId") String customerId, @RequestBody TransactionDetails transactionDetails) {
        LOG.info("Entered into Transaction Controller");

        boolean isSuccess = false;
        isSuccess = transactionService.saveUserTransaction(customerId, transactionDetails);

        return isSuccess;

    }

}
