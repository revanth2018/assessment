package com.charterassessment.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MonthlyRewards {

    public int rewards;

    public String month;
}
