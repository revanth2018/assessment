package com.charterassessment.domain;

import lombok.Builder;
import lombok.Data;

import java.sql.Date;

@Data
@Builder
public class TransactionDetails {

    public float TransactionAmount;

    public Date date;
}
