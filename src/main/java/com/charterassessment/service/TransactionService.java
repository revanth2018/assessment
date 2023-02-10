package com.charterassessment.service;

import com.charterassessment.domain.MonthlyRewards;
import com.charterassessment.domain.RewardDetails;
import com.charterassessment.domain.TransactionDetails;
import com.charterassessment.entity.Transaction;
import com.charterassessment.entity.User;
import com.charterassessment.repository.TransactionRepository;
import com.charterassessment.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.math.BigDecimal.valueOf;


@Service
public class TransactionService {

    private static final Logger LOG = LoggerFactory.getLogger(TransactionService.class);
    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    UserRepository userRepository;
    private final BigDecimal hundredDollarSpent = valueOf(100);
    private final BigDecimal twoDollarReward = valueOf(2);
    private final BigDecimal oneDollarReward = valueOf(1);
    private final BigDecimal fiftyDollarSpent = valueOf(50);

    public boolean saveUserTransaction(String customerId, TransactionDetails transactionDetails) {

        Transaction transaction = new Transaction();

        transaction.setTransactionDate(transactionDetails.getDate());
        transaction.setCustomerId(customerId);
        transaction.setAmount(transactionDetails.getTransactionAmount());
        transactionRepository.save(transaction);

        boolean isSuccess = true;
        LOG.info("Transaction successfully Saved for customer id", transaction.getCustomerId());

        return isSuccess;

    }

    public RewardDetails fetchRewardsByCustomerId(String customerID) {

        List<Transaction> transactions = transactionRepository.findAllByCustomerId(customerID);
        Map<Integer, DoubleSummaryStatistics> intermediate = transactions.stream()
                .collect(Collectors.groupingBy(tr -> tr.getTransactionDate().getMonth(),
                        Collectors.summarizingDouble(Transaction::getAmount)));
        RewardDetails details = new RewardDetails();
        List<MonthlyRewards> monthlyRewardsList = new ArrayList<>();

        for (Map.Entry<Integer, DoubleSummaryStatistics> entry : intermediate.entrySet()) {
            monthlyRewardsList.add(new MonthlyRewards(calculateRewards(BigDecimal.valueOf(entry.getValue().getSum())),
                    new DateFormatSymbols().getMonths()[entry.getKey()]));
        }
        details.setMonthlyRewards(monthlyRewardsList);
        details.setTotalRewards(monthlyRewardsList.stream().mapToInt(MonthlyRewards::getRewards).sum());
        User user = userRepository.findByCustomerId(customerID);
        details.setFirstName(user.getFirstName());
        details.setLastName(user.getLastName());
        return details;
    }


    protected int calculateRewards(BigDecimal amountSpent) {
        int rewards = 0;
        if (amountSpent.compareTo(fiftyDollarSpent) > 0 && amountSpent.compareTo(hundredDollarSpent) <= 0) {
            rewards += (oneDollarReward.multiply(amountSpent.subtract(fiftyDollarSpent))).intValue();
        }
        if (amountSpent.compareTo(hundredDollarSpent) > 0) {
            rewards += (twoDollarReward.multiply(amountSpent.subtract(hundredDollarSpent))).intValue() + 50;
        }
        return rewards;
    }

}
