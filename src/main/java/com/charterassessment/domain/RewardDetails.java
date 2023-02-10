package com.charterassessment.domain;


import lombok.Data;

import java.util.List;

@Data
public class RewardDetails {

    public String firstName;
    public String lastName;
    public List<MonthlyRewards> monthlyRewards;
    public float totalRewards;


}
